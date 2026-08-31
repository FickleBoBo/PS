---
name: ps-audit
description: PS 알고리즘 레포에서 날짜별(day_XX) 풀이를 각 언어 PS 고수 기준으로 전수 재점검한다. 파인 콤 — 정답성·복잡도뿐 아니라 네이밍·관용구·표준 라이브러리·문법 표현까지 등급 매겨 나열하고 취사선택은 사용자. "day_32 감사", "31일 풀이 검수", "이번 날짜 재점검" 같은 요청 시 사용.
---

# PS 풀이 감사 (날짜별 전수 재점검)

- **기준 문서**: 레포 루트 `CONVENTIONS.md`가 규칙 정본. 이 스킬은 그 규칙을 빠짐없이 적용하는 **절차**다. 규칙 내용을 여기 복제하지 않는다 — 항상 `CONVENTIONS.md`를 편다.
- **진행 로그**: 메모리 `ps_solution_audit_2026-08` — 어디까지 했나, 세션별 산출, 철회 이력. **시작 전에 읽고, 끝나고 갱신**한다.

## 검사 방식 (대충 금지 — 과거 여러 번 지적받음)

- 목표: **"이 언어로 PS 많이 한 초고수가 썼을 코드인가."** `CONVENTIONS.md` §0.1의 "볼 건 셋뿐" 필터는 이 감사에선 **끄고** 시작 — 파인 콤이 디폴트.
- self-filter 금지 ("너무 사소해서 언급 안 함" X). 지적 가능하면 다 지적하고 등급(🔴/🟡/🟢) 붙여 나열.
- 폴더명 오름차순, 표 요약 말고 **문제별 산문**.
- 취사선택은 사용자. 다음 날로 알아서 넘어가지 말 것.
- 애매하면 백지 리뷰 서브에이전트(Opus)에 `CONVENTIONS.md`만 쥐여주고 콜드 감사 위임 가능(사용자 승인). 콜드 대조로 blind spot이 실측된 전례 있음(배열우선 반사, `std::erase` 반사).

## 절차 — 순서대로

### 1. 컴파일 / 파싱 (🔴 문법 0 확인)

- C++: `g++-16 -std=c++20 -fsyntax-only -O2 -Wall -Wextra` (시스템 clang엔 `bits/stdc++.h` 없음)
- Java: `javac -encoding UTF-8 -Xlint:all` (baseline 21)
- Python: `python3 -c "import ast, sys; ast.parse(open(sys.argv[1]).read())" <파일>`

### 2. 기계 스윕 — 산문 쓰기 **전에** 훑는다

`rg` 또는 `grep -E` (BSD `grep`은 `\|` 교대가 안 먹음). 예: `rg -n '패턴' 2026-08/src/day_32`.
**이 단계가 핵심** — 확정된 규칙을 눈으로만 보고 놓친 재발(day_22·24·25·29)의 방어책. affirmative하게 "준수 ✓"로 인증하지 말고 grep으로 확인.

| 규칙                     | 패턴 (ERE)                                       | 기대                                                                                |
| ------------------------ | ------------------------------------------------ | ----------------------------------------------------------------------------------- |
| 홀짝                     | `% ?2`                                           | Java `!= 0`, C++/Python truthy. `== 1`·`& 1` = 🟡                                   |
| C++ 방어 캐스트          | `\((char\|int\|long\|size_t\|unsigned)\)`        | 값 보존 보장이면 제거 (🟡). Java `(char)` append는 필수                             |
| Python C 전사            | `while .+\* .+<=` · `i ?\+= ?1` · `range\(len\(` | `isqrt`+`for` / `enumerate` (🟡)                                                    |
| Python import            | `^(import\|from) `                               | `CONVENTIONS.md` §5.3 (`math`/`sys`/`heapq` bare, 나머지 from)                      |
| 자리표시자 이름          | `\b(flag\|func\|lst)\b`                          | §3.4·§3.5 (🟡)                                                                      |
| 자릿수 변수              | `% ?10`                                          | `d` 여야 (`r`·`digit` = 🟡)                                                         |
| Python 재귀 깊이         | `setrecursionlimit` + 재귀 함수 존재             | 재귀면 있어야 (없으면 🟡, 깊이 무관)                                                |
| Java 스트림 정렬         | `\.sorted\(\)`                                   | `mapToInt` 뒤여야. 별도 `list.sort` 선행 = 🟡                                       |
| C++ 리덕션               | `accumulate`                                     | 합·곱이면 명시 루프로 (🟡)                                                          |
| 삼항 극성                | `\? -1 :` · `== -1 ?` · `== string::npos`        | 양성 케이스 먼저로 뒤집기 / `!= -1` (🟡~🟢)                                         |
| C++ membership           | `\bset<` · `\.count\(`                           | 순수 membership은 `unordered_set` + `.contains` (🟡)                                |
| 후행 공백 / 파일 끝 개행 | `grep -rn ' $'` · `tail -c1`                     | 없어야 (채점 무관하나 아카이브 청결)                                                |
| Python 격자 방향 순회    | `for n[rxy], ?n[cxy] in \(\(` · `^ *d[xy] ?=`    | `for dr, dc in ((-1,0), ...)` 델타 튜플 (§7.1). 이웃좌표 직접·`dx`/`dy` 리스트 = 🟡 |

패턴은 시작점 — `CONVENTIONS.md` §3~§7에 규칙이 추가되면 스윕 항목도 같이 늘린다.

### 3. 제약 fetch → 복잡도·정수 범위 손계산

`CONVENTIONS.md` §2. **모든 문제의 제약을 실제로 fetch**한다 — "저난도라 자명"으로 건너뛰지 말 것(과거 재발 지점).

### 4. 네이밍 사전 라인별 대조

`CONVENTIONS.md` §3 표·노트와 한 줄씩. 표준에서 벗어난 이름 전부, 아무리 사소해도.

### 5. 언어 표준 라이브러리 훑기

`CONVENTIONS.md` §5. "이 수동 루프에 전용 함수 있나" — `<algorithm>`·`<string>`·`<numeric>` / `java.util` / `itertools`·`math`·`str` 메서드. C++ `<algorithm>`/`<string>` 커버리지가 과거 구멍이었음(`unique`·`append(str, pos, n)` 오버로드 놓침).

### 6. A1/A2/A3 습관

`CONVENTIONS.md` §3.5.

### 7. 지적 전 "번역 티/실수 vs 의도" 판단

`CONVENTIONS.md` §0.3. 지적 적중률이 낮았으니(의식적 선택 오지적 전례 다수) 한 번 더 검토. self-filter 금지 — 애매하면 "이렇게 볼 수도 있는데 의도면 무시" 형태로.

### 8. 산출

등급 🔴/🟡/🟢, 폴더명 오름차순, 문제별 산문. 취사선택은 사용자.

## 끝나고

- 반영된 수정·철회한 지적·이 세션에서 새로 굳은 규칙을 메모리 `ps_solution_audit_2026-08`의 "진행 상황"에 기록 (어긋난 패턴이 재발했으면 "감사가 어긋났던 패턴"에도).
- 새 규칙이면 `CONVENTIONS.md`(정본)도 갱신하고, 필요하면 위 스윕 표에 패턴 추가.
- day_XX가 실제 알고리즘 콘텐츠(그래프·DP·재귀 등)를 담고 있으면 새 패턴 확립 기회 — `CONVENTIONS.md` §7 확장 여지 확인.
