#!/usr/bin/env python3
"""PS 컨벤션 기계 검사기. 기준 문서는 레포 루트 CONVENTIONS.md (규칙의 정본).

이 스크립트의 역할은 규칙 중 기계로 판정되는 부분을 검사해 결과를 로그로 남기는 것이다.
규칙의 내용·등급은 문서가 정하고, 감사 절차는 SKILL.md 가 정한다. 여기에는 판정 로직과 그 대응표만 둔다.

사용:
    ps_check.py [경로...] [--tier 필수|권장] [--rule ID]... [--summary]
                [--compile | --compile-only] [-j N]
    ps_check.py --list-rules     규칙 ID · 등급 · 문서 절 · 언어
    ps_check.py --check-docs     문서와의 대응 검사 + 정독 대상 절 목록

- 경로는 파일 또는 폴더. 기본은 현재 폴더. 대상은 .java .cpp .py.
- 출력: `파일:줄: [등급] 규칙ID (후보) 메시지`. `(후보)`는 사람이 최종 판정해야 하는 항목.
- `--compile`: 규칙 검사에 더해 컴파일·파싱을 한다 (C++ `g++-16 -fsyntax-only`, Java `javac --release 21`, Python `ast`).
  컴파일 실패는 `[필수] compile-error`, `-Wunused-*` 는 `[필수] unused`, 그 밖의 경고는 `[필수] compile-warn (후보)`.
  `-Wsign-compare` 는 결함으로 치지 않아 끈다. Java `unchecked`·`rawtypes` 경고는 13.5 에 따라 무시한다.
  C++ 표준은 `prms_` C++20, `cofo_`·`leet_` C++23, BOJ 등 그 외는 C++20 이다 (CONVENTIONS 3장).
- 종료 코드: 후보가 아닌 [필수] 위반이 하나라도 있으면 1, 아니면 0. `--check-docs` 는 불일치가 있으면 1.
- 검사 범위: 디렉터리를 훑을 때 `live_` 폴더와 2025-12 이전 월 폴더는 건너뛴다. 경로로 직접 지정하면 검사한다.
"""

import argparse
import ast
import io
import os
import re
import subprocess
import sys
import tempfile
import tokenize
from concurrent.futures import ThreadPoolExecutor

STDIN_JUDGES = ("boj_", "cofo_", "swea_", "softeer_")
SKIP_PREFIXES = ("live_",)  # 대회 박제 폴더는 감사 대상 아님 (CONVENTIONS 0.2)
FIRST_AUDIT_MONTH = "2025-12"  # 이전 월 폴더는 디렉터리를 훑을 때만 건너뜀. 경로로 직접 지정하면 감사 (CONVENTIONS 0.2)
EXT_LANG = {".java": "java", ".cpp": "cpp", ".py": "py"}
SKIP_DIRS = {".git", "__pycache__", ".idea", ".venv", "node_modules"}
ALL = ("java", "cpp", "py")

RULES = {}


def rule(rid, tier, langs, doc):
    def deco(fn):
        RULES[rid] = (tier, langs, doc, fn)
        return fn

    return deco


# 스크립트가 못 보거나 일부만 보는 절 → 감사자가 정독한다. `--check-docs` 가 이 표와 규칙 대응으로 정독 대상을 출력한다.
GAPS = {
    "1.4": "C++은 기본 타입·string·vector·표준 컨테이너·pair/tuple 선언만 본다(사용자 정의 타입 선언, 함수명은 못 봄). 멤버/지역/전역 판정은 중괄호 추적이라 근사",
    "1.2": "함수명 표기 (name-case 는 변수·상수만 본다)",
    "1.3": "저지가 준 시그니처(함수명·매개변수명)를 바꾸지 않았는지, 지문의 변수명과 대조",
    "4.2": "Queue API 는 변수 타입이 필요해 일부만 본다",
    "4.3": "스트림 허용 범위, list.remove 혼동, 박싱 == (변수 타입이 필요해 일부만)",
    "5": "연쇄 대입(a = b = 0), 5장 표에 없는 모듈",
    "6": "포매터가 정한다. 포매터 결과는 지적하지 않는다",
    "7.1": "홀짝 판정의 `& 1`",
    "7.2": "조기 반환",
    "7.4": "삼항 극성 (중첩만 검사)",
    "8.0": "int 범위 초과(정답성), 습관적 큰 타입",
    "8.5": "INF 값, 음수 나머지 일반형, 실수 비교(EPS)",
    "8.2": "범위 for 의 auto 원소 타입 (`vector<string>` 이면 `string&`)",
    "8.4": "참조로 받기 (타입 크기를 알아야 한다)",
    "9": "표준 라이브러리 우선(직접 구현), ASCII 산술 변환, Codeforces 해시",
    "10": "프로그래머스·LeetCode의 전역·static 상태 (읽기 전용 테이블 여부 판단)",
    "11": "방어 코드, 알려진 패턴 밖의 군더더기(괄호·변수·형변환)",
    "12": "이름 표 대부분(rename-hint 는 일부), `MAX_N` 형식, 한 스코프의 이름 충돌",
    "13.1": "알고리즘별 함수명",
    "13.3": "크기 식 앞/뒤 여유분 판정, 리터럴이 여유분을 합친 값인지(size-pad 는 후보), `while` 안 역순 인덱스, 크기 식이 아닌 `+ 1` 순서",
    "13.6": "비교자 람다 변수의 이름 `cmp`",
    "14": "문자열 순회, 테스트케이스 번호 `tc`, StringBuilder 체이닝",
}
DOC_PATH = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "..", "..", "..", "CONVENTIONS.md")

_NAME_LISTS = None


def name_lists():
    """1.4 의 이름 목록은 문서가 정본이다. 라벨(`C++ 전역 목록:` 등)이 붙은 줄에서 읽는다."""
    global _NAME_LISTS
    if _NAME_LISTS is None:
        labels = {"cpp_global": "C++ 전역 목록:", "cpp_local": "C++ 지역 목록:", "py": "Python 목록:"}
        lists = {k: set() for k in labels}
        with open(DOC_PATH, encoding="utf-8") as f:
            for l in f:
                for k, lab in labels.items():
                    if lab in l:
                        lists[k] = set(re.findall(r"`(\w+)`", l.split(lab, 1)[1]))
        _NAME_LISTS = lists
    return _NAME_LISTS


# ---------------------------------------------------------------- 전처리


def strip_cstyle(src, lang):
    """주석·문자열·문자 리터럴 내용을 공백으로 바꾼다 (줄·칸 위치 유지)."""
    out, i, n = [], 0, len(src)
    while i < n:
        c = src[i]
        nx = src[i + 1] if i + 1 < n else ""
        if c == "/" and nx == "/":
            j = src.find("\n", i)
            j = n if j < 0 else j
            out.append(" " * (j - i))
            i = j
        elif c == "/" and nx == "*":
            j = src.find("*/", i + 2)
            j = n if j < 0 else j + 2
            out.append(re.sub(r"[^\n]", " ", src[i:j]))
            i = j
        elif src.startswith('"""', i) and lang == "java":
            j = src.find('"""', i + 3)
            j = n if j < 0 else j + 3
            out.append(re.sub(r"[^\n]", " ", src[i:j]))
            i = j
        elif c == '"':
            j = i + 1
            while j < n and src[j] != '"' and src[j] != "\n":
                if src[j] == "\\":
                    j += 1
                j += 1
            j = min(j + 1, n)
            out.append('"' + " " * max(j - i - 2, 0) + '"')
            i = j
        elif c == "'":
            prev = src[i - 1] if i > 0 else ""
            if lang == "cpp" and prev.isalnum() and nx.isalnum():
                out.append("'")  # C++ 숫자 구분자
                i += 1
                continue
            j = i + 1
            while j < n and src[j] != "'" and src[j] != "\n":
                if src[j] == "\\":
                    j += 1
                j += 1
            j = min(j + 1, n)
            out.append("'" + " " * max(j - i - 2, 0) + "'")
            i = j
        else:
            out.append(c)
            i += 1
    return "".join(out)


def strip_py(src):
    lines = [list(l) for l in src.split("\n")]
    blank = {tokenize.COMMENT, tokenize.STRING, getattr(tokenize, "FSTRING_MIDDLE", -1)}
    try:
        for t in tokenize.generate_tokens(io.StringIO(src).readline):
            if t.type in blank:
                (sr, sc), (er, ec) = t.start, t.end
                for r in range(sr, er + 1):
                    row = lines[r - 1]
                    a = sc if r == sr else 0
                    b = ec if r == er else len(row)
                    for c in range(a, min(b, len(row))):
                        row[c] = " "
    except (tokenize.TokenError, IndentationError, SyntaxError):
        pass
    return "\n".join("".join(r) for r in lines)


class Ctx:
    def __init__(self, path, lang, raw):
        self.path = path
        self.lang = lang
        self.raw = raw
        self.rawlines = raw.split("\n")
        self.code = strip_py(raw) if lang == "py" else strip_cstyle(raw, lang)
        self.lines = self.code.split("\n")
        parts = path.replace(os.sep, "/").split("/")
        self.stdin_judge = any(p.startswith(STDIN_JUDGES) for p in parts)
        self.tree = None
        self.tokens = []
        if lang == "py":
            try:
                self.tree = ast.parse(raw)
            except SyntaxError:
                self.tree = None
            try:
                self.tokens = list(tokenize.generate_tokens(io.StringIO(raw).readline))
            except (tokenize.TokenError, IndentationError, SyntaxError):
                self.tokens = []


# ---------------------------------------------------------------- 공용 헬퍼


def bal(s, i, o, c):
    """s[i]==o 에서 짝이 맞는 c 까지. (내용, 끝 다음 인덱스) / 실패 시 (None, None)."""
    d = 0
    for j in range(i, len(s)):
        if s[j] == o:
            d += 1
        elif s[j] == c:
            d -= 1
            if d == 0:
                return s[i + 1 : j], j + 1
    return None, None


