#!/usr/bin/env python3
"""PS 문제 스캐폴딩: day_XX/{judge}_{id}/ 폴더 + Java/C++/Python 보일러플레이트 생성.

지원 저지
  프로그래머스  school.programmers.co.kr/learn/courses/30/lessons/{id}  -> prms_{id}/Solution.*
  LeetCode      leetcode.com/problems/{slug}                           -> leet_{frontendId}/Solution.*
  Codeforces    codeforces.com/(contest|gym)/{c}/problem/{x}           -> cofo_{c}{x}/Main.*
                codeforces.com/problemset/problem/{c}/{x}

인자 없이 실행 -> 열려있는 Chrome 탭에서 위 URL 을 전부 추출해 한번에 처리.
인자를 주면 그 문제만 -> URL 그대로, 또는 `42578` / `two-sum` / `2148a` / `prms:..` `leet:..` `cofo:..`.

프로그래머스·LeetCode 는 로그인 없이 공식 시작 코드를 받아온다.
Codeforces 는 시작 코드가 없어 네트워크 없이 고정 보일러플레이트를 찍는다.

git add/commit 은 하지 않는다 (실제로 풀고 나서 커밋하는 워크플로와 분리).
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

LANGS = ("java", "cpp", "python3")

# --- 저지 URL 패턴 ----------------------------------------------------------
PRMS_URL_RE = re.compile(r"school\.programmers\.co\.kr/learn/courses/30/lessons/(\d+)")
LEET_URL_RE = re.compile(r"leetcode\.com/problems/([a-z0-9][a-z0-9-]*)")
COFO_CONTEST_RE = re.compile(r"codeforces\.com/(?:contest|gym)/(\d+)/problem/([A-Za-z]\d*)")
COFO_PSET_RE = re.compile(r"codeforces\.com/problemset/problem/(\d+)/([A-Za-z]\d*)")

PRMS_TITLE_RE = re.compile(r"<title>코딩테스트 연습 - (.+?) \| 프로그래머스 스쿨</title>")
PRMS_CODE_RE = re.compile(r'<textarea hidden id="code" name="code">(.*?)</textarea>', re.DOTALL)


# --- 공통 ------------------------------------------------------------------
def repo_root() -> pathlib.Path:
    out = subprocess.check_output(["git", "rev-parse", "--show-toplevel"], text=True)
    return pathlib.Path(out.strip())


def http_get(url: str, *, data: bytes | None = None, headers: dict | None = None) -> str | None:
    h = {"User-Agent": "Mozilla/5.0"}
    if headers:
        h.update(headers)
    req = urllib.request.Request(url, data=data, headers=h)
    try:
        with urllib.request.urlopen(req, timeout=15) as resp:
            return resp.read().decode("utf-8", errors="replace")
    except (urllib.error.URLError, TimeoutError):
        return None


def chrome_tabs_text() -> str:
    # `is running` 가드가 없으면 Chrome 이 꺼져 있을 때 osascript 가 Chrome 을 띄운다.
    script = (
        'if application "Google Chrome" is running then\n'
        '  tell application "Google Chrome" to get URL of every tab of every window\n'
        "end if"
    )
    try:
        return subprocess.check_output(["osascript", "-e", script], text=True, stderr=subprocess.DEVNULL)
    except (subprocess.CalledProcessError, FileNotFoundError) as e:
        sys.exit(f"error: Chrome 탭을 읽는 데 실패함 ({e})")


def specs_from_text(text: str) -> list[tuple]:
    """텍스트(탭 목록이든 인자 URL 이든)에서 (judge, key) 스펙을 뽑는다."""
    specs: list[tuple] = []
    specs += [("prms", pid) for pid in PRMS_URL_RE.findall(text)]
    specs += [("leet", slug) for slug in LEET_URL_RE.findall(text)]
    for cid, idx in COFO_CONTEST_RE.findall(text) + COFO_PSET_RE.findall(text):
        specs.append(("cofo", (cid, idx.lower())))
    return specs


def parse_arg(a: str) -> list[tuple]:
    if "://" in a or ".com/" in a or ".co.kr/" in a:
        got = specs_from_text(a)
        if not got:
            sys.exit(f"error: URL 에서 지원 저지를 못 찾음: {a}")
        return got
    if a.startswith(("prms:", "leet:", "cofo:")):
        judge, _, rest = a.partition(":")
        if judge == "cofo":
            m = re.fullmatch(r"(\d+)([A-Za-z]\d*)", rest)
            if not m:
                sys.exit(f"error: cofo 형식 오류 (예: cofo:2148a): {a}")
            return [("cofo", (m.group(1), m.group(2).lower()))]
        return [(judge, rest)]
    if a.isdigit():
        return [("prms", a)]
    m = re.fullmatch(r"(\d+)([A-Za-z]\d*)", a)
    if m:
        return [("cofo", (m.group(1), m.group(2).lower()))]
    if re.fullmatch(r"[a-z0-9][a-z0-9-]*", a):
        return [("leet", a)]
    sys.exit(f"error: 해석 불가한 인자: {a}")


def dedup(specs: list[tuple]) -> list[tuple]:
    seen: set = set()
    out: list[tuple] = []
    for judge, key in specs:
        k = (judge, key if isinstance(key, str) else tuple(key))
        if k not in seen:
            seen.add(k)
            out.append((judge, key))
    return out


# --- 프로그래머스 ---------------------------------------------------------------
def fetch_programmers(pid: str, lang: str) -> tuple[str | None, str | None]:
    body = http_get(f"https://school.programmers.co.kr/learn/courses/30/lessons/{pid}?language={lang}")
    if body is None:
        return None, None
    m = PRMS_CODE_RE.search(body)
    if not m:
        return None, None
    # 프로그래머스 원본은 CRLF — 우리가 붙이는 LF 헤더와 섞이지 않게 정규화.
    code = html.unescape(m.group(1)).replace("\r\n", "\n")
    tm = PRMS_TITLE_RE.search(body)
    return code, (tm.group(1) if tm else None)


def prms_lang_ok(lang: str, code: str) -> bool:
    """프로그래머스는 특정 언어를 지원 안 하는 문제에 다른 언어(대개 C++) 템플릿을 대신 준다.
    받아온 코드가 요청한 언어와 실제로 맞는지 확인한다.
    (프로그래머스 Python 은 메서드형 `def solution(...)` 이거나 IO형 `a = int(input())` 스크립트라
     `def` 유무로 판단할 수 없다 — C 계열 마커 유무로 가른다.)"""
    c_family = "#include" in code or "using namespace" in code or bool(re.search(r";\s*\n", code))
    if lang == "python3":
        return not c_family and "public " not in code
    if lang == "java":
        return "class " in code and "#include" not in code
    return c_family or ("solution(" in code and "class " not in code)  # cpp


MAIN_VOID_RE = re.compile(r"^(\s*)int main\(\s*void\s*\)\s*\{\s*$", re.MULTILINE)


def strip_cpp_prelude(code: str) -> str:
    """#include 줄과 `using namespace std;`, 선행 빈 줄을 걷어낸다."""
    body: list[str] = []
    skipping_blank = True
    for line in code.splitlines():
        stripped = line.strip()
        if stripped.startswith("#include") or stripped == "using namespace std;":
            continue
        if skipping_blank and stripped == "":
            continue
        skipping_blank = False
        body.append(line)
    return "\n".join(body).rstrip("\n")


