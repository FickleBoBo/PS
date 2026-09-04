# PS 코딩 컨벤션

FickleBoBo의 알고리즘 문제풀이 아카이브(프로그래머스 중심)의 풀이 코드 규칙.

**이 문서 = 규칙의 정본(canonical).** 에이전트·리뷰어가 이 문서 하나로 (1) 각 언어 PS 네이티브 고수 스타일 + (2) 레포 주인의 개인 스타일을 정확히 파악해 일관된 리뷰·작성·변환을 하도록.

- 규칙의 **경위·날짜·철회 이력**은 개인 메모리 `ps_solution_audit_2026-08`(감사 로그·세션 산출). **외부 권위 소스 조사**(KACTL·tourist·jiangly 등)는 `ps_language_style_guide`. 이 문서는 **결론만**.
- **감사(날짜별 전수 재점검) 실행 절차**는 `/ps-audit` 스킬. 이 문서는 절차가 아니라 기준.

---

## 0. 읽는 법

### 0.1 우선순위 — 이 순서로

1. **정답성·문법·복잡도** (§2). 네이밍·관용구를 보기 전에 통과시킨다. 볼 것은 딱 셋: (1) 로직 정답성, (2) 언어 문법 오류, (3) 제약 내 TLE.
2. 그 위에 **"고수 티" 광택** — 네이밍(§3), 문법 표현(§4), 표준 라이브러리(§5), 언어 관용(§6), 알고리즘 형태(§7). 이 레포는 아카이브라 사용자가 요청하면 여기까지 본다.
3. **일반 소프트웨어 클린코드 체크리스트(이름 길이·캡슐화·방어·DRY·SRP)는 적용 안 함.** PS 코드는 일회용.

### 0.2 강도 태그

모든 규칙에 붙는다. 없으면 `[통용]`으로 간주.

- `[합의]` — 확정. 벗어나면 지적(등급은 사안별).
- `[통용]` — 여러 스타일이 다 정상. **단일 답을 지어내지 말고, 불일치 자체를 지적 사유로 삼지 말 것.**
- `[취향]` — 🟢. 사용자가 물을 때만 의견.

리뷰 산출 등급: 🔴 정답성/컴파일 · 🟡 관례상 고칠 만함 · 🟢 취향/사소.

### 0.3 지적 전 판단

- **"번역 티/실수인가, 의도된 선택인가"** 한 번 더. 지적 적중률이 낮았음 — 의식적 선택을 오지적한 전례 다수.
- 단 **self-filter 금지** — "너무 사소해서 언급 안 함" X. 애매하면 "이렇게 볼 수도 있는데 의도면 무시" 형태로 올린다.
- **채점기 동작(뭐가 AC 나나)은 사용자 실제 제출 경험 > 통설.** 확실하지 않으면 단언 X.
- 크로스언어 3풀이는 **로직·구조·변수명이 달라도 정상**(부록 A). 먼저 "각 언어에서 그게 관용인가"를 확인.

---

## 1. 채점기 환경 (프로그래머스, 2026-08)

| 언어   | 버전                            | 리뷰 baseline     |
| ------ | ------------------------------- | ----------------- |
| C++    | Clang++ 20, C++20               | C++20 전부        |
| Java   | 채점기 OpenJDK 25 / 로컬 21 LTS | **21을 하한으로** |
| Python | 3.13                            | 3.13 전부         |

- **C++20 전부 됨**: `std::erase`/`erase_if`, `<ranges>` views, `starts_with`/`ends_with`, `<bit>`(`popcount`), `<numeric>` 확장, 지정 초기화. `bits/stdc++.h`는 g++ 확장이나 프로그래머스 clang에 셋업됨(사용자가 계속 AC). `std::ranges::iota`는 C++23 → C++20은 `iota(v.begin(), v.end(), x)`만.
- **Java는 21에서 컴파일되면 25에서 무조건 돌아감**(역 아님). 21까지 OK: `StringBuilder.isEmpty()`(15)·`repeat(int codePoint, int)`/`repeat(CharSequence, int)`(21)·records·`var`·switch expression·text block·`List.of`·`stream().toList()`. **Java 22~25 전용 문법 금지.** `assert`는 런타임 `-ea` 없음 → 로직에 쓰지 말 것.
- **Python 3.13 전부**: `math.isqrt`/`comb`/`prod`, `itertools.pairwise`/`groupby`, `match`, `str.removeprefix`/`removesuffix`, walrus. `int(초대형_문자열)`은 4300자 초과 시 `ValueError`(3.11+).
- **채점기는 테스트케이스마다 `solution()`을 독립 프로세스로 실행** → 전역 배열을 `solution()` 진입 시 리셋 안 해도 AC. "프로그래머스 전역변수 초기화하세요"는 이 케이스에 안 맞음 — 그걸 근거로 "버그"라 하지 말 것.
- 위치 인자 호출 → 파라미터명 검사 안 됨(개명 기술적으로 가능). 단 지문이 준 파라미터명은 유지(§4).
- 출력의 후행 공백/개행은 trim됨.

로컬 실행(VSCode, g++-16)은 채점기와 별개.

---

## 2. 정답성·복잡도 (기계 체크 — 최우선)

### 2.1 복잡도 (TLE)

1. 제약 fetch — `n`, `m`, 원소 범위, 쿼리 수, 문자열 길이 상한을 **실제로 읽는다**. 넘겨짚지 말 것.
2. 최악 시간복잡도 손계산 — 중첩 루프 상한 곱, 재귀 분기·깊이, 반복 문자열/배열 복사(`Arrays.copyOfRange`를 쿼리마다 = O(쿼리·n)).
3. 프로그래머스 ~1e8 연산/초. `n ≤ 1e5`에 O(n²) 위험, O(n log n) 안전.

### 2.2 정수 오버플로

- 결과값·중간 누적값의 상한을 제약에서 계산 → int `2.1e9` / long `9.2e18` 대조. 넘으면 🔴.
- **C++/Java**: `int` 곱/합이 2³¹ 넘으면 `long long`/`long`. 곱 전에 `1LL * a * b` / `(long) a * b` 승격. `int` 배열 합도 원소 많으면 승격.
- **Python**: 정수 무제한 — 단 `int(문자열)` 4300자 초과 `ValueError`.
- 함정: 누적합, 곱/팩토리얼/조합, 문자열 concat 후 파싱, 좌표 제곱 거리, 전체 원소 합.