def first_arg(args):
    d = 0
    for k, ch in enumerate(args):
        if ch in "(<[":
            d += 1
        elif ch in ")>]":
            d -= 1
        elif ch == "," and d == 0:
            return args[:k]
    return args


def nb(L, i):
    for j in range(i + 1, len(L)):
        if L[j].strip():
            return j
    return None


def grep(ctx, pattern, msg, cand=False, flags=0):
    rx = re.compile(pattern, flags)
    return [(ln, msg, cand) if cand else (ln, msg) for ln, l in enumerate(ctx.lines, 1) if rx.search(l)]


def py_literal_int(node):
    if isinstance(node, ast.Constant) and isinstance(node.value, int):
        return node.value
    if isinstance(node, ast.BinOp) and isinstance(node.op, ast.Pow):
        a, b = py_literal_int(node.left), py_literal_int(node.right)
        if a is not None and b is not None and 0 <= b < 64:
            return a**b
    return None


# ---------------------------------------------------------------- 공통 규칙


@rule("odd-eq-1", "필수", ALL, "홀수 판정에 == 1 (7.1)")
def r_odd(ctx):
    return grep(ctx, r"%\s*2\s*==\s*1\b", "홀수 판정에 == 1 사용 (!= 0 또는 truthy)")


@rule("debug-out", "필수", ALL, "디버그 출력 잔여 (11장)")
def r_debug(ctx):
    pat = {"java": r"System\s*\.\s*err", "cpp": r"\b(?:cerr|clog)\b|fprintf\s*\(\s*stderr", "py": r"sys\s*\.\s*stderr"}[
        ctx.lang
    ]
    return grep(ctx, pat, "제출 코드에 디버그/오류 스트림 출력이 남음")


@rule("num-sep", "필수", ALL, "7자리 이상 정수 리터럴 구분자 (2장)")
def r_numsep(ctx):
    res = []
    if ctx.lang == "py":
        for t in ctx.tokens:
            if t.type == tokenize.NUMBER and re.fullmatch(r"\d{7,}", t.string):
                res.append((t.start[0], f"구분자 없는 정수 리터럴 {t.string}"))
        return res
    rx = re.compile(r"(?<![\w.'])(\d{7,})[uUlL]{0,3}(?![\w.'])")
    for ln, l in enumerate(ctx.lines, 1):
        for m in rx.finditer(l):
            res.append((ln, f"구분자 없는 정수 리터럴 {m.group(1)}"))
    return res


@rule("num-sep-short", "필수", ALL, "6자리 이하 정수 리터럴에 구분자 금지 (2장)")
def r_numsep_short(ctx):
    res = []
    if ctx.lang == "py":
        for t in ctx.tokens:
            if t.type == tokenize.NUMBER and re.fullmatch(r"\d{1,3}(?:_\d{3})+", t.string):
                if len(t.string.replace("_", "")) <= 6:
                    res.append((t.start[0], f"6자리 이하 정수 리터럴에 구분자 {t.string}"))
        return res
    sep = "_" if ctx.lang == "java" else "'"
    rx = re.compile(r"(?<![\w.'])(\d{1,3}(?:" + sep + r"\d{3})+)[uUlL]{0,3}(?![\w.'])")
    for ln, l in enumerate(ctx.lines, 1):
        for m in rx.finditer(l):
            if len(m.group(1).replace(sep, "")) <= 6:
                res.append((ln, f"6자리 이하 정수 리터럴에 구분자 {m.group(1)}"))
    return res


@rule("nested-ternary", "필수", ALL, "삼항 연산자 중첩 (7.4)")
def r_ternary(ctx):
    if ctx.lang == "py":
        res = []
        if ctx.tree:
            for n in ast.walk(ctx.tree):
                if isinstance(n, ast.IfExp) and any(isinstance(c, ast.IfExp) for c in (n.body, n.orelse, n.test)):
                    res.append((n.lineno, "삼항 연산자 중첩"))
        return res
    return grep(ctx, r"\?[^?:;]*:[^?;]*\?", "삼항 연산자 중첩 의심", cand=True)


@rule("size-plus", "필수", ("java", "cpp", "py"), "크기 식 여유분은 놓인 쪽에 (13.3, 앞/뒤는 사람이 판정 → 후보)")
def r_sizeplus(ctx):
    res = []
    for ln, l in enumerate(ctx.lines, 1):
        for e in size_exprs(ctx.lang, l):
            if re.fullmatch(r"\s*(.+?)\s*\+\s*1\s*\+\s*\1\s*", e):
                continue  # n + 1 + n: 음수 포함 구간의 0 자리 (13.3 허용)
            if re.search(r"[\w)\]]\s*\+\s*[12]\b", e) and not re.match(r"\s*1\s*\+", e):
                res.append((ln, f"크기 식 `{e.strip()}`: 앞쪽 여유분(1-indexed 등)이면 1 + n, 뒤쪽이면 그대로", True))
    return res


CONST_DECL = {
    "cpp": r"\bconst\s+(?:int|long long)\s+([A-Z][A-Z0-9_]*)\s*=\s*(\d[\d']*)\s*;",
    "java": r"\bstatic\s+final\s+(?:int|long)\s+([A-Z][A-Z0-9_]*)\s*=\s*(\d[\d_]*)\s*;",
    "py": r"^([A-Z][A-Z0-9_]*)\s*=\s*(\d[\d_]*)\s*$",
}


def const_decl(lang, l):
    m = re.search(CONST_DECL[lang], l)
    return (m.group(1), int(re.sub(r"['_]", "", m.group(2)))) if m else None


def looks_padded(v):
    return v >= 11 and v % 10 in (1, 2)


@rule("size-pad", "필수", ALL, "여유분을 합친 크기·상수 리터럴 (13.3, 합친 값인지는 사람이 판정 → 후보)")
def r_sizepad(ctx):
    res = []
    for ln, l in enumerate(ctx.lines, 1):
        for e in size_exprs(ctx.lang, l):
            m = re.fullmatch(r"\s*(\d[\d'_]*)\s*", e)
            if m:
                v = int(re.sub(r"['_]", "", m.group(1)))
                if looks_padded(v):
                    res.append(
                        (
                            ln,
                            f"크기 리터럴 {v}: 여유분을 합친 값이면 위치를 표시 (1 + {v - 1}"
                            + (f", 1 + {v - 2} + 1" if v % 10 == 2 else "")
                            + ")",
                            True,
                        )
                    )
        d = const_decl(ctx.lang, l)
        if d and looks_padded(d[1]):
            res.append(
                (ln, f"상수 {d[0]} = {d[1]}: 여유분을 합친 값이면 {d[1] - 1} 로 두고 크기 식에서 1 + {d[0]}", True)
            )
    return res


@rule(
    "magic-repeat",
    "권장",
    ALL,
    "반복되는 정수 리터럴·선언한 상수와 같은 값의 리터럴 (2장, 같은 의미인지는 사람이 판정 → 후보)",
)
def r_magic(ctx):
    occ, consts = {}, {}
    for ln, l in enumerate(ctx.lines, 1):
        d = const_decl(ctx.lang, l)
        if d:
            consts[d[1]] = d[0]
    if ctx.lang == "py":
        toks = [(t.start[0], t.string) for t in ctx.tokens if t.type == tokenize.NUMBER]
    else:
        rx = re.compile(r"(?<![\w.'])(\d[\d'_]*)(?![\w.'])")
        toks = [
            (ln, m.group(1))
            for ln, l in enumerate(ctx.lines, 1)
            if not l.lstrip().startswith("#")
            for m in rx.finditer(l)
        ]
    decl_lines = {ln for ln, l in enumerate(ctx.lines, 1) if const_decl(ctx.lang, l)}
    for ln, tok in toks:
        if ln in decl_lines or not re.fullmatch(r"\d[\d'_]*", tok):
            continue
        v = int(re.sub(r"['_]", "", tok))
        if v >= 10:
            occ.setdefault(v, []).append(ln)
    # 여유분을 합친 값(101, 102)은 같은 파일의 기준값(100)과 같은 수로 묶는다. 기준값이 리터럴이나 상수로 있을 때만.
    merged = {}
    for v in sorted(occ):
        for pad in (1, 2):
            base = v - pad
            if looks_padded(v) and base >= 10 and (base in occ or base in consts) and (pad == 1 or v % 10 == 2):
                merged[v] = base
                break
    groups = {}
    for v, lns in occ.items():
        b = merged.get(v, v)
        while b in merged:  # 1002 -> 1001 -> 1000 처럼 연쇄를 끝까지 따라간다
            b = merged[b]
        groups.setdefault(b, []).append((v, lns))
    res = []
    for b, items in sorted(groups.items()):
        lns = sorted(ln for _, ls in items for ln in ls)
        forms = sorted({v for v, _ in items})
        label = str(b) if forms == [b] else f"{b}({'·'.join(map(str, forms))} 포함)"
        if b in consts:
            res.append((lns[0], f"상수 {consts[b]} 와 같은 값 {label} 의 리터럴이 {len(lns)}회: 상수를 쓴다", True))
        elif len(lns) >= 3:
            res.append((lns[0], f"정수 리터럴 {label} 가 {len(lns)}회 반복: 같은 의미면 상수로", True))
    return res


@rule("redundant", "필수", ALL, "제거해도 동작이 같은 군더더기 (11장, 알려진 패턴만)")
def r_redundant(ctx):
    res = []
    if ctx.lang == "java":
        res += grep(ctx, r"println\s*\(\s*\w+\s*\.\s*toString\s*\(\s*\)\s*\)", "println(sb.toString()): println(sb) 로")
    res += grep(ctx, r"[=!]=\s*(?:true|false|True|False)\b", "불리언 리터럴과 비교: 조건 자체를 사용")
    return res


