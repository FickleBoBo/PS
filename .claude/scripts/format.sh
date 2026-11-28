#!/bin/bash
# 지정한 풀이만 에디터와 같은 포매터로 정렬한다.
#   Java   IntelliJ format.sh (기본 스타일)
#   C++    cpptools 에 든 clang-format + .clang-format
#   Python ruff 확장에 든 ruff + ruff.toml (fixAll → organizeImports → format)
#
# 사용: format.sh [--check] <파일|폴더>...
#   --check  파일을 바꾸지 않고, 바뀔 파일만 출력한다 (있으면 종료 코드 1)
# live_ 폴더는 대회 코드 보존 대상이라 건너뛴다.
set -euo pipefail

ROOT=$(cd "$(dirname "$0")/../.." && pwd -P)
IDEA_FORMAT="/Applications/IntelliJ IDEA.app/Contents/bin/format.sh"

die() {
    echo "format.sh: $*" >&2
    exit 2
}

latest() {
    ls -d "$@" 2>/dev/null | sort -V | tail -1
}

check=0
if [ "${1:-}" = "--check" ]; then
    check=1
    shift
fi
[ $# -gt 0 ] || die "대상 파일이나 폴더를 지정해야 한다 (인자 없이 전체를 포맷하지 않는다)"

TMP=$(mktemp -d)
trap 'rm -rf "$TMP"' EXIT

# 대상 수집 (레포 기준 상대 경로)
for arg in "$@"; do
    [ -e "$arg" ] || die "없는 경로: $arg"
    if [ -d "$arg" ]; then
        abs=$(cd "$arg" && pwd -P)
    else
        abs=$(cd "$(dirname "$arg")" && pwd -P)/$(basename "$arg")
    fi
    case "$abs/" in
        "$ROOT/"*) ;;
        *) die "레포 밖 경로: $arg" ;;
    esac
    find "$abs" -type f \( -name '*.java' -o -name '*.cpp' -o -name '*.py' \) ! -path '*/live_*'
done | sed "s|^$ROOT/||" | sort -u >"$TMP/files"
[ -s "$TMP/files" ] || die "포맷할 파일이 없다"

# --check 는 사본에서 돌린 뒤 원본과 비교한다
if [ $check -eq 1 ]; then
    work="$TMP/tree"
    mkdir -p "$work"
    cp "$ROOT/.clang-format" "$ROOT/ruff.toml" "$work/"
    while IFS= read -r f; do
        mkdir -p "$work/$(dirname "$f")"
        cp "$ROOT/$f" "$work/$f"
    done <"$TMP/files"
else
    work="$ROOT"
fi

java=()
cpp=()
py=()
while IFS= read -r f; do
    case "$f" in
        *.java) java+=("$work/$f") ;;
        *.cpp) cpp+=("$work/$f") ;;
        *.py) py+=("$work/$f") ;;
    esac
done <"$TMP/files"

# 바뀐 파일을 알아내기 위한 원본 사본
mkdir -p "$TMP/before"
i=0
while IFS= read -r f; do
    i=$((i + 1))
    cp "$work/$f" "$TMP/before/$i"
done <"$TMP/files"

if [ ${#cpp[@]} -gt 0 ]; then
    cf=$(latest "$HOME"/.vscode/extensions/ms-vscode.cpptools-*/LLVM/bin/clang-format)
    [ -x "$cf" ] || die "cpptools 의 clang-format 을 찾지 못했다"
    "$cf" -style=file -i "${cpp[@]}"
fi

if [ ${#py[@]} -gt 0 ]; then
    ruff=$(latest "$HOME"/.vscode/extensions/charliermarsh.ruff-*/bundled/libs/bin/ruff)
    [ -x "$ruff" ] || die "ruff 확장의 ruff 를 찾지 못했다"
    "$ruff" check --no-cache --fix --exit-zero -q "${py[@]}" >/dev/null
    "$ruff" check --no-cache --select I --fix --exit-zero -q "${py[@]}" >/dev/null
    "$ruff" format --no-cache -q "${py[@]}"
fi

if [ ${#java[@]} -gt 0 ]; then
    [ -x "$IDEA_FORMAT" ] || die "IntelliJ format.sh 를 찾지 못했다: $IDEA_FORMAT"
    # 실행 중인 IDE 와 겹치지 않도록 설정·캐시 폴더를 따로 준다
    for d in config system log plugins; do
        echo "idea.$d.path=$TMP/idea-$d"
    done >"$TMP/idea.properties"
    IDEA_PROPERTIES="$TMP/idea.properties" "$IDEA_FORMAT" -allowDefaults "${java[@]}" >"$TMP/idea.out" 2>&1 || {
        tail -20 "$TMP/idea.out" >&2
        die "IntelliJ 포매터 실패"
    }
    grep -q "^${#java[@]} file(s) scanned" "$TMP/idea.out" || {
        tail -20 "$TMP/idea.out" >&2
        die "IntelliJ 포매터가 대상 ${#java[@]}개를 모두 처리하지 않았다"
    }
fi

changed=0
i=0
while IFS= read -r f; do
    i=$((i + 1))
    if ! cmp -s "$TMP/before/$i" "$work/$f"; then
        changed=$((changed + 1))
        echo "$f"
    fi
done <"$TMP/files"

total=$(wc -l <"$TMP/files" | tr -d ' ')
if [ $check -eq 1 ]; then
    echo "검사 ${total}개, 바뀔 파일 ${changed}개" >&2
    [ $changed -eq 0 ] || exit 1
else
    echo "대상 ${total}개, 바뀐 파일 ${changed}개" >&2
fi