### 2.3 정답성

- **제약 의존 지름길(지적 X)** vs **약한 테스트로 우연히 AC 난 진짜 오답(지적 O)** 구분.
- 엣지: 빈 입력, 원소 1개, 전부 같은 값, 음수, 최대치, 경계 인덱스(`0`, `n-1`).
- 센티넬·초기값이 제약 범위를 확실히 벗어나는지 (`diff = 100`이 `|x - n|`의 실제 상한보다 큰지).
- 튜플/구조분해가 "항상 그 개수"인지 제약으로 보장되는지 (`(a, b), (c, d) = intervals`).

---

## 3. 네이밍 ⭐

> 사용자는 변수명 일관성에 **극도로** 민감. `prv nxt cnt ans res` 축약형만 보고 즉시 꽂히길 원함. 자릿수는 `d` 한 글자. **표준에서 벗어난 이름은 아무리 사소해도 지적.**

### 3.1 표준 이름 `[합의]`

| 역할                                          | 이름                                           |
| --------------------------------------------- | ---------------------------------------------- |
| 크기·개수                                     | `n` `m` `k` `t`(테스트 수)                     |
| 개수 세기 (스칼라·카운팅 배열·카운팅 맵 전부) | `cnt`                                          |
| 길이                                          | `len`                                          |
| 루프 인덱스                                   | `i` `j` `k`                                    |
| 임의 인덱스/포인터                            | `idx`(기본) · `pos`                            |
| 최종 답                                       | `ans`                                          |
| 만들어 나가는 결과·누적                       | `res`                                          |
| 수치 합계 (누적 스칼라)                       | C++·Java `sum` / Python `total`                |
| dedup / membership 집합                       | `seen` (세 언어 공통)                          |
| 그래프 방문 체크                              | `vis` (또는 `visited`)                         |
| 출력 버퍼                                     | `out`                                          |
| 이전 / 다음 / 현재                            | `prv` / `nxt` / `cur`                          |
| 롤링 DP                                       | `prv2` / `prv1` / `cur`                        |
| 구간 양끝                                     | `l` / `r` (반개구간 `[l, r)`)                  |
| 이분탐색                                      | `lo` / `hi` / `mid`                            |
| 시작 / 끝 (지문 어휘면)                       | `s` / `e`                                      |
| 최소 / 최대 값                                | C++ `mn` / `mx` · Java `min` / `max`           |
| 자릿수                                        | `d`                                            |
| 정점                                          | `u` `v`                                        |
| 인접 리스트 / 그래프                          | `adj` `g`                                      |
| 간선 / 가중치 / 차수                          | `e` / `w` / `deg` (진입차수 `indeg`)           |
| 거리 배열                                     | `dist` (짧게 `d`)                              |
| 부모 (union-find)                             | `p` (또는 `par`)                               |
| BFS 큐                                        | `q`                                            |
| 그리드 방향 델타                              | `dx` / `dy` (또는 `dr` / `dc`)                 |
| 그리드 다음 좌표                              | `nx` / `ny` (또는 `nr` / `nc`)                 |
| 행 / 열                                       | `r` / `c`                                      |
| DP 테이블 / 메모                              | `dp` / `memo`                                  |
| 장애물 격자 (bool)                            | `wall` (도메인명 우선, 단순 차단은 `chk` — n7) |
| 잡 bool 마커 (더 나은 단어 없을 때)           | `chk`                                          |
| 범용 해시맵                                   | Java `map` / C++ `mp`                          |
| 무한대 / 모듈러 / 배열 상한                   | `INF` / `MOD` / `MAX`·`MAXN`                   |
| 좌표 페어 스크래치                            | `x` / `y` (혼동 없을 때만)                     |
| 분수                                          | `p` / `q`                                      |
| gcd 결과                                      | `g`                                            |
| 지문이 "ret 반환"이라 하면                    | `ret` (지문 어휘 매칭)                         |

### 3.2 표 노트

1. **`cnt`** — 배열/맵/스칼라 구분은 선언부에서 보이니 이름으로 안 함. 도메인 이름 있으면 우선(`indeg` 등). 한 풀이에 스칼라+테이블 둘 다면 하나를 `freq`. **카운팅인데 `mp`/`map` 금지.** Python은 손수 안 세고 `Counter`→`cnt`, `Counter(a)-Counter(b)`면 `diff`.
2. **`ans` vs `res`** — `ans` = 반환/출력할 그 값(스칼라, 또는 유도 과정이 있어 결과임을 드러낼 컨테이너/문자열). `res` = 채워지는 컨테이너/누적자. 단순히 조건 맞는 원소 모아 바로 반환하면 언어별 컨테이너명(§3.3)도 OK — `res`/`ans`/`v` 케바케, 크로스파일 불일치 지적 X.
3. **`sum` / `total`** — Python `sum`은 빌트인 섀도잉 → `total`(또는 `acc`). `sum(...)` 제너레이터로 누산기 자체 제거가 1순위.
4. **`seen`** — "이미 본 원소인가". 타입 기반 이름(§3.3)에 C++·Python이 마찰해서 세 언어 다 `seen`. Java `set`(타입 `Set`)은 제네릭 폴백 허용, C++ `st`는 스택, Python `set`은 섀도잉이라 못 씀. 그래프 방문은 `vis`, 미리 만든 상수 집합은 도메인명.
5. **`mn` / `mx` vs `min` / `max`** — C++는 `using namespace std`로 `std::min`/`max` 섀도잉 → 축약. Java는 `Math.max`가 정규화돼 충돌 없음 → 풀네임. `st`/`stack`·`mp`/`map`과 같은 부록 A 케이스. ↔ 금지: "언어 간 맞춰라".
6. **`d`** — 자릿수. 한 글자 그대로. ↔ 금지: `r`·`digit`로 바꾸기. gcd 결과는 `d` 아님 → `g`(§3.1, `d`=자릿수와 충돌).
7. **`chk`** — 데이터(bool 배열) 이름으로만. 헬퍼 함수명은 `check`(§3.4). 그래프 방문이면 `vis`. 장애물 격자는 도메인이 뚜렷하면 도메인명/`wall`, 단순 차단 체크 격자는 `chk` 허용.
8. **`idx` > `pos`** — 찾은 위치 변수 기본은 `idx`.
9. **`INF`** — Java `0x3f3f3f3f`(더해도 안 넘침), C++ `long long`엔 `1e18`, Python `10**18`. `float('inf')`/`Float.MAX` 지양. **`MOD`** = `1'000'000'007`.