def size_exprs(lang, l):
    out = []
    if lang == "java":
        for m in re.finditer(r"\bnew\s+[\w.]+", l):
            j = m.end()
            if j < len(l) and l[j:].lstrip().startswith("<"):
                j = l.index("<", j)
                _, e = bal(l, j, "<", ">")
                if e is None:
                    continue
                j = e
            while j < len(l) and l[j] == "[":
                c, e = bal(l, j, "[", "]")
                if e is None:
                    break
                if c.strip():
                    out.append(c)
                j = e
    elif lang == "py":
        for m in re.finditer(r"\]\s*\*\s*\(", l):
            c, _ = bal(l, m.end() - 1, "(", ")")
            if c is not None:
                out.append(c)
        for m in re.finditer(r"\bfor\s+_\s+in\s+range\s*\(", l):
            c, end = bal(l, m.end() - 1, "(", ")")
            if c is not None and l[end:].lstrip().startswith("]"):
                out.append(c)
    else:
        for m in re.finditer(r"\bvector\s*<", l):
            _, end = bal(l, m.end() - 1, "<", ">")
            if end is None:
                continue
            rest = l[end:]
            m2 = re.match(r"\s*&?\s*(?:\w+\s*)?\(", rest)
            if m2:
                args, _ = bal(l, end + m2.end() - 1, "(", ")")
                if args is not None:
                    out.append(first_arg(args))
            m3 = re.match(r"\s*\w+\s*((?:\[[^\]]*\])+)", rest)
            if m3:
                out += re.findall(r"\[([^\]]*)\]", m3.group(1))
        for m in re.finditer(r"\.(?:resize|assign)\s*\(", l):
            args, _ = bal(l, m.end() - 1, "(", ")")
            if args is not None:
                out.append(first_arg(args))
        for m in re.finditer(r"\b(?:int|long long|long|bool|char|double|string)\s+\w+\s*((?:\[[^\]]*\])+)", l):
            out += re.findall(r"\[([^\]]*)\]", m.group(1))
        for m in re.finditer(r"\barray\s*<[^,>]+,\s*([^>]+)>", l):
            out.append(m.group(1))
    return out


@rule("lcm-order", "필수", ALL, "lcm은 나눗셈 먼저 (9장)")
def r_lcm(ctx):
    return grep(
        ctx,
        r"\w\s*\*\s*[\w.\[\]]+\s*//?\s*(?:math\s*\.\s*|std::)?gcd\s*\(",
        "a * b / gcd 형태: a / gcd(a, b) * b 로",
        cand=True,
    )


@rule("sort-lambda", "필수", ("cpp",), "정렬 비교자 람다 인자는 auto& (13.6)")
def r_sortlambda(ctx):
    res = []
    for ln, l in enumerate(ctx.lines, 1):
        if not (re.search(r"\b(?:stable_)?sort\s*\(", l) or re.search(r"\bcmp\s*=\s*\[", l)):
            continue
        for m in re.finditer(r"\[[^\]]*\]\s*\(", l):
            params, _ = bal(l, m.end() - 1, "(", ")")
            if params is None or not params.strip():
                continue
            bad = [p.strip() for p in split_top(params) if not re.fullmatch(r"auto\s*&\s*\w+", p.strip())]
            if bad:
                res.append((ln, f"정렬 비교자 람다 인자 `{', '.join(bad)}`: `auto& 이름` 형태로"))
    return res


def split_top(s):
    out, d, cur = [], 0, ""
    for ch in s:
        if ch in "<([{":
            d += 1
        elif ch in ">)]}":
            d -= 1
        if ch == "," and d == 0:
            out.append(cur)
            cur = ""
        else:
            cur += ch
    out.append(cur)
    return out


@rule("rename-hint", "권장", ALL, "표준 변수명 (12장) 일부")
def r_rename(ctx):
    res = []
    hints = {"visited": ("vis", False), "answer": ("ans", True), "temp": ("tmp", True), "result": ("res/ans", True)}
    for ln, l in enumerate(ctx.lines, 1):
        for w, (std, cand) in hints.items():
            if re.search(r"\b%s\b" % w, l):
                res.append((ln, f"`{w}` → 표준 이름 `{std}`", True) if cand else (ln, f"`{w}` → 표준 이름 `{std}`"))
    return res


REV_RX = re.compile(r"[\w)\]]\s*-\s*([A-Za-z_]\w*)\s*-\s*1(?![\w.])")
FOR_VAR_RX = {
    "py": re.compile(r"\bfor\s+([\w\s,()]+?)\s+in\b"),
    "java": re.compile(r"\bfor\s*\(\s*(?:final\s+)?(?:int|long|var)\s+(\w+)"),
    "cpp": re.compile(r"\bfor\s*\(\s*(?:int|long long|long|size_t|auto)\s+(\w+)"),
}


@rule("rev-index", "필수", ALL, "끝에서부터 세는 인덱스는 n - 1 - i (13.3, 반복 변수가 맨 뒤 → 후보)")
def r_revindex(ctx):
    loop_vars = set()
    for m in FOR_VAR_RX[ctx.lang].finditer(ctx.code):
        loop_vars |= set(re.findall(r"\w+", m.group(1)))
    res = []
    for ln, l in enumerate(ctx.lines, 1):
        for m in REV_RX.finditer(l):
            if m.group(1) in loop_vars:
                res.append(
                    (
                        ln,
                        f"`{m.group(0).strip()}`: 끝에서부터 세는 인덱스면 `기준 - 1 - {m.group(1)}` 로 (구간 길이면 해당 없음)",
                        True,
                    )
                )
    return res


DIR_STD = {4: ([-1, 0, 1, 0], [0, 1, 0, -1]), 8: ([-1, -1, 0, 1, 1, 1, 0, -1], [0, 1, 1, 1, 0, -1, -1, -1])}
DIR_RX = {
    "py": re.compile(r"\b(dr|dc)\b\s*=\s*[\[(]([^\[\]()]*)[\])]"),
    "java": re.compile(r"\b(dr|dc)\b\s*(?:\[\s*\d*\s*\])?\s*=\s*(?:new\s+int\s*\[\s*\]\s*)?\{([^{}]*)\}"),
    "cpp": re.compile(r"\b(dr|dc)\b\s*(?:\[\s*\d*\s*\])?\s*=\s*\{([^{}]*)\}"),
}


PY_DIR_PAIRS_RX = re.compile(
    r"\bfor\s+(\w+)\s*,\s*(\w+)\s+in\s*[\[(]\s*((?:\(\s*-?\d+\s*,\s*-?\d+\s*\)\s*,?\s*)+)[\])]"
)


@rule("dir-order", "권장", ALL, "4·8방향 배열은 위쪽부터 시계 방향 (12장, 문제가 순서를 정하면 예외 → 후보)")
def r_dirorder(ctx):
    res = []
    for m in DIR_RX[ctx.lang].finditer(ctx.code):
        try:
            vals = [int(x.replace(" ", "")) for x in m.group(2).split(",") if x.strip()]
        except ValueError:
            continue
        if len(vals) not in DIR_STD or any(abs(v) > 1 for v in vals):
            continue  # 나이트 이동 등 4·8방향 아님
        want = DIR_STD[len(vals)][0 if m.group(1) == "dr" else 1]
        if vals != want:
            ln = ctx.code.count("\n", 0, m.start()) + 1
            res.append(
                (
                    ln,
                    f"방향 배열 `{m.group(1)}` {vals}: 위쪽부터 시계 방향이면 {want} (문제가 순서를 정했으면 예외)",
                    True,
                )
            )
    if ctx.lang == "py":  # `for dr, dc in ((-1, 0), ...)` 인라인 튜플
        for m in PY_DIR_PAIRS_RX.finditer(ctx.code):
            if {m.group(1), m.group(2)} != {"dr", "dc"}:
                continue
            pairs = [tuple(int(x) for x in t) for t in re.findall(r"\(\s*(-?\d+)\s*,\s*(-?\d+)\s*\)", m.group(3))]
            if len(pairs) not in DIR_STD or any(abs(v) > 1 for pr in pairs for v in pr):
                continue
            ln = ctx.code.count("\n", 0, m.start()) + 1
            for k, name in enumerate((m.group(1), m.group(2))):
                vals = [pr[k] for pr in pairs]
                want = DIR_STD[len(vals)][0 if name == "dr" else 1]
                if vals != want:
                    res.append(
                        (
                            ln,
                            f"방향 튜플 `{name}` {vals}: 위쪽부터 시계 방향이면 {want} (문제가 순서를 정했으면 예외)",
                            True,
                        )
                    )
    return res


# ---------------------------------------------------------------- 중괄호 (Java·C++)

IF_RE = re.compile(r"^(\s*)(\}\s*)?(else\s+)?if\s*\(")
ELSE_RE = re.compile(r"^\s*(\}\s*)?else\b(?!\s+if\b)\s*(.*)$")
LOOP_RE = re.compile(r"^\s*(?:for|while)\s*\(")
KW_STMT = re.compile(r"(if|for|while|else|do|switch|try|case|default)\b")


def single_stmt(s):
    s = s.strip()
    return s.endswith(";") and s.count(";") == 1 and "{" not in s and "}" not in s and not KW_STMT.match(s)


SINGLE_MSGS = ("단문 if는 같은 줄에 한 줄로", "본문이 단문 하나인 if(else 없음)는 중괄호 없이 한 줄로")


