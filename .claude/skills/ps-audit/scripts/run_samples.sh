#!/usr/bin/env bash
# 풀이 폴더의 모든 풀이(*.cpp *.java *.py)를 같은 입력으로 돌려 출력과 시간을 비교한다.
# 사용: bash run_samples.sh <풀이 폴더> <입력 파일> [기대 출력 파일]
# 환경변수: SAN=1  C++ ASan+UBSan(오류 시 중단), Java -ea
#          FPOFF=1 C++ -ffp-contract=off
#          TL=<초> 풀이당 제한 시간 (기본 10)
#          WORK=<디렉터리> 작업 위치 (기본 $TMPDIR/ps-audit-run)
# 종료 코드: 0 모두 통과, 1 불일치·컴파일 실패·런타임 오류·시간 초과, 2 인자 오류
# 컴파일 옵션은 ps_check.py 와 같다. 레포에는 아무것도 쓰지 않는다.
set -u

if [ $# -lt 2 ]; then
  echo "사용: bash run_samples.sh <풀이 폴더> <입력 파일> [기대 출력 파일]" >&2
  exit 2
fi
dir=${1%/}
input=$2
expected=${3:-}
[ -d "$dir" ] || { echo "폴더 없음: $dir" >&2; exit 2; }
[ -f "$input" ] || { echo "입력 파일 없음(일반 파일이어야 함): $input" >&2; exit 2; }
[ -z "$expected" ] || [ -f "$expected" ] || { echo "기대 출력 파일 없음: $expected" >&2; exit 2; }

case "$(basename "$dir")" in
  cofo_*|leet_*) std=c++23 ;;
  *) std=c++20 ;;
esac
tl=${TL:-10}
work=${WORK:-${TMPDIR:-/tmp}/ps-audit-run}/$(basename "$dir")
rm -rf "$work"
mkdir -p "$work"

cxxflags=(-std="$std" -O2 -Wall -Wextra)
javaopts=()
[ "${FPOFF:-0}" = 1 ] && cxxflags+=(-ffp-contract=off)
[ "${SAN:-0}" = 1 ] && { cxxflags+=(-fsanitize=address,undefined -fno-sanitize-recover=all); javaopts+=(-ea); }

# 공백·개행 차이를 무시하는 토큰 단위 정규화
norm() { awk '{ for (i = 1; i <= NF; i++) print $i }' "$1"; }
row() { printf '%-18s %-14s %s\n' "$1" "$2" "$3"; }
first_line() { head -c 300 "$1" | head -1; }

ref=""
[ -n "$expected" ] && { norm "$expected" > "$work/ref.txt"; ref="$work/ref.txt"; }

row "풀이" "결과" "시간(초)"
status=0
found=0
for f in "$dir"/*.cpp "$dir"/*.java "$dir"/*.py; do
  [ -f "$f" ] || continue
  found=1
  name=$(basename "$f")
  out="$work/$name.out"
  err="$work/$name.err"
  case "$f" in
    *.cpp)
      grep -Eq '\bmain\s*\(' "$f" || { row "$name" "건너뜀(main 없음)" "-"; continue; }
      if ! g++-16 "${cxxflags[@]}" "$f" -o "$work/$name.bin" 2> "$work/$name.cerr"; then
        row "$name" "컴파일실패" "-"; echo "    $(grep -m1 'error' "$work/$name.cerr")"; status=1; continue
      fi
      run=("$work/$name.bin") ;;
    *.java)
      grep -Eq 'static\s+void\s+main\s*\(' "$f" || { row "$name" "건너뜀(main 없음)" "-"; continue; }
      cls=$(sed -n 's/^public class \([A-Za-z0-9_]*\).*/\1/p' "$f" | head -1)
      [ -n "$cls" ] || cls=Main
      mkdir -p "$work/$name.d"
      sed '/^package /d' "$f" > "$work/$name.d/$cls.java"
      if ! javac -encoding UTF-8 --release 21 -d "$work/$name.d" "$work/$name.d/$cls.java" 2> "$work/$name.cerr"; then
        row "$name" "컴파일실패" "-"; echo "    $(grep -m1 'error' "$work/$name.cerr")"; status=1; continue
      fi
      run=(java ${javaopts[@]+"${javaopts[@]}"} -cp "$work/$name.d" "$cls") ;;
    *.py)
      if grep -Eq '^(def solution|class Solution)' "$f" && ! grep -Eq 'stdin|input\s*\(' "$f"; then
        row "$name" "건너뜀(함수형)" "-"; continue
      fi
      python3 -B -c 'import ast,sys; ast.parse(open(sys.argv[1], encoding="utf-8").read())' "$f" 2> "$work/$name.cerr" \
        || { row "$name" "컴파일실패" "-"; echo "    $(tail -1 "$work/$name.cerr")"; status=1; continue; }
      run=(python3 -B "$f") ;;
  esac
  # perl alarm 으로 제한 시간을 건다 (macOS 에 timeout 명령이 없다). 시간 초과는 종료 코드 142(SIGALRM).
  # 신호로 죽을 때 셸이 찍는 "Segmentation fault" 류 메시지는 { } 2>/dev/null 로 막는다.
  { /usr/bin/time -p perl -e 'alarm shift; exec @ARGV' "$tl" "${run[@]}" < "$input" > "$out" 2> "$err"; } 2>/dev/null
  rc=$?
  t=$(awk '/^real/ {print $2}' "$err")
  if [ $rc -eq 142 ]; then
    row "$name" "시간초과(>${tl}s)" "-"; status=1; continue
  elif [ $rc -ne 0 ]; then
    row "$name" "런타임오류($rc)" "${t:--}"
    msg=$(grep -v -E '^(real|user|sys)[[:space:]]' "$err" | grep -m1 -E 'Exception|Error|error|runtime|SUMMARY' || true)
    [ $rc -gt 128 ] && msg="${msg:+$msg / }신호 $((rc - 128)) ($(kill -l $((rc - 128)) 2>/dev/null))"
    echo "    $msg"
    status=1; continue
  fi
  norm "$out" > "$out.n"
  if [ -z "$ref" ]; then
    ref="$out.n"
    row "$name" "기준" "${t:--}"
  elif cmp -s "$ref" "$out.n"; then
    row "$name" "일치" "${t:--}"
  else
    row "$name" "불일치" "${t:--}"
    echo "    첫 차이: $(diff "$ref" "$out.n" | grep -m1 '^[<>]' || true)   ('<' 기준, '>' 이 풀이)"
    status=1
  fi
done
[ $found -eq 1 ] || { echo "풀이 파일 없음: $dir" >&2; exit 2; }
echo "작업 디렉터리: $work"
exit $status