def build_prms_java(package: str, code: str) -> str:
    return f"package {package};\n\n{code}\n"


def build_prms_cpp(code: str) -> str:
    body = strip_cpp_prelude(code)
    # main() 으로 stdin/stdout 을 직접 처리하는 스타일이면 (void) 인자를 빼고 동기화 해제를 넣는다.
    m = MAIN_VOID_RE.search(body)
    if m:
        indent = m.group(1)
        body = MAIN_VOID_RE.sub(
            f"{indent}int main() {{\n{indent}    ios::sync_with_stdio(0);\n{indent}    cin.tie(0);\n",
            body,
            count=1,
        )
    return "#include <bits/stdc++.h>\nusing namespace std;\n\n" + body + "\n"


def build_prms_python(code: str, io_style: bool) -> str:
    body = code.rstrip("\n") + "\n"
    if io_style:
        return "import sys\n\ninput = sys.stdin.readline\n\n" + body
    return body


# --- LeetCode ------------------------------------------------------------------
LEET_QUERY = (
    "query q($t:String!){question(titleSlug:$t){questionFrontendId title isPaidOnly codeSnippets{langSlug code}}}"
)
LEET_JAVA_UTIL_RE = re.compile(
    r"\b(List|Map|Set|Queue|Deque|Stack|ArrayList|LinkedList|HashMap|HashSet"
    r"|TreeMap|TreeSet|PriorityQueue|Arrays|Collections|Comparator|Iterator|Optional)\b"
)