def if_findings(ctx):
    """7.3 if 중괄호 위반 전체. 단문 if 메시지(SINGLE_MSGS)는 if-single(권장), 나머지(else 관련)는 if-braces(필수)."""
    L, out, seen = ctx.lines, [], set()

    def emit(ln, msg):
        if (ln, msg) not in seen:
            seen.add((ln, msg))
            out.append((ln, msg))

    for i, l in enumerate(L):
        m = IF_RE.match(l)
        if m:
            c, end = bal(l, m.end() - 1, "(", ")")
            if end is None:
                continue
            rest = l[end:].strip()
            chain = bool(m.group(3))
            if rest == "":
                j = nb(L, i)
                if j is None or L[j].strip().startswith("{"):
                    continue
                k = nb(L, j)
                has_else = k is not None and L[k].lstrip().startswith("else")
                emit(
                    i + 1,
                    "else가 있는 if는 모든 분기에 중괄호" if (has_else or chain) else "단문 if는 같은 줄에 한 줄로",
                )
            elif rest.startswith("{"):
                if rest == "{" and not chain and not m.group(2):
                    j = nb(L, i)
                    k = nb(L, j) if j is not None else None
                    if k is not None and L[k].strip() == "}" and single_stmt(L[j]):
                        e = nb(L, k)
                        if e is None or not L[e].lstrip().startswith("else"):
                            emit(i + 1, "본문이 단문 하나인 if(else 없음)는 중괄호 없이 한 줄로")
            else:
                k = nb(L, i)
                if chain or (k is not None and L[k].lstrip().startswith("else")):
                    emit(i + 1, "else가 있는 if는 모든 분기에 중괄호")
        em = ELSE_RE.match(l)
        if em:
            rest = em.group(2).strip()
            if rest and not rest.startswith("{"):
                emit(i + 1, "else 분기에 중괄호")
            elif rest == "":
                j = nb(L, i)
                if j is not None and not L[j].strip().startswith("{"):
                    emit(i + 1, "else 분기에 중괄호")
    return out


@rule("if-braces", "필수", ("java", "cpp"), "else가 붙는 if는 모든 분기에 중괄호 (7.3)")
def r_if(ctx):
    return [x for x in if_findings(ctx) if x[1] not in SINGLE_MSGS]


@rule("if-single", "권장", ("java", "cpp"), "단문 if(else 없음)는 중괄호 없이 한 줄로 (7.3)")
def r_if_single(ctx):
    return [x for x in if_findings(ctx) if x[1] in SINGLE_MSGS]


@rule("j-loop-brace", "필수", ("java",), "Java 반복문은 항상 중괄호 (7.3)")
def r_jloop(ctx):
    L, out = ctx.lines, []
    for i, l in enumerate(L):
        if not LOOP_RE.match(l):
            continue
        idx = l.index("(")
        c, end = bal(l, idx, "(", ")")
        if end is None:
            continue
        rest = l[end:].strip()
        if rest == ";":
            continue
        if rest == "":
            j = nb(L, i)
            if j is not None and not L[j].strip().startswith("{"):
                out.append((i + 1, "Java 반복문 본문에 중괄호 없음"))
        elif not rest.startswith("{"):
            out.append((i + 1, "Java 반복문 본문에 중괄호 없음"))
    return out


# ---------------------------------------------------------------- 선언 기반 (네이밍·충돌)

J_DECL = re.compile(
    r"(?P<mods>(?:\b(?:public|private|protected|static|final)\s+)*)"
    r"\b(?P<type>int|long|double|float|boolean|char|short|byte|String|Integer|Long)"
    r"(?P<arr>(?:\s*\[\s*\])*)\s+(?P<name>[A-Za-z_]\w*)\s*(?P<after>[=;,\[:])"
)
C_DECL = re.compile(
    r"(?P<mods>(?:\b(?:static|const|constexpr|inline)\s+)*)"
    r"\b(?P<type>long long|unsigned long long|unsigned|int|long|double|float|bool|char|string|auto|size_t"
    r"|vector\s*<[^;()=]*?>)\s*(?P<ref>[&*]*)\s+(?P<name>[A-Za-z_]\w*)\s*(?P<after>[=;\[:{])"
)


# 컨테이너·pair 선언은 이름 충돌(1.4)만 본다. 다른 규칙의 선언 판정은 C_DECL 그대로다.
C_CONT_DECL = re.compile(
    r"\b(?:set|multiset|map|multimap|unordered_set|unordered_map|stack|queue|priority_queue|deque|array|bitset"
    r"|pair|tuple)\s*<[^;()=]*?>\s*[&*]*\s+(?P<name>[A-Za-z_]\w*)\s*(?P<after>[=;\[:{(,])"
)


def iter_decls(ctx):
    rx = J_DECL if ctx.lang == "java" else C_DECL
    for ln, l in enumerate(ctx.lines, 1):
        for m in rx.finditer(l):
            yield ln, m


FUNC_PARAMS = re.compile(r"\s*(?:\)|[\w:<>,\s]*?[&*\s]\s*[A-Za-z_]\w*\s*[,)])")


def iter_decls_scoped(ctx):
    """C++ 선언을 (줄, 매치, 범위)로 순회한다. 범위는 global / member(struct·class 멤버) / local.
    중괄호를 세는 근사다: `struct`·`class`·`union`·`enum` 머리 뒤의 `{` 안이 멤버, 그 밖의 `{` 안이 지역."""
    stack, head = [], ""

    def step(ch):
        nonlocal head
        if ch == "{":
            stack.append("type" if re.search(r"\b(?:struct|class|union|enum)\b", head) else "block")
            head = ""
        elif ch == "}":
            if stack:
                stack.pop()
            head = ""
        elif ch == ";":
            head = ""
        else:
            head += ch

    for ln, l in enumerate(ctx.lines, 1):
        pos = 0
        for m in sorted(list(C_DECL.finditer(l)) + list(C_CONT_DECL.finditer(l)), key=lambda x: x.start()):
            for ch in l[pos : m.start()]:
                step(ch)
            pos = m.start()
            kind = "global" if not stack else ("member" if stack[-1] == "type" else "local")
            prefix = l[: m.start()]
            if kind == "global" and prefix.count("(") > prefix.count(")"):
                kind = "local"  # 함수 머리의 매개변수
            if kind == "global" and m.group("after") == "(" and FUNC_PARAMS.match(l, m.end()):
                continue  # `pair<int, int> merge(pair<int, int> a, ...)` 같은 함수 선언은 변수가 아니다
            yield ln, m, kind
        for ch in l[pos:]:
            step(ch)
        head += " "


UPPER_RX = re.compile(r"^[A-Z][A-Z0-9_]*$")
SNAKE_RX = re.compile(r"^[a-z][a-z0-9]*(?:_[a-z0-9]+)+$")
CAMEL_RX = re.compile(r"^[a-z]+[A-Z]")


def judge_given(path, func_name):
    """저지가 정해 준 시그니처의 메서드인가 (1.3: 매개변수 이름은 절대 바꾸지 않는다, 최우선).
    프로그래머스는 `solution`, LeetCode 는 `Solution` 클래스의 메서드(이름은 문제마다 다름)."""
    parts = path.replace(os.sep, "/").split("/")
    if any(p.startswith("prms_") for p in parts):
        return func_name == "solution"
    return any(p.startswith("leet_") for p in parts)


@rule("name-case", "필수", ALL, "변수·상수 표기 (1.1~1.3)")
def r_namecase(ctx):
    res = []
    if ctx.lang == "py":
        return py_namecase(ctx)
    for ln, m in iter_decls(ctx):
        d = m.groupdict()
        name, mods, typ = d["name"], d["mods"], d["type"]
        arr = (
            bool(d.get("arr", "").strip())
            or typ.startswith("vector")
            or m.group("after") == "["
            or bool(d.get("ref"))
            or typ in ("string", "auto")
        )
        const = ("final" if ctx.lang == "java" else "const") in mods.split()
        line = ctx.lines[ln - 1]
        prefix = line[: m.start()]
        # 메서드 시그니처의 매개변수는 저지가 준 이름이라 소문자 형태 검사를 건너뜀 (1.3 허용). 대문자는 계속 검사.
        is_param = prefix.count("(") - prefix.count(")") > 0 and not re.match(
            r"\s*(?:for|while|if|catch|switch|try)\b", line
        )
        if ctx.lang == "cpp" and "constexpr" in mods:
            res.append((ln, f"`constexpr` 사용 ({name}): const 로"))
        if is_param and (UPPER_RX.match(name) or name[0].isupper()):
            mname = re.search(r"(\w+)\s*\([^()]*$", prefix)
            if mname and judge_given(ctx.path, mname.group(1)):
                continue  # 저지가 준 시그니처 매개변수는 대문자여도 바꾸지 않는다 (1.3)
        if UPPER_RX.match(name):
            if not (const and not arr):
                res.append(
                    (
                        ln,
                        f"대문자 이름 `{name}`: 변수는 소문자 (상수만 {'final' if ctx.lang == 'java' else 'const'} 스칼라 UPPER_SNAKE)",
                    )
                )
        elif name[0].isupper():
            res.append((ln, f"`{name}`: 변수는 소문자로 시작"))
        else:
            if const and not arr:
                res.append((ln, f"스칼라 상수 `{name}`는 UPPER_SNAKE_CASE"))
            elif const and arr:
                res.append((ln, f"`{name}`: const/final 은 스칼라 상수에만 (배열·참조·컨테이너에는 붙이지 않음)"))
            if is_param:
                continue
            if ctx.lang == "java" and SNAKE_RX.match(name):
                res.append((ln, f"Java 변수 `{name}`는 camelCase"))
            if ctx.lang == "cpp" and CAMEL_RX.match(name):
                res.append((ln, f"C++ 변수 `{name}`는 snake_case"))
    return res