### 3.3 언어별 컨테이너 이름

- **C++**: `v`(벡터), `st`(스택 — `stk` 아님), `pq`(우선순위 큐), `ss`(stringstream), `dq`(deque), `mp`(범용 맵 — `map`은 `std::map` 회피), `s`(만들어 나가는 결과 문자열, 기본값), `seen`.
  - `string s` vs `string ans`: 기본 `s`. 유도 과정이 길거나 헷갈리면(맵 디코드 등) `ans`도 허용 — 케바케, 크로스파일 갈려도 지적 X.
- **Java**: 타입 기반 — `arr`(배열), `list`(리스트), `stack`(소문자라 `java.util.Stack`과 안 겹침), `dq`/`deque`(ArrayDeque), `sb`(StringBuilder), `pq`, `map`(범용 맵, 풀네임).
- **Python**: 타입 기반 안 통함(전부 list) → **역할 이름** `res`/`ans`/`out`, 스택 `stack`, 집합 `seen`. 문자열→가변 문자 리스트는 `chars` 또는 `s = list(my_string)` 재사용.
- **스택 = C++ `st` / Java·Python `stack`.** 단 지문이 이름 주면 그대로(지문이 `stk`면 세 언어 다 `stk`).

### 3.4 헬퍼 함수 `[합의]`

- 불리언 술어: `ok` / `check` / `valid`
- 재귀·부분문제 풀이: `solve`
- 그래프/DSU: `bfs` / `dfs` / `find` / `union`(C++은 키워드 → `unite`) (§7)
- 원소별 변환: `transform`(Python) / `step`(Java·C++) (§7)
- **`func` 금지** (재발 습관). `flag` 금지 (→ 의미 있는 이름).
- 비교자 람다 파라미터 — Java `(o1, o2)` 고정(`Comparator.compare` 시그니처 매칭). C++ `a, b` (값 비교·인덱스 정렬 공통). Python은 2-인자 비교 람다 거의 안 씀(`key=lambda x:` 단일).

### 3.5 네이밍 안티패턴 (지적 대상)

- 서술형 긴 이름: `numberOfVertices`, `adjacencyList` — "번역 티" 1순위.
- `lst`(잘라 쓴 티), Python `list`(섀도잉), Python 억지 camelCase.
- 모든 변수를 `long`/`long long` 선언 (C++ `#define int long long` 습관의 번역 티).
- Java에서 0..N 인덱스 매핑에 `HashMap` (Python dict 습관).
- 카운팅 전용 맵인데 `mp`/`map` (→ `cnt`).
- Python 모듈 레벨 헬퍼 + 전 상태를 재귀 파라미터로 스레딩 ("Java 하다 왔네", §6.3).
- **C++ `std::` 충돌 이름을 비일관 회피**: `mx`로 `std::max`는 피하면서 `end`/`next`/`count`/`distance`는 파라미터로 그냥 씀. 경계는 `l`/`r`·`lo`/`hi`로 통일.

**리뷰 시 특히 볼 습관 (A-리스트)**:

- **A1** — 관례 이름(분수 `p`/`q`, 자릿수 `d`, gcd 결과 `g`)이 있는데 버리고 `x`/`y`/`r` 스크래치로. _좌표 혼동 없는 순수 스크래치 2개는 OK_; 관례 이름을 버릴 때만 지적.
- **A2** — 자리표시자 이름(`flag`, `func`, borderline `chk`).
- **A3** — 위 C++ `std::` 충돌 비일관 회피.

---

## 4. 문법·표현 `[확정 — 이대로면 지적 X]`

- **홀짝** `[합의]` — `% 2`. C++/Python truthy (`if (n % 2)`, `if n % 2:`), **Java만 `n % 2 != 0`** (NOT `== 1`, NOT `& 1`). `& 1`은 저난도에 도입 안 함.
  - **truthy/falsy 일반 원칙** `[합의]` — C++/Python 은 값이 참거짓 의미를 직접 담을 때(엣지 존재, 남은 자릿수 등) truthy 를 **적극 활용**, Java 는 항상 명시. 명시가 의도를 더 드러내면 그때그때 명시 — 한 파일 안에서 갈려도 지적 X(개별 판단).
  - **음성 가드는 명시 비교 유지** — 배열/맵 값을 스킵 조건으로 쓸 때 `== 0` / `!= 0`, 옆 조건과 대칭으로: `if (maps[nr][nc] == 0 || dist[nr][nc] != 0) continue;` (NOT `|| !dist[nr][nc]`). 카운트다운 루프 조건 `while (x > 0)` / `while (x)` 은 C++/Python 재량.
- **삼항 극성** `[합의]` — 찾음/성공/양성 케이스를 **먼저**: `idx != -1 ? idx + 1 : -1` (NOT `idx == -1 ? -1 : idx + 1`). 세 언어 공통.
- **불리언 결과를 0/1 로 반환** `[통용]` — "조건이면 1, 아니면 0/-1" 류: C++ `return cond;` (묵시적 bool→int) · Java `return cond ? 1 : 0;` · Python `return int(cond)`. 언어별로 갈리는 게 정상(부록 A).
- **중괄호** `[합의]` —
  - `if` + `continue`/`return`/`break` 단독(guard) = 항상 한 줄, 중괄호 X.
  - Java 반복문 = 항상 중괄호.
  - C++ 반복문 = 재량("진짜 짧으면" 생략). 소프트 — 한 파일 안에서 대놓고 엇갈리거나 긴 body를 중괄호 없이 둘 때만 지적.