def fetch_leetcode(slug: str):
    """성공 시 dict, 프리미엄이면 'paid', 그 외 실패면 None."""
    payload = json.dumps({"query": LEET_QUERY, "variables": {"t": slug}}).encode()
    body = http_get(
        "https://leetcode.com/graphql",
        data=payload,
        headers={"Content-Type": "application/json", "Referer": f"https://leetcode.com/problems/{slug}/"},
    )
    if body is None:
        return None
    try:
        q = json.loads(body)["data"]["question"]
    except (KeyError, ValueError, TypeError):
        return None
    if not q:
        return None
    if q.get("isPaidOnly"):
        return "paid"
    snippets = {s["langSlug"]: html.unescape(s["code"]).replace("\r\n", "\n") for s in q["codeSnippets"]}
    return {"id": q["questionFrontendId"], "title": q["title"], "snippets": snippets}


def build_leet_java(package: str, code: str) -> str:
    head = f"package {package};\n\n"
    if LEET_JAVA_UTIL_RE.search(code):
        head += "import java.util.*;\n\n"
    return head + code.rstrip("\n") + "\n"


def build_leet_cpp(code: str) -> str:
    # LeetCode 스니펫엔 #include/using/main 이 없다 — 정리 함수를 그대로 재사용.
    return "#include <bits/stdc++.h>\nusing namespace std;\n\n" + strip_cpp_prelude(code) + "\n"


def build_leet_python(code: str) -> str:
    # 스니펫을 그대로 쓴다 — typing import 를 넣지 않는다.
    # (List[int] 등 구형 표기는 저장 시 에디터 포매팅이 list[int] 로 바꿔줌)
    return code.rstrip("\n") + "\n"


# --- Codeforces --------------------------------------------------------------
# Codeforces 는 C++ 만 만든다(사용자 방침). 시작 코드 개념이 없어 고정 보일러플레이트.
COFO_CPP_TMPL = """#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

}
"""

# 문제 이름을 가볍게 조회할 공개 엔드포인트가 없다(standings 는 8MB, 문제 페이지는 403).
# 이름은 cosmetic 이라 조회하지 않고 폴더명(cofo_{c}{x})만 쓴다.