def py_namecase(ctx):
    res = []
    if not ctx.tree:
        return res

    def constish(v):
        if v is None:
            return False
        # INF = float("inf") 처럼 상수 인자만 받는 형변환 호출도 상수로 본다
        if isinstance(v, ast.Call) and isinstance(v.func, ast.Name) and v.func.id in ("float", "int", "str"):
            return all(isinstance(a, ast.Constant) for a in v.args) and not v.keywords
        return all(
            isinstance(n, (ast.Constant, ast.UnaryOp, ast.BinOp, ast.operator, ast.unaryop, ast.Tuple, ast.Load))
            for n in ast.walk(v)
        )

    given = set()  # 저지가 준 시그니처의 매개변수 이름 (재할당해도 이름은 그대로, 1.3)
    for node in ast.walk(ctx.tree):
        if isinstance(node, ast.FunctionDef) and judge_given(ctx.path, node.name):
            a = node.args
            given |= {x.arg for x in a.posonlyargs + a.args + a.kwonlyargs}

    for node in ast.walk(ctx.tree):
        targets = []
        value = None
        if isinstance(node, ast.Assign):
            targets, value = node.targets, node.value
        elif isinstance(node, (ast.AugAssign, ast.AnnAssign)):
            targets, value = [node.target], getattr(node, "value", None)
        elif isinstance(node, (ast.For, ast.comprehension)):
            targets, value = [node.target], None
        for t in targets:
            for n in ast.walk(t):
                if isinstance(n, ast.Name) and isinstance(n.ctx, ast.Store):
                    nm = n.id
                    if nm in given and (UPPER_RX.match(nm) or nm[0].isupper()):
                        continue
                    if UPPER_RX.match(nm):
                        if not constish(value):
                            res.append((n.lineno, f"대문자 이름 `{nm}`: 상수가 아닌 변수는 소문자"))
                    elif nm[0].isupper():
                        res.append((n.lineno, f"`{nm}`: 변수는 소문자로 시작"))
                    elif CAMEL_RX.match(nm):
                        res.append((n.lineno, f"Python 변수 `{nm}`는 snake_case"))
    return res


@rule("name-collision", "필수", ("cpp", "py"), "전역 선언의 std·C 이름 충돌, Python 내장 이름 가림 (1.4)")
def r_collision(ctx):
    res = []
    lists = name_lists()
    if ctx.lang == "cpp":
        for ln, m, kind in iter_decls_scoped(ctx):
            if kind == "global" and m.group("name") in lists["cpp_global"]:
                res.append((ln, f"`{m.group('name')}`: 전역 선언이 std·C 라이브러리 이름과 충돌"))
        return res
    if not ctx.tree:
        return res
    bad = lists["py"]
    in_class_methods = set()
    for n in ast.walk(ctx.tree):
        if isinstance(n, ast.ClassDef):
            for b in n.body:
                if isinstance(b, (ast.FunctionDef, ast.AsyncFunctionDef)):
                    in_class_methods.add(id(b))
    # 저지가 정한 함수 시그니처의 매개변수명은 바꾸지 않는다 (1.3): 최상위 solution, class Solution 메서드
    sig_args = set()
    for n in ast.walk(ctx.tree):
        fns = []
        if isinstance(n, ast.FunctionDef) and n.name == "solution" and n in ctx.tree.body:
            fns.append(n)
        elif isinstance(n, ast.ClassDef) and n.name == "Solution":
            fns.extend(b for b in n.body if isinstance(b, ast.FunctionDef))
        for fn in fns:
            a = fn.args
            sig_args.update(id(x) for x in a.posonlyargs + a.args + a.kwonlyargs)
    for n in ast.walk(ctx.tree):
        names = []
        if isinstance(n, ast.Name) and isinstance(n.ctx, ast.Store):
            names.append((n.id, n.lineno))
        elif isinstance(n, ast.arg):
            if id(n) not in sig_args:
                names.append((n.arg, n.lineno))
        elif (
            isinstance(n, (ast.FunctionDef, ast.AsyncFunctionDef))
            and id(n) not in in_class_methods
            or isinstance(n, ast.ClassDef)
        ):
            names.append((n.name, n.lineno))
        for nm, ln in names:
            if nm.startswith("_") or nm not in bad:
                continue
            if nm == "input" and re.search(r"input\s*=\s*sys\s*\.\s*stdin\s*\.\s*readline", ctx.lines[ln - 1]):
                continue
            res.append((ln, f"`{nm}`: 내장 이름 섀도잉"))
    return res


@rule("name-shadow", "권장", ("cpp",), "지역 변수의 std 이름 가림 (1.4)")
def r_shadow(ctx):
    local = name_lists()["cpp_local"]
    return [
        (ln, f"`{m.group('name')}`: 지역 변수가 std 이름을 가림")
        for ln, m, kind in iter_decls_scoped(ctx)
        if kind == "local" and m.group("name") in local
    ]


# ---------------------------------------------------------------- Java 전용


@rule("j-scanner", "필수", ("java",), "Scanner 금지 (4.1)")
def r_scanner(ctx):
    return grep(ctx, r"\bnew\s+Scanner\b|import\s+java\.util\.Scanner", "Scanner 사용")


@rule("j-split", "권장", ("java",), "split 사용: StringTokenizer 우선 (4.1, 수정은 선택)")
def r_jsplit(ctx):
    return grep(ctx, r"\.split\(", "split 사용: StringTokenizer 가 확실히 못한 경우만 허용")


@rule("j-append-sep", "필수", ("java",), 'StringBuilder 구분자는 문자열 리터럴 "\\n"·" " (4.1)')
def r_jappendsep(ctx):
    return grep(ctx, r"\.append\(\s*'(?:\\n| )'\s*\)", '구분자를 char 로 붙임: "\\n"·" " 문자열로')


@rule("j-import", "필수", ("java",), "와일드카드 import (4.1)")
def r_jimport(ctx):
    return grep(ctx, r"^\s*import\s+(?!static\b)[\w.]+\.[A-Za-z]\w*\s*;", "개별 클래스 import: 패키지 단위 * 로")


@rule("j-queue-api", "필수", ("java",), "Queue/Deque API (4.2)")
def r_queue_api(ctx):
    res = []
    decl = re.compile(r"\b(Queue|PriorityQueue|Deque|ArrayDeque)\s*<[^;=]*?>\s+(\w+)\s*(?:=|;)")
    names = {}
    for l in ctx.lines:
        for m in decl.finditer(l):
            names[m.group(2)] = m.group(1)
    for nm, kind in names.items():
        if kind in ("Queue", "PriorityQueue"):
            pat = r"\b%s\s*\.\s*(?:add\s*\(|remove\s*\(|element\s*\(\s*\))" % re.escape(nm)
        else:
            pat = (
                r"\b%s\s*\.\s*(?:add\s*\(|addFirst|addLast|removeFirst|removeLast|getFirst|getLast"
                r"|remove\s*\(|element\s*\(\s*\))" % re.escape(nm)
            )
        res += grep(ctx, pat, f"`{nm}`({kind}): offer/poll/peek 계열만 (Deque 는 offerFirst 등)")
    return res


@rule("j-queue-impl", "필수", ("java",), "큐·덱 구현체는 ArrayDeque (4.2)")
def r_queue_impl(ctx):
    return grep(
        ctx, r"\b(?:Queue|Deque)\s*<[^;=]*?>\s+\w+\s*=\s*new\s+LinkedList", "LinkedList 를 큐/덱으로 사용"
    ) + grep(
        ctx,
        r"\bLinkedList\s*<[^;=]*?>\s+\w+\s*=\s*new\s+LinkedList",
        "LinkedList 변수: 큐/덱 용도면 ArrayDeque",
        cand=True,
    )


@rule("j-stack", "필수", ("java",), "레거시 Stack 금지 (4.2)")
def r_stack(ctx):
    return grep(ctx, r"\bStack\s*<|\bnew\s+Stack\b", "java.util.Stack 사용: ArrayDeque 로")


@rule("j-cmp-sub", "필수", ("java",), "뺄셈 비교자 금지 (13.6)")
def r_cmpsub(ctx):
    res = grep(
        ctx,
        r"\(\s*(\w+)\s*,\s*(\w+)\s*\)\s*->\s*(?:\{\s*return\s+)?"
        r"(?:\1(?:\.\w+|\[\w+\])*\s*-\s*\2|\2(?:\.\w+|\[\w+\])*\s*-\s*\1)(?![\w.\[])",
        "뺄셈 비교자: Integer.compare / Comparator.comparingInt 로",
    )
    L = ctx.lines
    ret = re.compile(r"\breturn\s+([\w.\[\]]+)\s*-\s*([\w.\[\]]+)\s*;")
    for i, l in enumerate(L):
        m = ret.search(l)
        if not m:
            continue
        a, b = (re.match(r"\w+", m.group(1)), re.match(r"\w+", m.group(2)))
        if not a or not b:
            continue
        back = " ".join(L[max(0, i - 3) : i])
        lam = re.search(
            r"\(\s*(%s|%s)\s*,\s*(%s|%s)\s*\)\s*->" % ((re.escape(a.group()), re.escape(b.group())) * 2), back
        )
        if lam or re.search(r"\bcompareTo\b|\bcompare\s*\(", back):
            res.append((i + 1, "뺄셈 비교자(블록/compareTo): Integer.compare 로"))
    return res


@rule("j-reverse-order", "필수", ("java",), "Collections.reverseOrder 금지 (13.6)")
def r_revorder(ctx):
    return grep(ctx, r"Collections\s*\.\s*reverseOrder\s*\(", "Comparator.reverseOrder() 로")


@rule("j-adj-list", "필수", ("java",), "인접 리스트는 제네릭 배열 (13.5)")
def r_jadj(ctx):
    return grep(
        ctx,
        r"\b(?:List|ArrayList)\s*<\s*(?:List|ArrayList)\s*<[^;=]*?>\s*>\s+adj\w*\b",
        "인접 리스트를 List<List<>> 로: List<Integer>[] 배열로",
    )