- **가드 클로즈 vs 대칭 분할 if/else** `[합의]` — 엣지 먼저 걸러 빠져나오면 guard. 분기가 대등한 N-way 분류(홀/짝, 2×2, "전부같음/둘같음/다다름", 각도 임계값)는 `if/else if/else` 대칭 구조도, 각 분기가 `return`이면 early-return 래더도 둘 다 정당 — **어느 쪽도 강제하지 않는다.** **"return 뒤 redundant else" 지적 X.** (Python도 대칭 분기에 `else:` 유지 정당 — §7.5.)
- **`const` / `final`** `[합의]` — 전역 상수에만 (C++ `const int`/`constexpr int`, Java `static final int`). 로컬 X, `for (const auto&)` X.
  - 읽기 전용 전역 룩업 테이블 배열(`string words[10]`)은 **non-const 소문자 유지 OK** — `const` 붙이면 대문자 네이밍이 따라와 과함. ↔ 금지: `const` 강제.
- **`auto` (C++)** `[합의]` — 산술 타입(특히 `long long` — 오버플로 가시성)·단순 컨테이너는 명시. 이터레이터·구조분해·pair/tuple 반환·맵 lookup은 `auto`.
- **방어 캐스트 생략 (C++)** `[합의]` — 묵시적 변환이 값을 안 바꾸는 게 제약상 보장되면 캐스트 X: `for (int i = 0; i < v.size(); i++)`, `int n = v.size();`, `ans += i + 'a'`(`char` 범위).
  - 예외(지적 O): 값이 뒤집히거나 넘치면 지름길이 아니라 오답 — 빈 컨테이너 `v.size() - 1`(unsigned 언더플로), 음수 `int` × `unsigned`, `int` 곱/합 오버플로(→ §2.2).
  - ↔ 금지: `(int)v.size()`/`static_cast` 강요. 제약상 불가능한 케이스에 방어 코드. (`(int)` 캐스트한 값을 다시 `size_t` 파라미터에 넘겨 언더플로 재발한 전례 — 캐스트가 오히려 화근.)
  - Java 대응: `sb.append((char)(i + 'a'))`의 `(char)`는 **필수** — `append(int)` vs `append(char)` 오버로드 갈림. (→ 부록 A)
- **올림 나눗셈** `[합의]` — 상수 제수는 접어서 (`(n + 6) / 7`), 변수 제수는 일반형 (`(n + k - 1) / k`). 불일치 아님.
- **같은 우선순위 연쇄** (`hp % 5 / 3`) `[합의]` — `%`/`/` 동일 우선순위 좌결합. 괄호를 **일부만** 치면 비대칭 지적 — 전부 치거나 전부 빼거나 택1.
- **폐형식은 끝까지 정리** `[합의]` — `SolutionN` 폐형식 파일이면 공식 대입 중간단계로 두지 말 것 (`(2 + n/2*2)*(n/2)/2` → `m = n/2; m*(m+1)`).
- **`1 + n` 사이징 표기** `[취향]` — "n은 제약, +1은 1-인덱싱" 의도. 유지.
- **지문 / 템플릿 어휘 유지** `[합의]` — 프로그래머스가 준 파라미터명은 `std` 충돌·빌트인 섀도잉이 있어도 안 바꿈 (`slice`, `flag`, "ret 반환").
- **`solution` 시그니처는 fetch된 템플릿 그대로** `[통용]` — 구형(12xxx대)은 `public` 없이, 신형(120xxx·181xxx대)은 `public` 붙어 내려옴. 파일마다 갈려도 지적 X.
- **`.find()` 결과 비교 (C++)** `[합의]` — `!= -1` 이 기본. 사용자 상용 트릭이고 KR PS 관용. `string::npos == (string::size_type)-1` 이라 정확. ↔ 금지: `!= string::npos` 로 바꾸라고 강요.
  - `str.find(x) != -1` 을 **반환값에 직접** 비교하면 `-Wsign-compare` (unsigned `size_type` vs `int`) — 동작은 정확, 경고만. 감사 컴파일 단계(`-Wextra`)에서 뜨는 이 경고는 **결함으로 취급 X**.
  - 스윕/컴파일 경고를 0으로 두고 싶으면 `int pos = str.find(x); pos != -1` 로 받는다 (이것도 KR PS 관용, 경고 없음). 직접 비교 vs `int pos` 수령은 취향 — 둘 다 지적 X.

---

## 5. 표준 라이브러리 활용

축: **"수동 루프 vs 라이브러리 함수".** 알고리즘 빌딩블록을 손으로 재구현하지 말 것. (자료구조 선택은 §6, 완성 패턴은 §7.)

### 5.1 C++ `[합의]`

- **변환·탐색·생성 알고리즘은 stdlib** — "C++11식 수동 말고 그레이더 C++20 도구":
  - `iota(v.begin(), v.end(), 0)` — 0,1,2… 채우기 (`<numeric>`)
  - `v.erase(unique(v.begin(), v.end()), v.end())` — 연속 중복 제거
  - `std::erase(cont, val)` / `std::erase_if` — 값 제거 (C++20)
  - `s.starts_with(p)` / `s.ends_with(p)` (C++20)
  - `s.append(other, pos, n)` 오버로드 — 임시 substring 회피
  - `std::gcd` / `std::lcm` (`<numeric>`)
  - `set`/`unordered_set`/`map` membership은 `.contains(x)` (C++20) — `.count(x)`를 `if`에 흘리는 것보다 의도 직결. `.count`는 multiset 개수용.
- **이미 라이브러리 함수면 그대로** — `*max_element`, `sort` 등을 `std::ranges::` 버전으로 바꾸라고 하지 말 것. `*max_element(v.begin(), v.end())`는 영구 표준. 기존 `.count` membership도 🟢 현대화지 결함 아님.
- **예외: 리덕션(합·곱)은 `std::accumulate` 안 씀** — 명시적 `for` 루프. 레포 전체에 `accumulate` 0회. `int sum = 0; for (int x : v) sum += x;` / `int mul = 1; for (...) mul *= x;`. (`*max_element`는 argmax=탐색이라 OK, `accumulate`만 뺀다.) ↔ 금지: `accumulate` 제안. Python은 반대(§5.3).
- **`erase_if`로 필터 루프 대체는 강요 X** — 가독성 나빠지면 필터 루프 유지.
- 안티패턴: 직접 짠 gcd/popcount, `pow(2, k)`.

