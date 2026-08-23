#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(git rev-parse --show-toplevel)"

# 인자가 하나뿐이고 YYYY-MM 형식이 아니면 "날짜 생략 + 모델명만 전달"로 간주한다.
# (호출자가 항상 모델명을 채우고 날짜는 대개 생략하는 실사용 패턴 때문 — 이 경우
#  positional 인자만으로는 $1이 날짜 자리인지 모델명 자리인지 구분이 안 됨)
if [[ $# -eq 1 && ! "$1" =~ ^[0-9]{4}-(0[1-9]|1[0-2])$ ]]; then
  TARGET="$(date +%Y-%m)"
  CO_AUTHOR="$1"
else
  TARGET="${1:-$(date +%Y-%m)}"
  CO_AUTHOR="${2:-Claude Code}"
fi

if [[ ! "$TARGET" =~ ^[0-9]{4}-(0[1-9]|1[0-2])$ ]]; then
  echo "invalid month format: $TARGET (expected YYYY-MM)" >&2
  exit 1
fi

MODULE_DIR="$REPO_ROOT/$TARGET"

if [[ -e "$MODULE_DIR" ]]; then
  echo "already exists: $MODULE_DIR — nothing to do" >&2
  exit 1
fi

mkdir -p "$MODULE_DIR/src"

MODULE_CONTENT=$(cat <<'EOF'
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
)
printf '%s' "$MODULE_CONTENT" > "$MODULE_DIR/$TARGET.iml"

MODULES_XML="$REPO_ROOT/.idea/modules.xml"
if [[ -f "$MODULES_XML" ]]; then
  MODULE_LINE="      <module fileurl=\"file://\$PROJECT_DIR\$/$TARGET/$TARGET.iml\" filepath=\"\$PROJECT_DIR\$/$TARGET/$TARGET.iml\" />"
  awk -v line="$MODULE_LINE" '{ if ($0 ~ /<\/modules>/) print line; print }' "$MODULES_XML" > "$MODULES_XML.tmp"
  mv "$MODULES_XML.tmp" "$MODULES_XML"
else
  echo "warning: $MODULES_XML not found, skipped registration" >&2
fi

cd "$REPO_ROOT"
git add "$TARGET/$TARGET.iml"
if ! git commit -m "$(printf 'chore: %s 모듈 세팅\n\nCo-Authored-By: %s <noreply@anthropic.com>' "$TARGET" "$CO_AUTHOR")"; then
  echo "error: git commit 실패 — $MODULE_DIR/, .iml, git add는 이미 완료된 상태로 남아있음." >&2
  echo "        (재시도해도 already-exists로 막힘 — 'git commit' 직접 마무리하거나, 완전히 되돌리려면 디렉터리를 지우고 modules.xml에서 등록도 제거할 것)" >&2
  exit 1
fi

echo "done: $TARGET"