@rule("j-io-template", "필수", ("java",), "BufferedReader / throws IOException / try-catch 금지 (4.1)")
def r_jio(ctx):
    res = []
    code = ctx.code
    if not ctx.stdin_judge or not re.search(r"static\s+void\s+main\s*\(", code):
        return res
    if (
        re.search(r"System\s*\.\s*in\b", code)
        and not re.search(r"\bBufferedReader\b", code)
        and not re.search(r"\bScanner\b", code)
    ):
        res.append((1, "표준 입력을 BufferedReader 없이 읽음"))
    m = re.search(r"static\s+void\s+main\s*\([^)]*\)\s*(throws\s+[\w., ]+)?\s*\{", code)
    if m and re.search(r"\bBufferedReader\b", code) and not (m.group(1) and "IOException" in m.group(1)):
        res.append((code[: m.start()].count("\n") + 1, "main 에 throws IOException 없음"))
    res += grep(ctx, r"\bcatch\s*\(", "try-catch 사용 (main 은 throws IOException 만)")
    return res


@rule("j-loop-print", "권장", ("java",), "루프 안 System.out 직접 출력 (4.1, 소량이어도 지적·수정은 선택)")
def r_jloopprint(ctx):
    out, stack, pending = [], [], False
    for ln, l in enumerate(ctx.lines, 1):
        if LOOP_RE.match(l) or re.match(r"\s*do\b", l):
            pending = True
        if any(stack) and re.search(r"\bSystem\s*\.\s*out\s*\.\s*(?:println|print|printf)\s*\(", l):
            out.append((ln, "루프 안 직접 출력: StringBuilder 에 모아 마지막에 한 번 (소량이어도 지적, 수정은 선택)"))
        for ch in l:
            if ch == "{":
                stack.append(pending)
                pending = False
            elif ch == "}" and stack:
                stack.pop()
            elif ch == ";" and pending and not stack:
                pending = False
    return out


@rule("j-boxed-eq", "필수", ("java",), "박싱 타입 값 ==/!= 비교 금지 (4.3, 타입 추정이라 일부 후보)")
def r_jboxed(ctx):
    boxed, boxed_arr = set(), set()
    for ln, m in iter_decls(ctx):
        if m.group("type") in ("Integer", "Long"):
            target = boxed_arr if m.group("arr").strip() else boxed
            target.add(m.group("name"))
            rest = ctx.lines[ln - 1][m.end() :].split(";")[0]
            target.update(re.findall(r",\s*([A-Za-z_]\w*)\s*(?==|,|$)", rest))
    out = []
    ref = r"(?:\b(?:%s)\b(?!\s*[\[(])|\b(?:%s)\s*\[[^\]]*\]|\.get\([^()]*\))"
    if not (boxed or boxed_arr):
        names_rx = None
    else:
        names_rx = re.compile(
            ref % ("|".join(map(re.escape, boxed)) or r"(?!)", "|".join(map(re.escape, boxed_arr)) or r"(?!)")
        )
    for ln, l in enumerate(ctx.lines, 1):
        for m in re.finditer(r"([^=!<>]+?)\s*([=!]=)\s*([^=;)&|?]+)", l):
            lhs, rhs = m.group(1).strip(), m.group(3).strip()
            if not names_rx:
                continue
            a = names_rx.search(lhs[-40:]) and re.search(r"(?:\w|\]|\))$", lhs)
            b = names_rx.match(rhs) or re.match(r"[\w.]+\.get\([^()]*\)", l[m.start(3) :])
            if a and b:
                get = ".get(" in lhs[-40:] or rhs.startswith(".get(")
                out.append((ln, "박싱 타입 값을 ==/!= 로 비교: equals 또는 기본형으로", get))
    return out


# ---------------------------------------------------------------- 오버플로 승격 (Java·C++)


def paren_span(l, i):
    """l[i] 가 `(` 일 때 짝이 맞는 `)` 의 위치. 없으면 -1."""
    depth = 0
    for j in range(i, len(l)):
        depth += (l[j] == "(") - (l[j] == ")")
        if depth == 0:
            return j
    return -1


def cast_groups(ctx):
    """`(long)(...)` 형태마다 (줄, 괄호 안에 곱셈이 있는가, 괄호 뒤가 곱셈인가)."""
    ty = "long" if ctx.lang == "java" else r"long long|long"
    out = []
    for ln, l in enumerate(ctx.lines, 1):
        for m in re.finditer(r"\(\s*(?:%s)\s*\)\s*\(" % ty, l):
            end = paren_span(l, m.end() - 1)
            if end < 0:
                continue
            out.append((ln, "*" in l[m.end() : end], bool(re.match(r"\s*\*", l[end + 1 :]))))
    return out


@rule("mul-cast", "필수", ("java", "cpp"), "곱셈 승격 위치 (8.1)")
def r_mulcast(ctx):
    one = "1L" if ctx.lang == "java" else "1LL"
    res = [
        (ln, "(long)(a * b): 곱한 뒤 승격. %s * a * b 로" % one) for ln, inner_mul, _ in cast_groups(ctx) if inner_mul
    ]
    res += grep(
        ctx,
        r"[\w\])]\s*\*\s*[\w.\[\]()]+\s*\*\s*1(?:L|LL)\b",
        "a * b * %s: 승격은 첫 곱셈 앞에" % one,
    )
    return res


@rule("mul-cast-style", "권장", ("java", "cpp"), "곱셈 승격 표기 (8.1)")
def r_mulcast_style(ctx):
    one = "1L" if ctx.lang == "java" else "1LL"
    ty = "long" if ctx.lang == "java" else r"long long|long"
    msg = "(long) a * b 캐스트: 오버플로는 없으나 표기는 %s * a * b 로" % one
    res = grep(ctx, r"\(\s*(?:%s)\s*\)\s*[\w.\[\]]+\s*\*" % ty, msg)
    res += [(ln, msg) for ln, inner_mul, after_mul in cast_groups(ctx) if after_mul and not inner_mul]
    return res


# ---------------------------------------------------------------- C++ 전용


@rule("c-header", "필수", ("cpp",), "첫 두 줄 + 빈 줄 (3장)")
def r_cheader(ctx):
    L = ctx.rawlines
    ok = len(L) >= 3 and L[0] == "#include <bits/stdc++.h>" and L[1] == "using namespace std;" and L[2] == ""
    return [] if ok else [(1, "첫 두 줄이 `#include <bits/stdc++.h>` / `using namespace std;` + 빈 줄이 아님")]


@rule("c-sync", "필수", ("cpp",), "sync_with_stdio(0); cin.tie(0); (3장)")
def r_csync(ctx):
    code = ctx.code
    m = re.search(r"\bint\s+main\s*\(", code)
    if not m or not re.search(r"\bcin\b|\bcout\b", code):
        return []
    res, ln = [], code[: m.start()].count("\n") + 1
    if not re.search(r"sync_with_stdio\s*\(\s*0\s*\)", code):
        res.append((ln, "ios::sync_with_stdio(0) 없음 또는 인자가 0 이 아님"))
    if not re.search(r"\bcin\s*\.\s*tie\s*\(\s*0\s*\)", code):
        res.append((ln, "cin.tie(0) 없음 또는 인자가 0 이 아님"))
    return res


@rule("c-endl", "필수", ("cpp",), "endl 금지 (3장)")
def r_endl(ctx):
    return grep(ctx, r"\bendl\b", "endl 사용: '\\n'")


@rule("c-cio", "필수", ("cpp",), "C 입출력 금지 (3장)")
def r_cio(ctx):
    return grep(ctx, r"\b(?:scanf|printf|puts|gets|putchar|getchar|fgets|sscanf|fscanf|fprintf)\s*\(", "C 입출력 사용")


@rule("c-return0", "필수", ("cpp",), "main 끝 return 0 생략 (3장)")
def r_return0(ctx):
    L, res = ctx.lines, []
    for i, l in enumerate(L):
        if not re.match(r"^\s+return\s+0\s*;\s*$", l):
            continue
        j = nb(L, i)
        if j is None or not re.match(r"^\}", L[j]):
            continue
        k = i
        while k >= 0 and not (L[k] and not L[k][0].isspace() and L[k].rstrip().endswith("{")):
            k -= 1
        if k >= 0 and re.search(r"\bmain\s*\(", L[k]):
            res.append((i + 1, "main 끝의 return 0; 생략"))
    return res


@rule("c-alias", "필수", ("cpp",), "타입 별칭·매크로 금지 (13.2)")
def r_alias(ctx):
    return grep(ctx, r"^\s*using\s+\w+\s*=|\btypedef\b|^\s*#\s*define\b", "타입 별칭/매크로 사용")


@rule("c-const", "필수", ("cpp",), "const 는 스칼라 상수에만 (1.1)")
def r_cconst(ctx):
    return grep(ctx, r"\bconst\s+(?:auto|[\w:<>,\s]+?)\s*&", "const 참조 인자/변수: auto& 로")


@rule("c-auto-basic", "필수", ("cpp",), "기본형·string 은 auto 금지 (8.2)")
def r_cauto(ctx):
    res = grep(ctx, r"\bauto\s+\w+\s*=\s*(?:-?\d|true\b|false\b)", "리터럴 초기화에 auto: 타입 명시")
    res += grep(ctx, r"\bfor\s*\(\s*auto\s+\w+\s*:", "범위 for 원소 auto (값): 기본형이면 타입 명시", cand=True)
    res += grep(ctx, r"\bfor\s*\(\s*auto\s*&\s*\w+\s*:", "범위 for 원소 auto&: 기본형이면 타입 명시", cand=True)
    return res