# --- 스펙 처리 ---------------------------------------------------------------
def process(spec: tuple, day_name: str, day_dir: pathlib.Path) -> tuple:
    """반환: (status, label, title|reason, files|None). status in {ok, skip, fail}."""
    judge, key = spec

    if judge == "prms":
        folder = f"prms_{key}"
        if (day_dir / folder).exists():
            return ("skip", folder, None, None)
        codes: dict[str, str] = {}
        title: str | None = None
        for lang in LANGS:
            code, t = fetch_programmers(key, lang)
            if code is None:
                return ("fail", folder, "fetch 실패", None)
            title = title or t
            if prms_lang_ok(lang, code):
                codes[lang] = code
        if not codes:
            return ("fail", folder, "지원 언어를 못 찾음", None)
        package = f"{day_name}.{folder}"
        io_style = "java" in codes and "static void main(" in codes["java"]
        files = {}
        if "java" in codes:
            files["Solution.java"] = build_prms_java(package, codes["java"])
        if "cpp" in codes:
            files["Solution.cpp"] = build_prms_cpp(codes["cpp"])
        if "python3" in codes:
            files["Solution.py"] = build_prms_python(codes["python3"], io_style)
        unsupported = [lang for lang in LANGS if lang not in codes]
        note = f"{title} — {'/'.join(unsupported)} 미지원" if unsupported else title
        return ("ok", folder, note, files)

    if judge == "leet":
        res = fetch_leetcode(key)
        if res == "paid":
            return ("fail", f"leet:{key}", "프리미엄 문제 (로그인 필요)", None)
        if res is None:
            return ("fail", f"leet:{key}", "fetch 실패 / 존재하지 않는 slug", None)
        folder = f"leet_{res['id']}"
        if (day_dir / folder).exists():
            return ("skip", folder, None, None)
        snip = res["snippets"]
        if not all(lang in snip for lang in LANGS):
            return ("fail", folder, "일부 언어 스니펫 없음", None)
        package = f"{day_name}.{folder}"
        files = {
            "Solution.java": build_leet_java(package, snip["java"]),
            "Solution.cpp": build_leet_cpp(snip["cpp"]),
            "Solution.py": build_leet_python(snip["python3"]),
        }
        return ("ok", folder, res["title"], files)

    # cofo — C++ 만
    cid, idx = key
    folder = f"cofo_{cid}{idx}"
    if (day_dir / folder).exists():
        return ("skip", folder, None, None)
    return ("ok", folder, None, {"Main.cpp": COFO_CPP_TMPL})


def main() -> None:
    args = sys.argv[1:]
    if args:
        specs: list[tuple] = []
        for a in args:
            specs += parse_arg(a)
    else:
        specs = specs_from_text(chrome_tabs_text())
    specs = dedup(specs)
    if not specs:
        sys.exit("error: 처리할 문제가 없음 (열린 Chrome 탭에 지원 저지 문제 URL 이 없음)")

    root = repo_root()
    today = datetime.date.today()
    year_month = today.strftime("%Y-%m")
    src_dir = root / year_month / "src"
    if not src_dir.is_dir():
        sys.exit(f"error: {year_month} 모듈이 없음 — ps-new-month 먼저 실행 필요")

    # day 번호 = 실행 시각의 '일'. 같은 날 재실행하면 같은 폴더에 누적되고, 안 푼 날은 자연히 건너뛴다.
    day_name = f"day_{today.day:02d}"
    day_dir = src_dir / day_name

    created: list[tuple[str, str | None]] = []
    skipped: list[str] = []
    failed: list[tuple[str, str]] = []

    for spec in specs:
        status, label, extra, files = process(spec, day_name, day_dir)
        if status == "skip":
            skipped.append(label)
        elif status == "fail":
            failed.append((label, extra))
        else:
            day_dir.mkdir(parents=True, exist_ok=True)  # 실제로 만들 때만 생성
            pkg_dir = day_dir / label
            pkg_dir.mkdir(parents=True)
            for fname, content in files.items():
                (pkg_dir / fname).write_text(content)
            created.append((label, extra))

    print(f"day: {day_name}")
    for label, title in created:
        print(f"  created: {label}" + (f"  ({title})" if title else ""))
    for label in skipped:
        print(f"  skipped (already exists): {label}")
    for label, reason in failed:
        print(f"  failed: {label} — {reason}", file=sys.stderr)

    # 하나라도 성공했으면 정상 종료 — 부분 실패는 stderr 의 failed 목록으로 전달.
    if failed and not created:
        sys.exit(1)


if __name__ == "__main__":
    main()