### 5.2 Java `[합의]`

- **토큰화는 보통 `StringTokenizer`** — stdin이 아니어도. `"3 + 5 - 1"` 파싱 기본은 `new StringTokenizer(s)` + `nextToken()`. 단 고정 포맷을 `split(" ")` 후 곧장 순회/위치 접근하는 게 확연히 깔끔하면 `split` 도 쓴다 — `arr[i-1]` 되돌아보며 **재파싱**하는 패턴만 피한다(직전 값을 `prv` 로).
- **스트림은 IO 경계에서만** — 입력 파싱, 최종 리덕션/변환. `IntStream.rangeClosed`류 생성 스트림도 "로직성"으로 보고 수동 루프 선호.
- `List<Integer>` → 즉시 `.stream().mapToInt(Integer::intValue).toArray()`. 정렬이 끼면 `.mapToInt(...).sorted().toArray()` — **`.sorted()`는 `mapToInt` 뒤**(primitive 정렬). 별도 `list.sort(...)` 선행 금지.
- 리덕션도 C++처럼 명시 루프 (스트림 `.sum()`은 IO 경계 변환일 때만).
- gcd는 직접 구현 (표준 `Math.gcd` 없음) — 재귀 2줄 가드형 (§7.3).

### 5.3 Python `[합의]`

**대전제: CP-pythonic = 성능.** 내장함수가 C레벨이라 빠름. 프로그래머스는 시간 널널 → 가독성 우선.

- **적극 활용**: `Counter`/`deque`/`defaultdict`, `heapq`(튜플 정렬키 `(dist, node)`), `bisect`, `itertools`(`accumulate`/`combinations`/`permutations`/`product`/`pairwise`/`groupby`), `math`(`isqrt`/`comb`/`prod`/`gcd`), 슬라이싱(`s[::-1]`, `s[a:b]`), `string.ascii_*`.
- **리덕션도 적극** — `sum()` / `math.prod()` / `accumulate` + `next()`. (C++/Java와 반대, 부록 A.)
- **인덱스 순회 안 함** — `for i in range(len(arr))` 지양. `enumerate`/`zip`/`reversed`/직접 순회. 슬라이스에 쓸 인덱스가 진짜 필요할 때만 `range(len)`. **파이썬 고수 단일 최강 지표.**
- **C 전사 안 함**:
  - `while i*i <= n` + `i += 1` → `math.isqrt` + `for i in range(1, isqrt(n) + 1)` (`int(n**0.5)`는 float 오차)
  - if/elif 문자 치환 루프 → `str.translate(str.maketrans(a, b))`
  - `% 10` + reverse로 자릿수 → `str(x)` 순회
  - 수동 카운팅 → `Counter`, 딕셔너리 키 3단 체크 → `defaultdict`, 수동 swap → `a, b = b, a`
  - **경계**: 위는 "수학적 양(√·자릿수·빈도)을 관용구로". **"연산 X를 몇 번 적용했나"의 카운트를 닫힌 형/비트트릭으로 대체는 안 함** — 서술된 연산은 루프로 시뮬레이션. "2로 나눠 1 될 때까지 횟수"는 `x.bit_length() - 1`이 아니라 `while x > 1: x //= 2; cnt += 1`. (루프 *안*의 미시 단순화 — 짝/홀 두 규칙이 `//= 2` 하나로 — 는 OK. 루프 자체를 없애는 게 선.)
- **import 스타일**: 하드 룰 둘 — `from collections import deque`(절대 `import collections` X), `import sys`(절대 `from sys import` X). 그 사이:
  - **bare `import`**: `sys`·`math`·`heapq` — 호출이 구별되거나(`sys.setrecursionlimit`, `heapq.heappush`) 모듈명이 문서 역할(`math.isqrt`)
  - **`from ... import`**: `collections`·`itertools`·`functools`·`bisect` — 이름을 맨으로 반복, 접두사가 노이즈
  - `import math` + `math.isqrt`는 정합 — from으로 바꾸라 지적 X.
- `.split()` (무인자 = 공백 collapse + strip) vs `.split(" ")` (리터럴, 빈 토큰). 의도에 맞게.
- `sum(x > k for x in a)` (bool = int), `-heapq.heappop(h)` (최대 힙), `2D`는 `[[0] * m for _ in range(n)]` (`[[0] * m] * n` 함정).
- 제자리 `.reverse()`/`.sort()` 후 반환 OK.
- walrus `:=` (컴프리헨션 필터값 재사용)는 PS 관용이지만 **소프트** — 안 와닿으면 평범한 루프.
- 타입힌트·docstring·`@functools.cache`(핸드메모보다 느림) = CP에선 군더더기.
- **지양** `[합의]`: 3중+ 중첩 컴프리헨션, `reduce` 체이닝으로 로직 전체, walrus+컴프리헨션+unpacking 한 줄, `from collections import *`.

### 5.4 연산별 3언어 대조 (참고 — §5.1~5.3·§3에서 파생, 정본 아님)

| 연산               | C++                                     | Java                                             | Python                                    |
| ------------------ | --------------------------------------- | ------------------------------------------------ | ----------------------------------------- |
| 뒤집기             | `std::reverse`                          | 수동 swap 루프                                   | `[::-1]`                                  |
| 합 / 곱 리덕션     | 명시 `for` 루프 (`accumulate` X)        | 명시 `for` 루프                                  | `sum()` / `math.prod()` / `accumulate`    |
| "첫 초과 누적합"   | 명시 조기반환 루프                      | 명시 조기반환 루프                               | `next(s for s in accumulate(a) if s > k)` |
| gcd                | `std::gcd`                              | 손수 재귀 2줄                                    | `math.gcd`                                |
| 자릿수 순회        | `% 10` 루프                             | `% 10` 루프                                      | `str(x)`                                  |
| 조합 `C(n, k)`     | 곱셈식                                  | 곱셈식                                           | `math.comb`                               |
| `char` 산술 캐스트 | 생략 (`s += i + 'a'`)                   | `(char)` 필수 (`append` 오버로드)                | N/A                                       |
| dedup 집합         | `seen`                                  | `seen`                                           | `seen`                                    |
| union-find `find`  | 재귀 2줄                                | 재귀 2줄                                         | 반복 절반압축                             |
| 재귀 헬퍼 위치     | 자유 함수(전역 참조)                    | `static` 메서드(파라미터)                        | 중첩 클로저(캡처)                         |
| 누적합 / 차분 복원 | 명시 `for` 루프                         | 명시 `for` 루프                                  | `itertools.accumulate`                    |
| 부분배열 추출      | `vector<int>(v.begin()+l, v.begin()+r)` | `Arrays.copyOfRange(a, l, r)` (List면 `subList`) | `a[l:r]`                                  |
| 불리언 → 0/1 반환  | `return cond;`                          | `return cond ? 1 : 0;`                           | `return int(cond)`                        |