@rule("c-large-local", "필수", ("cpp",), "10만 이상 고정 배열은 전역 (10장)")
def r_clarge(ctx):
    consts = {}
    for m in re.finditer(r"\bconst\s+(?:int|long long|long|size_t)\s+(\w+)\s*=\s*([\d']+)\s*;", ctx.code):
        consts[m.group(1)] = int(m.group(2).replace("'", ""))

    def ev(e):
        e = re.sub(r"[A-Za-z_]\w*", lambda m: str(consts.get(m.group(0), "?")), e.replace("'", ""))
        if "?" in e or not re.fullmatch(r"[\d\s+\-*()]+", e):
            return None
        try:
            return int(eval(e, {"__builtins__": {}}))
        except Exception:
            return None

    res = []
    decl = re.compile(
        r"^\s+(?!static\b)(?:int|long long|long|char|bool|double|float|unsigned|string|vector\s*<[^;()]*?>)"
        r"\s+\w+\s*((?:\[[^\]]*\])+)"
    )
    for ln, l in enumerate(ctx.lines, 1):
        m = decl.match(l)
        dims = re.findall(r"\[([^\]]*)\]", m.group(1)) if m else []
        am = re.match(r"^\s+(?!static\b)(?:std::)?array\s*<[^,>]+,\s*([^>]+)>", l)
        if am:
            dims = [am.group(1)]
        if not dims:
            continue
        prod = 1
        for d in dims:
            v = ev(d)
            if v is None:
                prod = None
                break
            prod *= v
        if prod is not None and prod >= 100_000:
            res.append((ln, f"지역 고정 배열 크기 {prod}: 전역으로"))
    return res


@rule("c-accumulate", "필수", ("cpp",), "accumulate 초깃값 타입 (8.3)")
def r_accum(ctx):
    return grep(ctx, r"\baccumulate\s*\([^;]*,\s*0\s*\)", "accumulate 초깃값 0: 합이 int 를 넘으면 0LL", cand=True)


@rule("c-npos", "필수", ("cpp",), "string::npos 금지 (13.4)")
def r_npos(ctx):
    return grep(ctx, r"\bnpos\b", "string::npos 대신 -1 비교")


@rule("c-greater-sort", "필수", ("cpp",), "정렬에 greater 금지 (13.6)")
def r_greater(ctx):
    return grep(
        ctx,
        r"\b(?:sort|stable_sort|partial_sort|nth_element)\s*\([^;]*\bgreater\s*<",
        "정렬에 greater: rbegin/rend 또는 reverse",
    )


@rule("c-class", "필수", ("cpp",), "보조 타입은 struct (13.2)")
def r_cclass(ctx):
    return grep(ctx, r"^\s*class\s+(?!Solution\b)\w+", "class 대신 struct")


@rule("c-adj-vec2", "필수", ("cpp",), "인접 리스트는 vector 배열 (13.5)")
def r_cadj(ctx):
    return grep(
        ctx,
        r"\bvector\s*<\s*vector\s*<[^;]*?>\s*>\s+adj\w*\b",
        "인접 리스트를 vector<vector<>> 로: vector<int> adj[N] 배열로",
    )


@rule("c-readloop", "필수", ("cpp",), "원소 전체 입력은 for (int& x : v) (14장)")
def r_readloop(ctx):
    res, L = [], ctx.lines
    one = re.compile(
        r"\bfor\s*\(\s*int\s+(\w+)\s*=\s*0\s*;\s*\1\s*<\s*[\w.()+\-]+\s*;\s*\1\s*\+\+\s*\)\s*\{?\s*cin\s*>>\s*\w+\s*\[\s*\1\s*\]\s*;"
    )
    head = re.compile(r"\bfor\s*\(\s*int\s+(\w+)\s*=\s*0\s*;\s*\1\s*<\s*[\w.()+\-]+\s*;\s*\1\s*\+\+\s*\)\s*\{\s*$")
    for i, l in enumerate(L):
        if one.search(l):
            res.append(
                (
                    i + 1,
                    "인덱스 for 로 cin >> v[i]: for (int& x : v) cin >> x; (1-indexed 등 인덱스 필요 시 예외)",
                    True,
                )
            )
            continue
        m = head.search(l)
        if m:
            j = nb(L, i)
            k = nb(L, j) if j is not None else None
            if (
                k is not None
                and re.match(r"^\s*cin\s*>>\s*\w+\s*\[\s*%s\s*\]\s*;\s*$" % re.escape(m.group(1)), L[j])
                and L[k].strip() == "}"
            ):
                res.append(
                    (
                        i + 1,
                        "인덱스 for 로 cin >> v[i]: for (int& x : v) cin >> x; (1-indexed 등 인덱스 필요 시 예외)",
                        True,
                    )
                )
    return res


# ---------------------------------------------------------------- Python 전용


@rule("py-imports", "필수", ("py",), "import 방식 표, import * 금지 (5장)")
def r_pyimports(ctx):
    res = []
    if not ctx.tree:
        return res
    for n in ast.walk(ctx.tree):
        if isinstance(n, ast.ImportFrom):
            if any(a.name == "*" for a in n.names):
                res.append((n.lineno, "from 모듈 import * 금지"))
            if n.module in ("sys", "math", "heapq", "string") and n.level == 0:
                res.append((n.lineno, f"`{n.module}` 는 `import {n.module}` 방식"))
        elif isinstance(n, ast.Import):
            for a in n.names:
                if a.name in ("collections", "itertools", "functools", "bisect"):
                    res.append((n.lineno, f"`{a.name}` 는 `from {a.name} import 이름` 방식"))
    return res


@rule("py-stdin", "필수", ("py",), "input = sys.stdin.readline (5장)")
def r_pystdin(ctx):
    if not ctx.stdin_judge or not ctx.tree:
        return []
    uses = any(
        isinstance(n, ast.Call) and isinstance(n.func, ast.Name) and n.func.id == "input" for n in ast.walk(ctx.tree)
    )
    has = re.search(r"input\s*=\s*sys\s*\.\s*stdin\s*\.\s*readline", ctx.code)
    return [(1, "input() 을 쓰는데 input = sys.stdin.readline 이 없음")] if uses and not has else []


@rule("py-format", "필수", ("py",), "f-string 만 (5장)")
def r_pyformat(ctx):
    res, T = [], ctx.tokens
    for i, t in enumerate(T):
        if (
            t.type == tokenize.OP
            and t.string == "%"
            and i > 0
            and T[i - 1].type in (tokenize.STRING, getattr(tokenize, "FSTRING_END", -1))
        ):
            res.append((t.start[0], "% 포매팅: f-string 으로"))
        if (
            t.type == tokenize.NAME
            and t.string == "format"
            and i > 0
            and T[i - 1].string == "."
            and i + 1 < len(T)
            and T[i + 1].string == "("
        ):
            res.append((t.start[0], ".format() 포매팅: f-string 으로"))
    return res


@rule("py-loop-print", "권장", ("py",), "루프 안 print 직접 호출 (5장, 소량이어도 지적·수정은 선택)")
def r_pyloopprint(ctx):
    if not ctx.tree:
        return []
    seen = set()
    for loop in ast.walk(ctx.tree):
        if not isinstance(loop, (ast.For, ast.AsyncFor, ast.While)):
            continue
        for stmt in loop.body + loop.orelse:
            for n in ast.walk(stmt):
                if isinstance(n, ast.Call) and isinstance(n.func, ast.Name) and n.func.id == "print":
                    seen.add(n.lineno)
    return [
        (ln, "루프 안 직접 출력: out 리스트에 모아 마지막에 한 번 (소량이어도 지적, 수정은 선택)")
        for ln in sorted(seen)
    ]


@rule("py-recursion", "필수", ("py",), "재귀 시 setrecursionlimit(10**6) (5장)")
def r_pyrec(ctx):
    if not ctx.tree:
        return []
    limit_calls = [
        n
        for n in ast.walk(ctx.tree)
        if isinstance(n, ast.Call) and isinstance(n.func, ast.Attribute) and n.func.attr == "setrecursionlimit"
    ]
    for f in ast.walk(ctx.tree):
        if not isinstance(f, (ast.FunctionDef, ast.AsyncFunctionDef)):
            continue
        for c in ast.walk(f):
            if isinstance(c, ast.Call):
                fn = c.func
                if (isinstance(fn, ast.Name) and fn.id == f.name) or (
                    isinstance(fn, ast.Attribute)
                    and isinstance(fn.value, ast.Name)
                    and fn.value.id == "self"
                    and fn.attr == f.name
                ):
                    if not limit_calls:
                        return [(f.lineno, f"`{f.name}` 가 재귀인데 sys.setrecursionlimit 없음")]
                    bad = [c2 for c2 in limit_calls if not c2.args or py_literal_int(c2.args[0]) != 10**6]
                    return [(b.lineno, "setrecursionlimit 값이 10**6 이 아님") for b in bad]
    return []


# ---------------------------------------------------------------- 문서 대응 검사


def rule_sec(doc):
    """규칙 설명에 적힌 문서 절 번호. `(7.3)`, `(5장)` 형태에서 뽑는다."""
    m = re.search(r"\((\d+장|\d+\.\d+)", doc)
    return m.group(1).rstrip("장") if m else None


def parse_conventions(text):
    """절 번호 → 그 절 본문에 쓰인 등급 태그 집합. `## N.`은 장, `### N.M`은 절."""
    secs, cur = {}, None
    for l in text.split("\n"):
        h = re.match(r"^##\s+(\d+)\.", l) or re.match(r"^###\s+(\d+\.\d+)\b", l)
        if h:
            cur = h.group(1)
            secs.setdefault(cur, set())
            continue
        t = re.match(r"^\s*- `\[(필수|권장|허용)\]`", l)
        if t and cur:
            secs[cur].add(t.group(1))
    return secs


