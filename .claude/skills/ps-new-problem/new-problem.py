#!/usr/bin/env python3
"""프로그래머스 문제 스캐폴딩: day_XX/prms_{id}/ 폴더 + Java/C++/Python 보일러플레이트 생성.

인자 없이 실행 -> 현재 열려있는 Chrome 탭에서 프로그래머스 문제 번호를 자동 추출.
인자로 문제 번호를 주면 그 번호들만 처리.

git add/commit은 하지 않는다 (실제로 풀고 나서 커밋하는 워크플로와 분리).
"""
import datetime
import html
import json
import pathlib
import re
import subprocess
import sys
import urllib.error
import urllib.request

LANGS = [("java", "java"), ("cpp", "cpp"), ("python3", "py")]
TITLE_RE = re.compile(r"<title>코딩테스트 연습 - (.+?) \| 프로그래머스 스쿨</title>")
CODE_RE = re.compile(r'<textarea hidden id="code" name="code">(.*?)</textarea>', re.S)
TAB_URL_RE = re.compile(r"https://school\.programmers\.co\.kr/learn/courses/30/lessons/(\d+)")

# 오늘 마지막으로 쓴 day 번호를 기록해두는 상태 파일. 디렉터리 mtime은 git
# checkout/pull/worktree 등으로 리셋될 수 있어 신뢰할 수 없어서, 이 스킬 자신이
# 직접 상태를 관리한다.
STATE_FILE = pathlib.Path(__file__).resolve().parent / ".day-state.json"


def repo_root() -> pathlib.Path:
    out = subprocess.check_output(["git", "rev-parse", "--show-toplevel"], text=True)
    return pathlib.Path(out.strip())


def chrome_problem_ids() -> list[str]:
    script = 'tell application "Google Chrome" to get URL of every tab of every window'
    try:
        out = subprocess.check_output(
            ["osascript", "-e", script], text=True, stderr=subprocess.DEVNULL
        )
    except (subprocess.CalledProcessError, FileNotFoundError) as e:
        print(f"error: Chrome 탭을 읽는 데 실패함 ({e})", file=sys.stderr)
        sys.exit(1)

    seen: list[str] = []
    for pid in TAB_URL_RE.findall(out):
        if pid not in seen:
            seen.append(pid)
    return seen


def fetch_template(problem_id: str, language: str) -> tuple[str | None, str | None]:
    url = f"https://school.programmers.co.kr/learn/courses/30/lessons/{problem_id}?language={language}"
    req = urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0"})
    try:
        with urllib.request.urlopen(req, timeout=15) as resp:
            body = resp.read().decode("utf-8", errors="replace")
    except (urllib.error.URLError, TimeoutError):
        return None, None

    m = CODE_RE.search(body)
    if not m:
        return None, None
    # 프로그래머스 원본 템플릿은 CRLF라서, package/import 등 우리가 붙이는
    # LF 헤더와 섞이지 않도록 여기서 한 번에 정규화한다.
    code = html.unescape(m.group(1)).replace("\r\n", "\n")

    title_m = TITLE_RE.search(body)
    title = title_m.group(1) if title_m else None
    return code, title


def build_java(package: str, code: str) -> str:
    return f"package {package};\n\n{code}\n"


MAIN_VOID_RE = re.compile(r"^(\s*)int main\(\s*void\s*\)\s*\{\s*$", re.M)


def build_cpp(code: str) -> str:
    lines = code.splitlines()
    body: list[str] = []
    skipping_leading_blank = True
    for line in lines:
        stripped = line.strip()
        if stripped.startswith("#include") or stripped == "using namespace std;":
            continue
        if skipping_leading_blank and stripped == "":
            continue
        skipping_leading_blank = False
        body.append(line)

    body_text = "\n".join(body).rstrip("\n")

    # main()으로 stdin/stdout 입출력을 직접 처리하는 스타일이면 (void) 인자를 빼고
    # 표준 입출력 동기화 해제 두 줄을 넣어준다.
    m = MAIN_VOID_RE.search(body_text)
    if m:
        indent = m.group(1)
        replacement = f"{indent}int main() {{\n{indent}    ios::sync_with_stdio(0);\n{indent}    cin.tie(0);\n"
        body_text = MAIN_VOID_RE.sub(replacement, body_text, count=1)

    return "#include <bits/stdc++.h>\nusing namespace std;\n\n" + body_text + "\n"