---

## 6. 언어별 자료구조·관용

"어떤 컨테이너·구조를 쓰나" + 언어 고유 관용. (이름은 §3, stdlib 함수는 §5.)

### 6.1 C++

- `#include <bits/stdc++.h>` + `using namespace std;`
- 표준입출력 문제면 `ios::sync_with_stdio(0); cin.tie(0);` + 출력 `'\n'` (**`endl` 금지** — 인터랙티브 제외, 10배 저하). `0` 은 사용자 고정 컨벤션 — `false`/`nullptr` 과 동작 동일, 타이핑 절약. ↔ 금지: `false`/`nullptr` 로 바꾸기.
- **Codeforces 멀티테스트** `[합의]` — 로직을 `void solve()` 로 분리, `int main()` 은 `ios::sync_with_stdio(0); cin.tie(0); int t; cin >> t; while (t--) solve();`. 폴더명 `cofo_{contest}{x}` (문제 letter 소문자). 프로그래머스는 `solution()` 직접 호출이라 해당 없음.
- **전역 고정 배열 OK** (`bool vis[MAX]`, `int p[MAX]`), 매직넘버 상한(`vis[200]`, n ≤ 200)도 CP 표준. `main` 안 지역 `vector`도 fluent (멀티테스트 초기화 버그 회피) — **둘 다 OK** `[통용]`.
- **순수 membership 집합은 `unordered_set`** (`set` 아님) `[합의]` — 프로그래머스는 해시 해킹 없음. 정렬을 실제로 쓰면 `set`. `set<char>`처럼 알파벳 유계면 어느 쪽이든 무의미하나 기본은 `unordered_set`. `unordered_map`도 동일(CF는 지양, 프로그래머스 허용).
- `emplace_back` (> `push_back(make_pair(...))`), digit separator (`1'000'001`).
- `vector<bool>` 봤다고 초보 판정 금지 (tourist/neal도 씀). `std::` 접두사도 elite 마커.
- 안티패턴: `while (!cin.eof())`, `system("pause")`, `endl`, `#define int long long`, `signed main()`.

### 6.2 Java

- 프로그래머스 포맷 `class Solution` 고정. 헬퍼는 `static` 메서드. **전역 배열 안 씀** — `static` 필드 또는 파라미터 전달.
- 표준입출력 문제면 `public static void main(...) throws IOException` (**try-catch로 감싸면 초보 티**), 입력 `BufferedReader` + `StringTokenizer`, 출력 `StringBuilder` 모아서 `System.out.print(sb)`. **`Scanner` 금지** (14배 느림).
- **배열 우선 / 오토박싱 회피가 핵심 유창성 마커** `[합의]`:
  - `Arrays.copyOf`(리사이즈 복사) / `System.arraycopy`(목적지·시프트 제어)
  - `Map<Integer, Integer>` 카운팅 → `int[]`
  - 결과를 루프로 채울 때: 길이가 사전에 정확히 계산되더라도 `list.stream().mapToInt(Integer::intValue).toArray()` 가 깔끔하면 그대로 둔다. `int[]` 선할당은 성능 차이가 실측으로 체감될 때(프로그래머스에선 드묾)나 오버할당 + `Arrays.copyOf(res, idx)` 가 자연스러울 때. 케바케 — 지적 X.
- 스택·큐는 `ArrayDeque`(`Deque` 인터페이스)로 일원화. `Stack<Integer>` / `Queue q = new LinkedList<>()`는 "학교에서 배운 대로" 마커. `int[]` + `idx` 포인터 스택은 지문이 배열을 요구하거나("배열 `stk` 를 만든다") 박싱이 성능에 실측으로 걸릴 때만 — 프로그래머스는 대개 `ArrayDeque`.
- **Map 값이 단일 문자면 `Map<String, String>`** (1글자 문자열) `[합의]` — `Map<String, Character>`는 `sb.append(map.get(k))`가 `append(Object)`로 바인딩돼 박싱+`toString`. `String` 값이면 `append(String)` 직결, Python `dict` 구조와도 일치.
- `Arrays.fill(dp, -1)`.
- **`StringBuilder`에 단일문자 리터럴 String append** (`sb.append("\n")`, `append(" ")`, `append("5")`) = 굳은 습관, **지적 X** (리터럴은 할당 없음). 단 `String.valueOf(c).repeat(n)`·`sb.append("a" + x)`는 별개로 지적. i글자 반복은 `sb.repeat("*", i)` (JDK 21+).
- 안티패턴: `String +=` 누적(O(n²)), 루프 안 `System.out.println`(30배), `List<Integer>`로 인덱스 접근, 데이터 클래스에 getter/`toString`.

### 6.3 Python