def sec_family(secs, sec):
    return {k for k in secs if k == sec or k.startswith(sec + ".")}


def check_docs():
    with open(DOC_PATH, encoding="utf-8") as f:
        text = f.read()
    secs = parse_conventions(text)
    problems, covered = [], set()
    for rid, (tier, _langs, doc, _fn) in RULES.items():
        sec = rule_sec(doc)
        if sec is None:
            problems.append(f"{rid}: 설명에 문서 절 번호가 없음")
            continue
        fam = sec_family(secs, sec)
        if not fam:
            problems.append(f"{rid}: 문서에 {sec} 절이 없음")
            continue
        covered |= fam
        tiers = set().union(*(secs[k] for k in fam))
        if tier not in tiers:
            problems.append(f"{rid}: 스크립트 등급 [{tier}] 가 문서 {sec} 의 등급 {sorted(tiers)} 에 없음")
    for sec in GAPS:
        if sec not in secs:
            problems.append(f"GAPS: 문서에 {sec} 절이 없음")
    lists = name_lists()
    for k, lab in (("cpp_global", "C++ 전역 목록"), ("cpp_local", "C++ 지역 목록"), ("py", "Python 목록")):
        if not lists[k]:
            problems.append(f"문서에서 `{lab}:` 줄을 읽지 못함")
    only_local = lists["cpp_local"] - lists["cpp_global"]
    if only_local:
        problems.append(f"C++ 지역 목록에만 있는 이름 {sorted(only_local)}: 전역 목록에도 있어야 함")
    print("== 문서 대응")
    print("\n".join(problems) if problems else "불일치 없음")
    print("\n== 정독 대상 (스크립트가 못 보거나 일부만 보는 절)")
    for sec in sorted((k for k in secs if secs[k] & {"필수", "권장"}), key=lambda x: [int(n) for n in x.split(".")]):
        if sec not in covered:
            print(f"{sec:>5}  미검사  {GAPS.get(sec, '스크립트 규칙 없음')}")
        elif sec in GAPS:
            print(f"{sec:>5}  일부    {GAPS[sec]}")
    return 1 if problems else 0


# ---------------------------------------------------------------- 실행


def lang_of(path):
    return EXT_LANG.get(os.path.splitext(path)[1])


def skipped(path):
    return any(part.startswith(SKIP_PREFIXES) for part in os.path.normpath(path).split(os.sep))


def old_month(name):
    return re.fullmatch(r"\d{4}-\d{2}", name) is not None and name < FIRST_AUDIT_MONTH


def collect(paths):
    files = []
    for p in paths:
        if os.path.isfile(p):
            if lang_of(p) and not skipped(p):
                files.append(p)
            continue
        for root, dirs, names in os.walk(p):
            dirs[:] = sorted(
                d for d in dirs if d not in SKIP_DIRS and not d.startswith(SKIP_PREFIXES) and not old_month(d)
            )
            files += [os.path.join(root, n) for n in sorted(names) if lang_of(n)]
    return files


def check_file(path, only_rules, tier):
    lang = lang_of(path)
    with open(path, encoding="utf-8", errors="replace") as f:
        raw = f.read().replace("\r\n", "\n")
    ctx = Ctx(path, lang, raw)
    found = []
    for rid, (t, langs, _doc, fn) in RULES.items():
        if lang not in langs or (only_rules and rid not in only_rules) or (tier != "all" and t != tier):
            continue
        try:
            for item in fn(ctx):
                ln, msg = item[0], item[1]
                cand = len(item) > 2 and item[2]
                found.append((ln, t, rid, cand, msg))
        except Exception as e:  # 검사기 버그가 전체를 멈추지 않게
            print(f"{path}: 내부 오류 {rid}: {e!r}", file=sys.stderr)
    return sorted(set(found))


CPP_STD_C23 = ("cofo_", "leet_")
GCC_LOC = re.compile(r"^(.+?):(\d+):(?:\d+:)?\s+(error|warning|fatal error):\s+(.*)$")
JAVAC_LOC = re.compile(r"^(.+?):(\d+):\s+(error|warning):\s+(.*)$")
UNUSED_WARN = re.compile(r"\[-Wunused-(variable|function|but-set-variable|local-typedefs|value)\]")
SKIP_WARN_JAVA = re.compile(r"\[(unchecked|rawtypes)\]")


def cpp_std(path):
    parts = path.replace(os.sep, "/").split("/")
    return "c++23" if any(p.startswith(CPP_STD_C23) for p in parts) else "c++20"


def compile_file(path):
    """컴파일·파싱 결과를 check_file 과 같은 형태의 튜플 목록으로 돌려준다."""
    lang = lang_of(path)
    found = []

    def add(ln, kind, msg, line_text):
        if kind in ("error", "fatal error"):
            found.append((ln, "필수", "compile-error", False, msg))
        elif lang == "cpp" and UNUSED_WARN.search(line_text):
            found.append((ln, "필수", "unused", False, msg))
        else:
            found.append((ln, "필수", "compile-warn", True, msg))

    if lang == "py":
        try:
            with open(path, encoding="utf-8", errors="replace") as f:
                ast.parse(f.read())
        except SyntaxError as e:
            found.append((e.lineno or 1, "필수", "compile-error", False, f"SyntaxError: {e.msg}"))
        return found
    try:
        if lang == "cpp":
            cmd = [
                "g++-16",
                f"-std={cpp_std(path)}",
                "-fsyntax-only",
                "-O2",
                "-Wall",
                "-Wextra",
                "-Wno-sign-compare",
                path,
            ]
            res = subprocess.run(cmd, capture_output=True, text=True, timeout=120)
            for line in res.stderr.split("\n"):
                m = GCC_LOC.match(line)
                if m and os.path.abspath(m.group(1)) == os.path.abspath(path):
                    add(int(m.group(2)), m.group(3), m.group(4), line)
        else:
            with tempfile.TemporaryDirectory() as out:
                cmd = [
                    "javac",
                    "-encoding",
                    "UTF-8",
                    "--release",
                    "21",
                    "-Xlint:all,-rawtypes,-unchecked",
                    "-proc:none",
                    "-d",
                    out,
                    path,
                ]
                res = subprocess.run(cmd, capture_output=True, text=True, timeout=120)
            for line in res.stderr.split("\n"):
                m = JAVAC_LOC.match(line)
                if m and not SKIP_WARN_JAVA.search(m.group(4)):
                    add(int(m.group(2)), m.group(3), m.group(4), line)
    except FileNotFoundError as e:
        found.append((1, "필수", "compile-error", False, f"컴파일러 없음: {e.filename} (검사하지 못함)"))
    except subprocess.TimeoutExpired:
        found.append((1, "필수", "compile-error", False, "컴파일 시간 초과(120초)"))
    return found


def main():
    ap = argparse.ArgumentParser(description="PS 컨벤션 기계 검사")
    ap.add_argument("paths", nargs="*", default=["."])
    ap.add_argument("--tier", choices=["필수", "권장", "all"], default="all")
    ap.add_argument("--rule", action="append", help="규칙 ID (여러 번 가능)")
    ap.add_argument("--summary", action="store_true", help="위반 줄은 생략하고 규칙별 건수만")
    ap.add_argument("--list-rules", action="store_true")
    ap.add_argument("--check-docs", action="store_true", help="CONVENTIONS.md 와의 대응 검사, 정독 대상 절 출력")
    ap.add_argument("--compile", action="store_true", help="규칙 검사에 더해 컴파일·파싱")
    ap.add_argument("--compile-only", action="store_true", help="컴파일·파싱만")
    ap.add_argument("-j", type=int, default=os.cpu_count() or 4, help="컴파일 병렬 수")
    a = ap.parse_args()
    if a.list_rules:
        for rid, (t, langs, doc, _fn) in RULES.items():
            print(f"{rid:16} [{t}] {rule_sec(doc) or '-':>5} {','.join(langs):10} {doc}")
        return 0
    if a.check_docs:
        return check_docs()
    from collections import Counter

    missing = [p for p in a.paths if not os.path.exists(p)]
    unknown = [r for r in (a.rule or []) if r not in RULES]
    if missing or unknown:
        if missing:
            print(f"경로 없음: {', '.join(missing)}", file=sys.stderr)
        if unknown:
            print(f"알 수 없는 규칙 ID: {', '.join(unknown)} (--list-rules 참고)", file=sys.stderr)
        return 2

    counts, cand_counts, hard = Counter(), Counter(), 0
    files = collect(a.paths)
    do_compile = a.compile or a.compile_only
    compiled = {}
    if do_compile:
        with ThreadPoolExecutor(max_workers=max(1, a.j)) as ex:
            for p, r in zip(files, ex.map(compile_file, files)):
                compiled[p] = r
    for p in files:
        items = [] if a.compile_only else check_file(p, set(a.rule or []), a.tier)
        if do_compile and a.tier in ("all", "필수"):
            items = sorted(set(items) | set(compiled.get(p, [])))
        for ln, t, rid, cand, msg in items:
            (cand_counts if cand else counts)[(t, rid)] += 1
            if t == "필수" and not cand:
                hard += 1
            if not a.summary:
                print(f"{p}:{ln}: [{t}] {rid}{' (후보)' if cand else ''} {msg}")
    print(f"\n검사 {len(files)}개 파일", file=sys.stderr)
    for (t, rid), c in sorted(counts.items()):
        print(
            f"  [{t}] {rid}: {c}" + (f" (+후보 {cand_counts[(t, rid)]})" if cand_counts[(t, rid)] else ""),
            file=sys.stderr,
        )
    for (t, rid), c in sorted(cand_counts.items()):
        if (t, rid) not in counts:
            print(f"  [{t}] {rid}: 후보 {c}", file=sys.stderr)
    return 1 if hard else 0


if __name__ == "__main__":
    sys.exit(main())
