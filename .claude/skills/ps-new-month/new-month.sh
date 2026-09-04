#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(git rev-parse --show-toplevel)"

# 인자가 하나뿐이고 YYYY-MM 형식이 아니면 "날짜 생략 + 모델명만 전달"로 간주한다.
# (호출자는 항상 모델명을 채우고 날짜는 대개 생략하는 실사용 패턴 — 이 경우
#  positional 인자만으로는 $1이 날짜 자리인지 모델명 자리인지 구분이 안 됨)
MONTH_RE='^[0-9]{4}-(0[1-9]|1[0-2])$'
if [[ $# -eq 1 && ! "$1" =~ $MONTH_RE ]]; then
  TARGET="$(date +%Y-%m)"
  CO_AUTHOR="$1"
else
  TARGET="${1:-$(date +%Y-%m)}"
  CO_AUTHOR="${2:-Claude Code}"
fi

if [[ ! "$TARGET" =~ $MONTH_RE ]]; then
  echo "invalid month format: $TARGET (expected YYYY-MM)" >&2
  exit 1
fi

MODULE_DIR="$REPO_ROOT/$TARGET"
IML_REL="$TARGET/$TARGET.iml"

if [[ -e "$MODULE_DIR" ]]; then
  echo "already exists: $MODULE_DIR — nothing to do" >&2
  exit 1
fi

# --- 1. 디렉터리 + .iml 생성 ------------------------------------------------
# 다른 달의 .iml 과 바이트 단위로 동일해야 한다: '$MODULE_DIR$' 는 IntelliJ 매크로라
# 셸이 건드리면 안 되고(따옴표 친 heredoc), 파일 끝에 개행을 넣지 않는다(기존 파일과 일치).
mkdir -p "$MODULE_DIR/src"
printf '%s' "$(cat <<'EOF'
<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4">
  <component name="NewModuleRootManager" inherit-compiler-output="true">
    <exclude-output />
    <content url="file://$MODULE_DIR$">
      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
    </content>
    <orderEntry type="inheritedJdk" />
    <orderEntry type="sourceFolder" forTests="false" />
  </component>
</module>
EOF
)" > "$MODULE_DIR/$TARGET.iml"

# --- 2. .idea/modules.xml 등록 (로컬 전용, .gitignore 대상) ----------------
MODULES_XML="$REPO_ROOT/.idea/modules.xml"
if [[ ! -f "$MODULES_XML" ]]; then
  echo "warning: $MODULES_XML not found — 등록 건너뜀" >&2
elif grep -qF "/$IML_REL\"" "$MODULES_XML"; then
  echo "note: $TARGET 이 modules.xml 에 이미 등록돼 있음 — 등록 건너뜀" >&2
else
  MODULE_LINE="      <module fileurl=\"file://\$PROJECT_DIR\$/$IML_REL\" filepath=\"\$PROJECT_DIR\$/$IML_REL\" />"
  awk -v line="$MODULE_LINE" '/<\/modules>/ { print line } { print }' "$MODULES_XML" > "$MODULES_XML.tmp"
  mv "$MODULES_XML.tmp" "$MODULES_XML"
fi

# --- 3. 커밋 (.iml 하나만) ------------------------------------------------
# 새 .iml 은 untracked 라 먼저 add 해야 하고, 커밋엔 경로를 못박아 인덱스에 있던
# 다른 staged 변경이 "chore: 모듈 세팅" 커밋에 섞이지 않게 한다.
cd "$REPO_ROOT"
git add -- "$IML_REL"
COMMIT_MSG="$(printf 'chore: %s 모듈 세팅\n\nCo-Authored-By: %s <noreply@anthropic.com>' "$TARGET" "$CO_AUTHOR")"
if ! git commit -m "$COMMIT_MSG" -- "$IML_REL"; then
  echo "error: git commit 실패 (pre-commit hook 거부 등)." >&2
  echo "       $MODULE_DIR/ 생성 · $IML_REL staged · modules.xml 등록까지는 끝난 상태다." >&2
  echo "       재시도는 already-exists 로 막힌다 — 'git commit -- $IML_REL' 로 직접 마무리하거나," >&2
  echo "       되돌리려면 디렉터리를 지우고(git rm --cached 포함) modules.xml 등록 줄도 제거할 것." >&2
  exit 1
fi

echo "done: $TARGET"