- 프로그래머스/LeetCode의 **`solution()` 함수형** 문제는 `input = sys.stdin.readline` 같은 IO 셋업이 **아예 없음** (있으면 백준 템플릿 무지성 복붙 티). **예외** — 프로그래머스 "입출력" 트레이닝처럼 `main`/stdin 으로 직접 읽는 유형은 Python 도 **항상** `import sys` + `input = sys.stdin.readline` (Java `BufferedReader`, C++ `cin.tie` 와 평행, §8).
- **헬퍼(DFS·BFS·find)는 `solution` 안 중첩 클로저**로, 입력(`numbers`, `graph`, `n`)을 **캡처**한다 — 매 재귀 호출에 파라미터로 스레딩하지 말 것. 재귀 인자는 실제로 변하는 것만(`cur`, `depth`). 모듈 레벨 `def`는 입력에 안 걸리는 순수 유틸(`gcd`류)만 예외. **`global` 재대입으로 Java `static` 필드 흉내내지 말 것.**
- **재귀 풀이 = `import sys` + `sys.setrecursionlimit(10**6)`를 보일러플레이트로 넣는다** `[합의]`— 위치 자유, 값`10**6` 고정. **재귀 깊이가 기본 1000 미만이어도 지적하지 말 것\*\* — 런타임 환경 세팅이지 §4 "제약상 불가능 케이스 방어 코드"가 아니다(그 규칙은 로직 레벨 과방어 — bounds 체크·불가능 null 가드·`(int)` 캐스트 — 에만).
- `for i in range(len(x))` 안 씀 → §5.3.

---

## 7. 알고리즘 형태 (언어 공통)

### 7.1 BFS / DFS 순회

- `vis` 방문 배열, `cur` 현재 정점, `nxt` 후보 정점, `cnt` 컴포넌트 수.
- guard `continue`로 스킵: `if (computers[cur][nxt] == 0 || vis[nxt]) continue;`
- 방문 배열 위치 — **C++** 전역 `bool vis[MAXN]` / **Java** `boolean[] vis` 파라미터 or `static` 필드 / **Python** `vis = [False] * n`을 `solution` 안에서 클로저 캡처.
- **C++ 그래프 헬퍼 입력** — `vis` 뿐 아니라 인접구조·`n` 도 파일 스코프 전역으로 두는 걸 선호(헬퍼 시그니처는 변하는 인자만: `bfs(int cur)`). 애매하면 ref 파라미터로 넘겨도 됨. **LeetCode 는 전역 배열 지양**(멀티 인스턴스), 프로그래머스/CF 는 프로세스 독립이라 무해.
- 큐 — **C++** `queue<int>` (`front`/`pop`) / **Java** `ArrayDeque` (`offer`/`poll`) / **Python** `deque` (`append`/`popleft`).
- BFS 레벨 순회 — **C++** `int sz = q.size(); while (sz--) { ... }` · **Java** `int sz = q.size(); while (sz-- > 0) { ... }` · **Python** `for _ in range(len(q)):`. (C++ `sz` 는 `int` 라 `while (sz--)` 안전 — §4 truthy.)
- **enqueue 후 mark 순서** `[합의]` — `q.push(nxt); vis[nxt] = true;` (또는 `dist[nxt] = dist[cur] + 1;`). mark 먼저 아님. 세 언어·모든 BFS 파일 공통.
- **격자(2D) BFS** `[합의]` — 거리 배열은 **C++** 전역 `int dist[MAXN][MAXN]` (`MAXN` = 제약 상한 정확값, 지역 `vector<vector<int>>` 아님) / **Java** `int[][] dist = new int[n][m]` 지역 / **Python** `dist = [[0] * m for _ in range(n)]` 지역. 방향 순회 — **C++/Java** `dr`/`dc` 크기 명시 배열(C++는 전역) + `for (int d = 0; d < 4; d++)` / **Python** `for dr, dc in ((-1, 0), (0, 1), (1, 0), (0, -1)):` 델타 튜플 순회 후 `nr, nc = r + dr, c + dc` — 이웃 좌표 직접 튜플(`for nr, nc in ((r - 1, c), ...)`)이나 `dx`/`dy` 리스트 + `range(4)`(C 전사, §5.3) 아님. 시작칸 `dist = 1`로 두고 "칸 수" 세면 미방문 = `dist[..] == 0`. 큐 enqueue는 `q.push({r, c})` (`emplace` 아님) `[취향]`.
- Dijkstra는 lazy deletion (`if (d > dist[u]) continue;`) — 없으면 decrease-key 잘못 흉내낸 초보 신호.

### 7.2 union-find (DSU) `[합의]`

- 부모 배열 `p` — 세 언어 공통.
- `find` = **재귀 2줄 가드형**: `if (x == p[x]) return x; return p[x] = find(p[x]);`
- `union` / `unite` = **`bool` 반환을 템플릿 기본값으로** — void의 순수 상위호환(사이클 감지·Kruskal 간선 선택 공짜, KACTL `join`도 bool). 호출부에서 안 써도 유지. ↔ 금지: "미사용이니 void로".
- 컴포넌트 수 = `find(i) == i` (또는 union 후엔 `i == p[i]`) 순회.
- **Java**: `static int[] p` 필드 + `static` 헬퍼.
- **C++**: 자유 함수 + **전역 raw 배열** `int p[MAXN]` (전역 `vector` X) + `iota(p, p + n, 0)` 초기화. `union`은 키워드라 `unite`.
- **Python**: 중첩 클로저 + **반복 절반압축** `while x != p[x]: p[x] = p[p[x]]; x = p[x]` (재귀 아님 → `setrecursionlimit` 불필요). `p = list(range(n))`, `sum(find(i) == i for i in range(n))`.
- union by rank/size는 N ≤ 수천이면 안 넣음.
- 프로그래머스는 프로세스 독립이라(§1) 전역 `p` 멀티테스트 초기화 버그 없음.

### 7.3 hand-rolled 재귀 헬퍼 (gcd, find 등) `[합의]`

- 2줄 가드형 고정: `static int gcd(int a, int b) { if (b == 0) return a; return gcd(b, a % b); }`. 삼항 한 줄형도 통용이나 이 레포는 2줄형(§4 가드 클로즈).
- C++는 `std::gcd`, Python은 `math.gcd` (§5.4). 직접 구현은 Java만.

### 7.4 재귀 깊이 처리

- **Python**: `setrecursionlimit(10**6)` 보일러플레이트 (§6.3).
- **C++**: 기본 스택 넉넉 — 대부분 OK. 선형 재귀 체인이 10⁶급이면 반복 전환.
- **Java**: 기본 스택 얕음(~512KB) — n이 10⁴~10⁵급 선형 재귀 체인이면 스택오버플로 위험 → 반복 전환 or `new Thread(null, task, "solve", 1 << 26).start()`. (현재까지 프로그래머스 저난도는 안 걸림.)