def build_python(code: str, is_io_style: bool) -> str:
    body = code.rstrip("\n") + "\n"
    if is_io_style:
        return "import sys\n\ninput = sys.stdin.readline\n\n" + body
    return body


def resolve_day_num(src_dir: pathlib.Path) -> int:
    """오늘 쓸 day 번호를 정한다. 상태 파일에 오늘 날짜로 기록된 값이 있으면 재사용,
    없으면(날짜가 바뀌었거나 최초 실행이면) 기존 day_XX 중 최댓값+1로 새로 만든다."""
    today = datetime.date.today().isoformat()

    state = None
    if STATE_FILE.exists():
        try:
            state = json.loads(STATE_FILE.read_text())
        except (json.JSONDecodeError, OSError):
            state = None

    if state and state.get("date") == today and isinstance(state.get("day"), int):
        day_num = state["day"]
    else:
        day_nums = [
            int(m.group(1))
            for d in src_dir.iterdir()
            if d.is_dir() and (m := re.match(r"^day_(\d+)$", d.name))
        ]
        day_num = max(day_nums, default=0) + 1

    STATE_FILE.write_text(json.dumps({"date": today, "day": day_num}))
    return day_num


def main() -> None:
    args = sys.argv[1:]
    problem_ids = args if args else chrome_problem_ids()
    if not problem_ids:
        print("error: 처리할 문제 번호가 없음 (Chrome에 열린 프로그래머스 문제 탭 없음)", file=sys.stderr)
        sys.exit(1)

    for pid in problem_ids:
        if not pid.isdigit():
            print(f"error: 문제 번호가 아님: {pid}", file=sys.stderr)
            sys.exit(1)

    root = repo_root()
    today = datetime.date.today()
    year_month = today.strftime("%Y-%m")
    src_dir = root / year_month / "src"
    if not src_dir.is_dir():
        print(f"error: {year_month} 모듈이 없음 — ps-new-month 먼저 실행 필요", file=sys.stderr)
        sys.exit(1)

    day_name = f"day_{resolve_day_num(src_dir):02d}"
    day_dir = src_dir / day_name

    created: list[tuple[str, str | None]] = []
    skipped: list[str] = []
    failed: list[str] = []

    for pid in problem_ids:
        pkg_dir = day_dir / f"prms_{pid}"
        if pkg_dir.exists():
            skipped.append(pid)
            continue

        codes: dict[str, str] = {}
        title = None
        ok = True
        for lang, ext in LANGS:
            code, t = fetch_template(pid, lang)
            if code is None:
                ok = False
                break
            codes[ext] = code
            title = title or t
        if not ok:
            failed.append(pid)
            continue

        day_dir.mkdir(parents=True, exist_ok=True)  # 실제로 뭔가 만들 때만 생성 (실패만 하면 빈 day 폴더 안 남김)
        pkg_dir.mkdir(parents=True)
        package = f"{day_name}.prms_{pid}"
        # main()으로 stdin/stdout 입출력을 직접 처리하는 스타일의 문제인지는 자바 스켈레톤의
        # main 유무로 판단한다 (solution() 함수 스타일 문제는 main이 없음).
        is_io_style = "static void main(" in codes["java"]
        (pkg_dir / "Solution.java").write_text(build_java(package, codes["java"]))
        (pkg_dir / "Solution.cpp").write_text(build_cpp(codes["cpp"]))
        (pkg_dir / "Solution.py").write_text(build_python(codes["py"], is_io_style))
        created.append((pid, title))

    print(f"day: {day_name}")
    for pid, title in created:
        suffix = f" ({title})" if title else ""
        print(f"  created: prms_{pid}{suffix}")
    for pid in skipped:
        print(f"  skipped (already exists): prms_{pid}")
    for pid in failed:
        print(f"  failed (fetch error): prms_{pid}", file=sys.stderr)

    if failed:
        sys.exit(1)


if __name__ == "__main__":
    main()