### 7.5 원소별 변환 (조건부 배열 변환 / 변환 반복-until-stable) `[합의]`

- **Python**: 원소 하나 받는 헬퍼 `transform(x)` (가드 리턴, §4) + `[transform(x) for x in arr]` 컴프리헨션. 전체 배열 받는 `step` 아님. 반복형이면 `cnt = 0; while True: cur = [transform(x) for x in prv]; if cur == prv: return cnt; prv = cur; cnt += 1` (카운터 `cnt`, §3.1).
- **Java**: `static int[] step(int[] arr)` — `int[] res = arr.clone();` 후 인덱스 루프로 `res[i]` 변형, `return res`.
- **C++**: 자유 함수 `vector<int> step(vector<int> v)` — 값 전달(암묵 복사), `for (int& x : v)` 변형, `return v`.
- 1회성 변환(반복 아님)이면 Python은 위 그대로, C++/Java는 입력 배열 제자리 변형 후 반환.
- 대칭 2분기(`len >= 11`이면 합, 아니면 곱)는 Python도 `else:` 유지 — Java/C++ 블록 구조 미러, §4 "redundant else 지적 X"를 넘어 능동적으로 원함.

### 7.6 차분 배열 (imos) / 누적합 복원 `[합의]`

구간 업데이트 `[l, r] += v`를 여러 번 한 뒤 **최종 배열만** 읽을 때. O(n + q). (업데이트·조회가 번갈아 오면 불가 → 펜윅/세그.)

- 배열 이름 **`diff`** (`imos`도 통용). 복원 중 러닝 누적자는 **`sum`** (§3.1) — `diff` 배열이 아니라 스칼라.
- 크기 **`n + 1`**(최소 — `r + 1` 최대 `n`) 또는 **`n + 2`**(경계 안 보는 안전빵). 둘 다 통용, 하나로 안 정해짐.
- 업데이트: `diff[l] += v; diff[r + 1] -= v;` — **전부 수집한 뒤** 복원 1회. 2단계 분리가 핵심.
- 복원 두 방식 (둘 다 국룰):
  - **러닝 누적 단일 루프** — `diff` 안 건드리고 `sum += diff[i]; arr[i] += sum;`. 기존 배열에 얹을 때 더 흔함.
  - **`diff` 제자리 누적합** — `for i in 1..n-1: diff[i] += diff[i-1]`, `diff`가 곧 답. 반환값이 `diff` 자체일 때.
- **C++/Java**: 복원은 명시 `for` 루프 (`partial_sum`/`accumulate` X — §5.1 리덕션 규칙). 값 누적이 int 넘치면 `long`/`long long`.
- **Python**: 복원은 `itertools.accumulate` — `list(accumulate(diff))[:n]` 또는 `[b + d for b, d in zip(base, accumulate(diff))]` (`zip`이 `base` 길이에서 잘라줌). `range(len)` 수동 누적 X.
- **2D**: 네 꼭짓점 이벤트 `diff[r1][c1] += v` · `diff[r1][c2+1] -= v` · `diff[r2+1][c1] -= v` · `diff[r2+1][c2+1] += v` + 2D 누적합. 크기 `(n+2) × (m+2)`.

---

## 8. IO·출력 `[확정]`

- **echo면 파싱 안 함**: 읽은 토큰을 그대로 되뱉기만 하면 문자열로 받음. 연산 필요할 때만 파싱.
- **rstrip / 이중 개행**: Python `readline` 통째로 읽고 `print` → 개행 2번 / Java 매 줄 `\n` 붙이고 `println(sb)` → 끝에 빈 줄. **채점기가 trim해서 AC면 그대로 둠.** `print(sb)`/`rstrip` 강요 X, AC 지장 있을 때만.
- 출력 모아서 한 번에 (루프 안 개별 출력 = 초보 마커) — **단 이건 출력량 많을 때 규칙**(flush/호출 오버헤드). n이 작아 몇 줄 안 되는 소형 고정 출력이면 루프 안 `print`/`cout` 그대로 둬도 됨.

---

## 9. 파일 컨벤션

- 한 문제 폴더: `Solution.{java,cpp,py}` + 대체 접근이면 `SolutionN.{ext}`.
- `SolutionN`의 **끝자리가 같으면 같은 풀이 원리** (Solution = 루프, Solution2 = 폐형식 등).
- 어떤 언어에서 관용적으로 안 되는 접근은 스킵 → 파일 갭은 의도적 (예: Python `Solution2`/`Solution4`만).
- **소스 포맷은 사용자가 직접** — 배치 포맷·포맷 훅·Java 포매터 먼저 제안 금지. `.clang-format`(Google 베이스, indent 4, col 120)은 커밋돼 있고 유지 — CP 통상보다 보수적으로 세로로 펼치는 건 **의도적**(아카이브 가독성). `AllowShortLambdas/Functions/Blocks` 비활성도 의도.

---

## 부록 A. 크로스언어 비통일이 정상 `[합의]`

같은 문제의 C++/Java/Python 3풀이는 **로직·구조·변수명이 서로 달라도 된다.** 목표는 "각 언어로 PS 많이 해본 사람이 쓴 것처럼"이지 3파일을 나란히 맞추는 게 아니다. **불일치 자체를 지적 사유로 삼지 말 것** — 먼저 "각 언어에서 그게 관용인가"를 확인.

대조표는 §5.4. 핵심 갈림: 리덕션(C++/Java 루프 vs Python 내장), 최소/최대 이름(`mn`/`mx` vs `min`/`max`), 스택 이름(`st` vs `stack`), 해시맵 이름(`mp` vs `map`), `char` 캐스트(생략 vs `(char)` 필수), 재귀 헬퍼 위치(자유함수 vs static vs 클로저), 그래프 방문 배열 위치(전역 vs 파라미터 vs 캡처).

- "Java에 맞춰 C++도 지역 vector로" 같은 제안 금지 (사용자가 명시적으로 거부).
- dedup/membership 집합은 예외적으로 세 언어 다 `seen`.
