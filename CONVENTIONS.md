# PS 코딩 컨벤션

> 사용자가 확정한 규칙만 적는 정본이다.

## 0. 문서 운영

- 이 문서의 규칙이 언어 일반 관례와 CP 관례보다 우선한다. 규칙이 없는 곳에서는 두 관례를 동급으로 본다.

### 0.1 규칙 단계

모든 규칙은 아래 단계 중 하나의 태그를 단다. 단계는 규칙을 어길 때 얼마나 무겁게 다루는지를 정한다.

| 단계     | 지적                                       | 수정   |
| -------- | ------------------------------------------ | ------ |
| `[필수]` | 반드시                                     | 반드시 |
| `[권장]` | 반드시                                     | 선택   |
| `[허용]` | 지적 대상 아님 (해도, 안 해도 위반 아니다) | -      |

- 규칙이 충돌하면 필수 > 권장 > 허용 순으로 적용하고, 같은 등급이면 더 구체적인 규칙이 우선한다. 다른 규칙의 예외로 적힌 `[허용]`은 그 규칙을 한정하는 것이라 충돌로 보지 않는다.

### 0.2 적용 범위

- 2026-08-20(포함) 이후의 풀이에 적용한다. 그 이전 풀이는 대상이 아니다.
- 표준 입출력 저지(`boj_` `cofo_` `swea_` `softeer_`)와 함수형 저지(`prms_` `leet_`)의 `{플랫폼}_{문제번호}` 풀이 폴더에 있는 `.java` `.cpp` `.py`에 적용한다.
- 입출력 코드를 정하는 규칙(5~7장의 입출력 항목)은 함수형 저지에 해당 없다. 단 함수형 저지에도 적용된다고 명시한 항목(예: 6.1 `StringTokenizer`)과 입출력이 아닌 템플릿 항목(예: 5.1 파일 첫머리 헤더)은 적용된다.
- 표준 입출력으로 푸는 `prms_` 풀이는 표준 입출력 저지와 같게 본다.
- `live_` 폴더는 대회 종료 순간의 코드를 그대로 박제한 것이라 적용 대상이 아니다. 학습·정리는 `cofo_` 폴더에서 한다.
- `.sql` 풀이(프로그래머스 SQL)는 적용 대상이 아니다.

### 0.3 포맷

- `[필수]` 코드 포맷(들여쓰기, 중괄호 위치, 줄 길이, 공백, 빈 줄 등)은 이 문서가 정하지 않고 포매터가 정한다. 포매터가 낸 결과는 규칙 위반으로 지적하지 않는다.

| 언어   | 포매터                       | 설정                                                      |
| ------ | ---------------------------- | --------------------------------------------------------- |
| Java   | IntelliJ                     | IntelliJ 기본 스타일                                      |
| C++    | VS Code `ms-vscode.cpptools` | 레포 `.clang-format`                                      |
| Python | VS Code `charliermarsh.ruff` | 레포 `ruff.toml`. 저장 시 `fixAll`·`organizeImports` 적용 |

- 명령줄에서 포맷할 때는 `.claude/scripts/format.sh [--check] <파일|폴더>...`를 쓴다. 에디터와 같은 포매터가 돌며, `--check`는 바뀔 파일만 알려 준다.

## 1. 이름 규칙

### 1.1 표기

| 언어   | 변수·함수    | 단일 값 상수       | 타입·클래스  |
| ------ | ------------ | ------------------ | ------------ |
| Java   | `camelCase`  | `UPPER_SNAKE_CASE` | `PascalCase` |
| C++    | `camelCase`  | `UPPER_SNAKE_CASE` | `PascalCase` |
| Python | `snake_case` | `UPPER_SNAKE_CASE` | `PascalCase` |

- `[필수]` 위 표기를 따른다. 변수 이름은 소문자로 시작하고, 전부 대문자인 이름은 단일 값 상수에만 쓴다.

### 1.2 상수와 `const`·`final`

- `[필수]` 단일 값 상수는 C++ `const`, Java `static final`로 선언한다 (`MOD`, `INF`, `MAX_N`). Python은 해당 없음. `constexpr`는 쓰지 않는다.
- `[필수]` `const`·`final`을 자의로 붙이는 곳은 단일 값 상수뿐이다. 그 밖에는 문법상 반드시 필요한 곳에만 붙인다 (예: `bool operator<(const Edge& o) const`).
- `[필수]` 읽기 전용 배열·룩업 테이블(`dr`, `dc`)은 상수 취급하지 않는다. `const`·`final` 없이 소문자로 쓴다.

### 1.3 저지·지문이 준 이름

- `[필수]` 함수형 저지가 준 시그니처(함수·매개변수·클래스 이름과 타입)는 바꾸지 않는다. 다른 모든 규칙보다 우선한다 (`solution(String A, String B)`). 본문에서 직접 짓는 이름에는 적용되지 않는다. Java에서 풀이가 여럿이라 클래스 이름에 번호를 붙이는 것(`Solution2`, 6.1)은 예외다.
- `[허용]` 지문이 주거나 지문에서 사용한 이름은 낯설어도 쓸 수 있다. 2장 표의 이름이 아니어도 지적하지 않는다.
- `[필수]` 지문의 이름을 쓸 때도 표기는 1.1을 따른다 (`N` → `n`, `max_val` → Java·C++ `maxVal`).

### 1.4 겹치는 이름

- `[필수]` 그 풀이가 컴파일되지 않거나 동작하지 않게 되는 이름은 쓰지 않는다 (예약어, 이후에 호출하는 내장 함수를 가리는 이름 등).
- `[허용]` 표준 라이브러리·내장 이름과 겹쳐도 정상 동작하면(섀도잉) 지적하지 않는다. 겹침을 피할 때의 대체 이름은 2장 표를 따른다.

### 1.5 함수 이름

- `[권장]` 아래 용도의 함수는 표의 이름을 쓴다.

| 용도                            | Java·C++                                  | Python                                     |
| ------------------------------- | ----------------------------------------- | ------------------------------------------ |
| 테스트케이스 한 건 처리         | `solve`                                   | `solve`                                    |
| 깊이·너비 우선 탐색, 백트래킹   | `dfs` `bfs` (백트래킹도 `dfs`)            | `dfs` `bfs`                                |
| 최단 경로                       | `dijkstra` `bellmanFord` `floydWarshall`  | `dijkstra` `bellman_ford` `floyd_warshall` |
| 위상 정렬                       | `topologicalSort`                         | `topological_sort`                         |
| 최소 신장 트리                  | `kruskal` `prim`                          | `kruskal` `prim`                           |
| 유니온 파인드                   | `find`, 합치기는 Java `union` C++ `unite` | `find` `union`                             |
| 최대공약수·최소공배수           | Java `gcd` `lcm` (C++은 표준, 8.1)        | 표준 (8.1)                                 |
| 나머지를 취하는 거듭제곱        | `modPow`                                  | `mod_pow`                                  |
| 그 밖의 이진 거듭제곱 (행렬 등) | `binPow`                                  | `bin_pow`                                  |
| 에라토스테네스의 체             | `sieve`                                   | `sieve`                                    |
| 소수 판정                       | `isPrime`                                 | `is_prime`                                 |
| 조합·팩토리얼                   | `comb` `fact`                             | `comb` `fact`                              |
| 세그먼트 트리                   | `build` `update` `query`                  | `build` `update` `query`                   |
| 값 찾기 이분 탐색               | `binarySearch`                            | `binary_search`                            |
| 경계 찾기 이분 탐색 (8.4)       | `lowerBound` `upperBound`                 | `lower_bound` `upper_bound`                |
| KMP 실패 함수·탐색              | `failure` `kmp`                           | `failure` `kmp`                            |

- `[허용]` 표에 없는 함수는 1.1 표기만 맞추고 자유롭게 짓는다.

### 1.6 기타 이름

- `[허용]` 불리언 이름은 의미가 분명하면 `is`·`has` 접두사를 쓰고, 아니면 `flag`로 쓴다.
- `[허용]` 같은 의미가 둘 이상 필요하면 첫 번째는 접미사 없이, 두 번째부터 `2`, `3`을 붙인다 (`dp`, `dp2`). 별도 이름(`ndp` 등)을 지어도 된다. 대등한 값들은 첫 번째부터 번호를 붙여도 된다 (`sum1`, `sum2`).
- `[허용]` Python과 C++(지역 변수)에서 쓰지 않는 값의 이름으로 `_`를 쓸 수 있다 (반복 변수, 분해 할당, 구조적 바인딩). Java는 `_`를 이름으로 쓸 수 없다.
- `[필수]` `_`의 값은 읽지 않는다.
- `[허용]` `_` 대신 이름을 붙이고 쓰지 않는 반복 변수는 3.8의 "안 쓰는 변수"로 지적하지 않는다.

## 2. 표준 변수명

- `[권장]` 아래 의미에는 표의 이름을 쓴다.
- `[권장]` 컨테이너는 종류보다 용도 이름을 먼저 쓴다 (`vis`, `cnt`). 용도 이름이 없을 때 종류 이름(`v`, `list`·`arr`, `st`, `mp`)을 쓴다.
- `[허용]` 구체적인 뜻이 더 잘 드러나는 이름은 써도 된다 (`chk` 대신 `erased`).
- `[허용]` 답을 만들어 바로 반환하는 간단한 풀이에서는 `ans`·`res` 대신 `v`, `list`, `s`, `arr`을 써도 된다.
- `[허용]` 답이 개수·합·최댓값처럼 뜻 하나로 설명되면 `ans` 대신 `cnt`, `sum`, `max`·`mx` 같은 그 이름을 써도 된다.
- `[허용]` 범위 `for` 원소는 컬렉션 이름에서 딴 약어를 써도 된다 (`words` → `w`).
- `[허용]` 표에 없는 의미의 이름은 자유다.

### 2.1 입력·출력

| 의미                 | 이름                | 비고                                            |
| -------------------- | ------------------- | ----------------------------------------------- |
| 테스트케이스 수·번호 | `t` `tc`            | `tc`는 1부터. 번호가 필요할 때만 쓰는 지역 변수 |
| 입력 크기            | `n` `m` `k`         |                                                 |
| 쿼리 수              | `q`                 | 큐 `q`와 겹치면 `queries`                       |
| 입력 배열            | `arr`               | C++ `vector`로 받으면 `v`                       |
| 문자열               | `s`                 |                                                 |
| 문자                 | `c`                 |                                                 |
| 나눈 문자열 조각     | `token` `tokens`    |                                                 |
| 입력·텍스트 한 줄    | `line`              |                                                 |
| 연산자·명령          | `op`                |                                                 |
| 격자                 | `grid`              |                                                 |
| Java 입출력 객체     | `br` `bw` `st` `sb` | Python 출력 리스트는 `out`                      |
| C++ 문자열 스트림    | `ss`                |                                                 |

### 2.2 결과·값

| 의미             | 이름                    | 비고                                           |
| ---------------- | ----------------------- | ---------------------------------------------- |
| 문제의 답        | `ans`                   | `main`에서 출력하거나 `solution`이 반환하는 값 |
| 그 외의 결과물   | `res`                   | 보조 함수의 반환값, 답이 되기 전의 중간값      |
| 최솟값·최댓값    | `min` `max` / `mn` `mx` | Java / C++·Python                              |
| 합               | `sum` / `total`         | Java·C++ / Python                              |
| 누적곱           | `mul`                   |                                                |
| 길이             | `len` / `length`        | Java·C++ / Python                              |
| 임시 변수        | `tmp`                   |                                                |
| 범위 `for` 원소  | `x`                     | 문자열이면 `s`, 문자면 `c`                     |
| 플래그           | `flag`                  |                                                |
| 상수             | `INF` `MOD`             |                                                |
| 배열 크기용 상수 | `MAX_` + 의미           | `MAX_N` `MAX_M` `MAX_LEN`. 쓰는 방법은 3.6     |
| 값의 상한 상수   | `MAX`                   | 쓰는 방법은 3.6                                |

### 2.3 인덱스·좌표

| 의미                 | 이름                    | 비고                                     |
| -------------------- | ----------------------- | ---------------------------------------- |
| 루프 인덱스          | `i` `j` `k`             | 행·열을 강조할 때 `r` `c`                |
| 외부에서 갖는 인덱스 | `idx`                   | `find` 계열이 돌려준 위치는 `pos`도 된다 |
| 이전·현재·다음       | `prv` `cur` `nxt`       |                                          |
| 좌표                 | `x` `y`                 |                                          |
| 행·열                | `r` `c`                 |                                          |
| 행 하나·열 하나      | `row` `col`             | 인덱스는 `r` `c`                         |
| 방향 배열            | `dr` `dc`               |                                          |
| 방향 인덱스          | `d`                     | `for (int d = 0; d < 4; d++)`            |
| 다음 행·열           | `nr` `nc`               |                                          |
| 시작·끝              | `s` `e` / `start` `end` |                                          |
| 시작 행·열           | `sr` `sc`               |                                          |
| 도착 행·열           | `er` `ec`               |                                          |
| 좌·우                | `l` `r`                 |                                          |
| 느린·빠른 포인터     | `slow` `fast`           | 한 칸씩·두 칸씩 움직이는 두 포인터       |
| 이분 탐색            | `lo` `hi` `mid`         | 그 외의 구간·투 포인터는 `l` `r`         |

- `[권장]` 4방향·8방향 배열은 시계 방향으로 쓴다. 4방향은 위부터 (`dr = {-1, 0, 1, 0}`, `dc = {0, 1, 0, -1}`), 8방향은 좌상단부터 (`dr = {-1, -1, -1, 0, 1, 1, 1, 0}`, `dc = {-1, 0, 1, 1, 1, 0, -1, -1}`) 쓴다. 문제가 순서를 정하면 그 순서를 따른다.
- `[권장]` 격자 범위 검사는 행을 먼저 검사하고 열을 검사한다 (`nr < 0 || nr >= n || nc < 0 || nc >= m`).

### 2.4 자료구조·그래프

| 의미                    | 이름                                 | 비고                                              |
| ----------------------- | ------------------------------------ | ------------------------------------------------- |
| 일반 순차 컨테이너      | C++ `v` / Java `list` / Python `arr` |                                                   |
| 집합                    | Java `set` / C++·Python `st`         |                                                   |
| 다중 집합               | C++ `ms`                             |                                                   |
| 맵                      | Java `map` / C++·Python `mp`         |                                                   |
| 맵 순회의 키·값         | `k` `v` / Java 엔트리 `e`            | `for (auto [k, v] : mp)`, `for k, v in d.items()` |
| 큐                      | `q`                                  |                                                   |
| 덱·우선순위 큐          | `dq` `pq`                            | Python `heapq` 힙도 `pq`                          |
| 스택                    | Java·Python `stack` / C++ `st`       | C++에서 집합 `st`와 겹치면 스택을 `stk`로 쓴다    |
| 스택 최상단 값          | `top`                                | `st.top()`·`stack.peek()`으로 받은 값             |
| 간선·정점·가중치        | `edges` `u` `v` `w`                  |                                                   |
| 정점 수·간선 수         | `n` `m`                              |                                                   |
| 인접 리스트·행렬        | `adj`                                |                                                   |
| 유니온 파인드·트리 부모 | `p`                                  |                                                   |
| 거리·비용               | `dist`                               |                                                   |
| 깊이                    | `depth`                              |                                                   |
| 진입 차수 배열          | `indegree`                           |                                                   |
| 방문 체크 (배열·셋)     | `vis`                                | 노드·칸·상태의 방문, 백트래킹의 선택 표시         |
| 값 등장 확인            | `seen`                               | 값이 이미 나왔는지                                |
| 그 밖의 표시 여부       | `chk`                                | 삭제됨·막힘 등 위 둘이 아닌 표시                  |
| 레벨 BFS의 큐 크기      | `sz`                                 |                                                   |
| 순열·조합 하나          | Python `seq`                         | `itertools` 결과를 도는 변수                      |

### 2.5 수학·DP

| 의미                                | 이름                                   | 비고                           |
| ----------------------------------- | -------------------------------------- | ------------------------------ |
| 최대공약수                          | `g`                                    |                                |
| 분자·분모                           | `p` `q`                                |                                |
| 자릿수                              | `d`                                    |                                |
| 소수 판정 bool 배열                 | Java·C++ `isPrime` / Python `is_prime` |                                |
| KMP 실패 함수 배열                  | `pi`                                   |                                |
| 누적합·차분 배열                    | `psum` `diff`                          | `diff`는 두 값의 차이에도 쓴다 |
| DP 테이블 (바텀업)                  | `dp`                                   |                                |
| 메모이제이션 (탑다운 캐시, 배열·맵) | `memo`                                 |                                |
| 카운팅 (배열·맵·개수 변수)          | `cnt`                                  |                                |

## 3. 공통 작성

### 3.1 숫자 리터럴

- `[필수]` 10진 정수 리터럴은 7자리 이상이면 천 단위 구분자를 넣고 (C++ `1'000'000`, Java·Python `1_000_000`), 6자리 이하면 넣지 않는다.
- `[권장]` 한 풀이에서 같은 뜻의 정수가 3회 이상 나오면 상수로 뽑고, 상수가 있으면 같은 값을 리터럴로 또 쓰지 않는다. 두 자리 이하의 수, `-1`, 방향 배열 값은 제외한다.
- `[허용]` 지수 표기(`1e9`, `1e-9`)와 거듭제곱 식(`10**9`, `pow`, `Math.pow`)을 쓸 수 있다.

### 3.2 홀짝 판정과 조건식 표기

- `[필수]` 홀짝 판정은 `% 2`로 한다. `& 1`은 쓰지 않는다 (비트를 뽑는 것이 목적이면 해당 없음).
- `[필수]` 홀수는 `n % 2 != 0`으로 판정한다. `== 1`은 쓰지 않는다 (C++·Java는 음수에서 오답).
- `[허용]` C++·Python은 값이나 컨테이너를 조건에 그대로 써도 되고 명시적으로 비교해도 된다 (`if (n % 2)`, `if stack:`). 홀수 판정도 같다.

### 3.3 조기 반환

- `[권장]` 조건 하나가 함수나 루프 본문 전체를 감싸고 그 안이 단문 하나가 아니면, 조건을 뒤집어 조기 탈출(`return`/`break`/`continue`)로 바꿔 중첩을 줄인다.
- `[허용]` 분기가 대등하거나 여러 개가 이어질 때는 조기 반환 대신 `if / else if / else` 체이닝을 쓸 수 있다.

### 3.4 중괄호

- `[권장]` 본문이 단문 하나인 `if`(`else` 없음)는 한 줄로 쓰고 중괄호를 생략한다 (`if (x < 0) continue;`).
- `[필수]` `else`(`else if` 포함)가 붙는 `if`는 모든 분기에 중괄호를 쓴다. 한 분기만 중괄호를 쓰는 것도 금지.
- `[필수]` Java의 반복문(`for`/`while`)은 본문이 단문이어도 항상 중괄호를 쓴다.
- `[허용]` C++의 반복문은 본문이 단문 하나일 때 중괄호를 생략해도 되고 써도 된다.

### 3.5 삼항 연산자

- `[권장]` 삼항 연산자는 긍정 케이스(찾음·성공·조건 참)를 앞에, 아닌 쪽을 뒤에 쓴다 (`idx != -1 ? idx + 1 : -1`). 두 값이 대등하면(`a > b ? a : b`) 순서를 정하지 않는다.
- `[필수]` 삼항 연산자는 중첩(`a ? b : c ? d : e` 같은 연쇄 포함)하지 않는다. 셋 이상 분기는 `if / else if / else`로 쓴다.

### 3.6 크기 식·인덱스

- `[필수]` 크기 식(`new int[...]`, `vector<int> v(...)`, 배열 선언, `[0] * (...)`)의 여유분은 칸이 놓이는 순서대로 쓴다. 앞의 0번 칸(1-indexed, 값 `0`부터 담는 `0..n` 테이블)은 `1 + n`, 끝의 보조 칸은 `n + 1`, 앞뒤 모두면 `1 + n + 1`이다. 0이 가운데인 `-n ~ n` 구간은 `n + 1 + n`으로 쓴다. 구간 길이를 구하는 `+ 1`(`end - start + 1`)은 여유분이 아니라 해당 없다.
- `[필수]` 여유분이 섞인 크기·상한은 합친 리터럴(`101`)로 쓰지 않는다 (`1 + 100`). 반복문의 포함 상한도 같다 (`i < 41`이 아니라 `i <= 40`). Python `range`의 끝은 예외로, 리터럴이면 `+ 1`을 나누지 않고 합친 값으로 쓴다 (`range(1, 11)`로 쓰고, `range(1, 10 + 1)`로 쓰지 않는다). 정확한 크기(`26`, `100`)와 센티널 값은 해당 없다.
- `[권장]` 크기 식이 아닌 곳의 `+ 1`은 일반 순서(`r + 1`)로 쓴다.
- `[권장]` 배열 크기용 상수는 `MAX_` + 의미로 쓴다. 입력 값의 상한과 입력과 무관한 문제의 상한은 `MAX`로 쓴다. 여러 입력이 공유하는 상한(n, m ≤ 1000)은 `MAX`가 아니라 `MAX_N`처럼 의미를 붙여 쓰고, 상한이 변수마다 다르면 `MAX_N` `MAX_M`으로 나눈다.
- `[필수]` 크기에만 쓰는 상수는 여유분을 선언에 넣고 (`const int MAX_N = 1 + 100000;`, `adj[MAX_N]`) 순회·비교에 쓰지 않는다. 로직에도 쓰는 `MAX`는 지문 값 그대로 선언하고 여유분은 쓰는 자리에서 붙인다 (`cnt[1 + MAX]`, `i <= MAX`).
- `[필수]` 끝에서부터 세는 인덱스는 기준값을 앞에, 반복 변수를 맨 뒤에 쓴다 (`n - 1 - i`, `n - i`. `n - i - 1`은 쓰지 않는다).

### 3.7 선언

- `[허용]` 서로 관련된 변수는 한 줄에 같이 선언해도 된다 (`int n, m;`, `int lo = 0, hi = n;`).

### 3.8 주석·방어 코드·잔여 코드

- `[허용]` 주석은 써도 되고 안 써도 된다.
- `[권장]` 문제 제약상 불가능한 입력(빈 배열, `n == 0` 등)에 대한 방어 코드는 넣지 않는다.
- `[허용]` 컴파일에 필요해 넣는, 도달하지 않는 마지막 `return`은 방어 코드로 보지 않는다. 값은 자유다.
- `[필수]` 디버그 출력, 주석 처리한 옛 코드, 안 쓰는 변수·함수·`import`를 남기지 않는다. 5.1의 `#include <bits/stdc++.h>`는 제외한다.
- `[허용]` 입력 한 줄에서 함께 받는 값은 쓰지 않아도 이름을 둔다 (`n, m = ...`의 `n`).
- `[필수]` `System.out.println(sb.toString())`(→ `println(sb)`)과 `== true`·`!= false` 비교를 쓰지 않는다.
- `[권장]` 그 밖에도 빼도 동작이 같은 변수·형변환·괄호는 남기지 않는다. 읽기를 돕는 괄호(`n &= (n - 1)`)와 컴파일·정답에 필요한 형변환(`1LL *`, `(long)`)은 해당 없다.

## 4. 타입·메모리

### 4.1 정수 타입 크기

- `[필수]` 값이나 중간 결과가 `int`를 넘을 수 있으면 `long long`(C++)·`long`(Java)을 쓴다.
- `[권장]` 그 밖에는 `int`를 쓰고, 필요 없는 변수까지 습관적으로 큰 타입으로 두지 않는다.
- `[허용]` 형변환을 피하려고 미리 큰 타입으로 선언해도 된다.

### 4.2 곱셈 승격

- `[필수]` `int` 곱을 올릴 때 Java는 `(long) a * b`, C++은 `1LL * a * b`로 쓴다.
- `[필수]` 승격은 곱하기 전에 한다. `(long)(a * b)`, `a * b * 1LL`은 이미 넘친 값을 올린다.

### 4.3 무한대·나머지·실수

- `[허용]` `INF`는 무한대를 뜻하는 상수이고, 값은 문제에 맞게 정한다.
- `[필수]` Java·C++에서 음수가 될 수 있는 값의 0 이상인 나머지가 필요하면 `((x % m) + m) % m`으로 쓴다 (Java `Math.floorMod`는 쓰지 않는다). Python은 `%`를 그대로 쓴다.
- `[필수]` `double`·`float`는 `==`·`!=`로 비교하지 않고 `EPS` 상수(`1e-9` 등)로 오차 비교를 한다.

### 4.4 전역·지역 변수

- `[필수]` C++에서 원소 10만 개 이상의 고정 크기 배열(다차원은 곱)은 전역에 둔다. `vector`는 해당 없다.
- `[허용]` 그 밖의 전역·지역(Java `static` 필드 포함) 선택은 자유다.

### 4.5 타입 별칭·보조 타입

- `[필수]` 타입 별칭과 매크로를 쓰지 않는다 (`using ll = long long`, `typedef`, `#define`).
- `[허용]` `cofo_` 풀이에서는 타입 별칭과 매크로를 써도 된다.
- `[필수]` 보조 타입은 C++에서 `struct`, Java에서 `static class`로 만든다. C++ `class`는 직접 정의하지 않는다.

## 5. C++

### 5.1 템플릿·IO

- `[필수]` C++ 표준은 BOJ·LeetCode·Codeforces는 C++23, 프로그래머스는 C++20 기준이다.
- `[필수]` 파일은 아래 두 줄로 시작하고 빈 줄을 하나 둔다.

```cpp
#include <bits/stdc++.h>
using namespace std;
```

- `[필수]` 입출력은 `cin`·`cout`만 쓰고, 표준 입출력 풀이는 `main` 첫머리에 `ios::sync_with_stdio(0); cin.tie(0);`를 쓴다.
- `[필수]` 줄바꿈은 `'\n'`(문자열 안의 `\n` 포함)이고 `endl`은 쓰지 않는다. flush가 필요하면 `cout << flush`를 쓴다.
- `[필수]` `main` 끝의 `return 0;`은 쓰지 않는다.

### 5.2 `auto`

- `[필수]` 산술 타입과 `string`은 범위 `for`를 포함해 타입을 명시한다 (`for (int x : v)`, `for (string& s : v)`, 문자열 행은 `string& row`).
- `[허용]` 그 밖(컨테이너 행, 이터레이터, 구조적 바인딩, `pair`, 람다 등)은 `auto`를 쓴다. `set`·`map` 계열의 `string` 원소(const라 `string&`로 못 받음)와 정렬 비교자 람다 인자(8.3)도 `auto&`로 받는다.

### 5.3 `accumulate`

- `[필수]` `accumulate`의 초깃값 타입은 결과 타입과 같게 쓴다 (합이 `int`를 넘으면 `0LL`).

### 5.4 참조로 받기

- `[권장]` 읽기만 하는 순회 변수와 함수 인자는 산술 타입과 산술 `pair`·`tuple`(맵의 키·값 포함)이면 값으로, `string`·컨테이너면 `&`로 받는다.
- `[필수]` `const T&`·`const auto&`가 아니라 `T&`·`auto&`로 받는다.

### 5.5 배열·문자열·입력

- `[필수]` `char` 배열에 한 줄을 `cin >> 배열`로 읽으면 크기에 NUL 칸을 넣는다 (`char grid[5][15 + 1]`). C++20부터 `cin >> char[N]`은 N-1자까지만 읽는다.
- `[허용]` `v.size() - 1`처럼 `size()`에서 빼는 식을 쓸 수 있다 (빈 컨테이너가 없다는 전제).
- `[필수]` `string::find` 계열의 "없음"은 `string::npos`가 아니라 `-1`로 비교한다 (`s.find(x) == -1`).
- `[필수]` 컨테이너 원소를 전부 입력받을 때는 `for (int& x : v) cin >> x;`처럼 중괄호 없는 한 줄로 쓴다. 인덱스가 필요한 경우(1-indexed `v(1 + n)` 등)는 인덱스 `for`를 쓰고, `char` 2차원 배열의 행 입력(`cin >> grid[i]`)은 해당 없다.

## 6. Java

### 6.1 템플릿·입출력

- `[필수]` Java 버전은 BOJ 11, 그 밖의 저지 21 기준이다 (BOJ에서는 switch 식, `record`, `.toList()` 등이 안 된다).
- `[필수]` 표준 입출력 저지의 클래스는 `public class Main`(SWEA와 표준 입출력 `prms_`는 `Solution`)이고 보조 메서드·생성자에 `public`을 붙이지 않는다.
- `[권장]` 한 폴더에 풀이가 여럿이면 클래스 이름을 파일명에 맞춘다 (`Solution2.java` → `class Solution2`).
- `[필수]` import는 패키지 와일드카드로 쓰고 (`import java.util.*;`) 쓰는 패키지만 넣는다.
- `[필수]` 입력은 `BufferedReader br`로 받고 `Scanner`는 지문이 권장·요구할 때만 쓴다.
- `[필수]` `IOException`은 try-catch 없이 `main`의 `throws IOException`으로 던진다. 던질 일이 없으면 붙이지 않는다.
- `[권장]` 문자열을 나눌 때는 `StringTokenizer st`를 쓰고, `split`은 확실히 나을 때만 쓴다. 함수형 저지에도 적용한다.
- `[필수]` 출력을 모아 낼 때는 `StringBuilder sb`에 모아 `System.out.println(sb)`로 낸다. `sb`가 이미 개행으로 끝나면 `print(sb)`도 된다.
- `[필수]` `sb`에 붙이는 줄바꿈·공백 구분자는 `char`가 아니라 문자열(`"\n"`, `" "`)로 쓴다.
- `[권장]` 루프 안에서 `print`·`println`·`printf`를 직접 부르지 않고 `sb`에 모은다. 출력 직후 루프를 빠져나가거나, 제약상 출력 호출이 많아야 100번이면 해당 없다. 상한을 모르면 모아서 낸다.
- `[허용]` 자릿수 맞춤 등에는 `printf`·`String.format`을 쓸 수 있다.
- `[허용]` 입력을 거의 그대로 내거나 출력이 단순하면 메모리를 아끼려 `BufferedWriter bw`를 써도 된다.
- `[권장]` `sb`에 연속으로 `append`할 때는 체이닝한다 (`sb.append(a).append(" ").append(b)`).

### 6.2 큐·덱·스택

- `[필수]` 큐·덱·스택의 구현체는 `ArrayDeque`다 (`PriorityQueue` 제외). `LinkedList`와 `java.util.Stack`은 큐·덱·스택으로 쓰지 않는다.
- `[필수]` 큐·우선순위 큐는 `offer`·`poll`·`peek`, 덱은 `offerFirst`·`pollLast`처럼 `First`·`Last`가 붙은 같은 계열을 쓴다. `add`·`remove`·`element` 계열은 `remove(x)`를 포함해 쓰지 않는다.
- `[필수]` 스택으로 쓸 때는 `push`·`pop`·`peek`을 쓴다.

### 6.3 스트림·박싱·기타

- `[허용]` 반복문 밖에서 한 문장으로 끝나고 성능에 큰 의미가 없는 변환·집계에는 스트림을 쓸 수 있다 (`list.stream().mapToInt(Integer::intValue).sorted().toArray()`, `Arrays.stream(arr).filter(x -> x % n == 0).toArray()`, `Arrays.stream(arr).sum()`).
- `[권장]` 그 밖의 곳에서는 스트림을 쓰지 않고 반복문으로 쓴다.
- `[허용]` `var`를 쓸 수 있다. 인접 리스트(8.2)는 타입을 명시한다.
- `[필수]` 박싱 타입(`Integer`, `Long`)끼리는 `==`·`!=`로 비교하지 않고 `equals`를 쓰거나 기본형으로 풀어 비교한다. 한쪽이 기본형이면 자동 언박싱되어 값 비교가 되므로 해당 없다.
- `[필수]` `List<Integer>`에서 값을 지울 때는 `list.remove(Integer.valueOf(x))`로 쓴다.

## 7. Python

- `[필수]` BOJ Python은 PyPy3로 제출하고, PyPy3로 안 되면 Python 3으로 낸다. 어느 쪽이든 3.10 문법 안에서 쓴다.
- `[권장]` 코드는 `main()`으로 감싸지 않고 최상위에 바로 쓴다.
- `[필수]` 표준 입력을 읽는 풀이는 `import sys`와 `input = sys.stdin.readline`을 쓴다.
- `[권장]` 문자열 한 줄은 `input().rstrip()`으로 받는다.
- `[필수]` 출력을 모아서 낼 때는 결과를 리스트 `out`에 모으고 마지막에 `print("\n".join(out))`으로 한 번에 낸다. 숫자를 모았으면 `print("\n".join(map(str, out)))`로 낸다.
- `[필수]` 최상위에서 `append`로 채우는 `out`은 `input = sys.stdin.readline` 바로 아랫줄에 `out = []`로 선언한다. 한 번에 만드는 `out`(`out = [... for ...]`)은 만드는 자리에 둔다.
- `[권장]` 지문의 상한으로 계산한 출력이 1000줄을 넘으면 루프 안에서 `print`하지 않고 `out`에 모은다. 상한이 없거나 1000줄 이하면 `out` 없이 바로 `print`한다.
- `[허용]` 루프 밖에서 한 번 내는 `print(*arr)`·`print(*arr, sep="\n")`는 `join`으로 모아 내는 것과 같게 본다.
- `[허용]` `join` 식 하나로 끝나면 `out`에 담지 않고 `print("\n".join(...))`로 바로 낸다.
- `[필수]` import 방식은 아래 표대로 모듈별로 고정하고, `from 모듈 import *`는 쓰지 않는다.

| 방식                    | 모듈                                           | 예                                                                           |
| ----------------------- | ---------------------------------------------- | ---------------------------------------------------------------------------- |
| `import 모듈`           | `sys` `math` `heapq` `string`                  | `sys.stdin.readline`, `math.gcd`, `heapq.heappush`, `string.ascii_uppercase` |
| `from 모듈 import 이름` | `collections` `itertools` `functools` `bisect` | `from collections import deque`, `from bisect import bisect_left`            |

- `[필수]` 재귀 깊이가 1000을 넘을 수 있으면 `sys.setrecursionlimit(10**6)`을 설정하고, 확실히 얕으면 설정하지 않는다.
- `[필수]` Python 문자열 포매팅은 f-string만 쓴다 (`%`·`.format()`·`format()` 금지).

## 8. 자료구조·알고리즘

### 8.1 표준 라이브러리 vs 직접 구현

- `[권장]` 표준 라이브러리에 같은 기능이 있으면 그것을 쓴다 (`std::gcd`·`lower_bound`, `math.gcd`·`bisect`, `computeIfAbsent`).
- `[허용]` 표준에 없거나(Java `gcd`·`lcm`), 문제가 구현을 요구하거나, 표준이 확실히 느리면 직접 구현한다. 잘 알려지지 않은 표준 기능은 안 써도 된다.
- `[허용]` 합·개수 세기·최댓값·원소 변환·조건 판정처럼 반복문으로 간단히 되는 것은 표준 함수 없이 직접 써도 된다.
- `[허용]` 맵의 개수 누적은 `getOrDefault(k, 0) + 1`로 써도 된다. `merge`로 바꾸라고 하지 않는다.
- `[권장]` 대소문자 변환은 내장(`toupper`, `Character.toUpperCase`, `upper`)을 쓴다. 문자를 숫자·인덱스로 바꾸는 `c - '0'`, `c - 'a'`는 그대로 쓴다.
- `[필수]` `lcm`은 나눗셈을 먼저 한다 (`a / gcd(a, b) * b`).
- `[권장]` Codeforces의 C++ 풀이에서는 `unordered_map`·`unordered_set`의 기본 해시를 피한다.

### 8.2 인접 리스트

- `[필수]` 인접 리스트는 리스트의 배열로 만든다 (Java `List<Integer>[] adj = new ArrayList[1 + n];`, C++ `vector<int> adj[MAX_N];`). `List<List<Integer>>`·`vector<vector<int>>`로 만들지 않으며, Java에 `@SuppressWarnings`를 붙이지 않는다.

### 8.3 정렬

- `[필수]` C++ 내림차순은 `sort(v.rbegin(), v.rend())`(또는 정렬 후 `reverse`)로 하고 정렬 함수에 `greater`를 넘기지 않는다. `priority_queue`·`set`의 비교자로는 `greater`를 쓴다.
- `[필수]` C++ 비교자 람다의 인자는 `auto&`로 받는다.
- `[필수]` Java 비교자(`compareTo` 포함)는 뺄셈으로 비교하지 않고 `Integer.compare`·`Comparator.comparingInt` 계열을 쓴다.
- `[필수]` Java에서 값 자체를 역순으로 할 때는 `Comparator.reverseOrder()`를 쓴다.
- `[허용]` 다른 값을 기준으로 비교할 때는 비교자 인자 `o1`·`o2`를 바꿔 넣어 내림차순으로 만들 수 있다 (`Integer.compare(score[o2], score[o1])`).
- `[권장]` 비교자를 변수에 담으면 이름은 `cmp`, 람다 인자는 C++ `a`·`b`, Java `o1`·`o2`로 쓴다.

### 8.4 이분 탐색

직접 구현하는 정수 경계 이분 탐색(배열의 경계 찾기, 매개변수 탐색)에 적용한다. 값 찾기는 아래 마지막 항목을 따른다. 표준 함수로 되는 경우는 8.1(C++ `std::lower_bound` 등, Python `bisect`)이 우선한다.

- `[권장]` 반열린 구간 `[lo, hi)`로 두고 `while (lo < hi)`로 돈다. `hi`는 답이 될 수 있는 마지막 값 다음 이상이다.
- `[권장]` 중간값은 `mid = lo + (hi - lo) / 2`다 (Python은 `//`). 끝나면 `lo`를 반환한다.
- `[권장]` 함수 이름은 `key`와 같은 값을 어느 쪽에 두는지로 정한다 (표기는 1.5). `lowerBound`는 같으면 `hi = mid`(`key`에 처음 닿는 위치), `upperBound`는 같으면 `lo = mid + 1`(`key`를 처음 지나친 위치)이다. 값이 증가하든 감소하든 같다.
- `[허용]` 조건을 만족하는 마지막 값은 `upperBound(...) - 1`처럼 반환값에서 계산한다.

```cpp
long long upperBound(long long key) {
    long long lo = 0, hi = INT_MAX;
    while (lo < hi) {
        long long mid = lo + (hi - lo) / 2;
        if (mid * mid <= key) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    return lo;
}
```

- `[권장]` 값 찾기는 닫힌 구간 `lo = 0, hi = n - 1`, `while (lo <= hi)`로 돌고, 찾으면 `mid`, 못 찾으면 `-1`을 반환한다.

### 8.5 순회·반복 관용구

- `[권장]` 인덱스가 필요 없는 문자열 순회는 향상된 `for`를 쓴다 (C++ `for (char c : s)`, Java `for (char c : s.toCharArray())`, Python `for c in s`).
- `[필수]` 레벨 BFS는 층을 시작할 때 큐 크기 `sz`를 잡고 그 횟수만큼 돈다 (C++ `while (sz--)`, Java `while (sz-- > 0)`, Python `for _ in range(len(q))`). `sz`를 이미 쓰고 있으면 `qsz`로 쓴다.
- `[권장]` 테스트케이스는 `while (t--)`(Java `while (t-- > 0)`, Python `for _ in range(t)`)로 돌고, 번호가 필요하면 `for (int tc = 1; tc <= t; tc++)`(Python `for tc in range(1, t + 1)`)로 쓴다.
- `[허용]` 횟수만 필요하고 이후에 그 값을 쓰지 않는 반복은 `while (n--)`(Java `while (n-- > 0)`)로 써도 된다.

### 8.6 표준 템플릿

- `[권장]` 아래 함수는 문서의 코드와 같은 모양으로 쓴다. 정수 타입(`int`·`long`)은 값 범위에 맞춰 바꾼다. 문제 때문에 동작을 바꿔야 하면 해당 없다.

**최대공약수·최소공배수** (Java. C++·Python은 표준, 8.1)

```java
static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

static int lcm(int a, int b) {
    return a / gcd(a, b) * b;
}
```

**KMP 실패 함수** (C++)

```cpp
vector<int> failure(string& s) {
    vector<int> pi(s.size());
    int j = 0;
    for (int i = 1; i < s.size(); i++) {
        while (j > 0 && s[i] != s[j]) j = pi[j - 1];
        if (s[i] == s[j]) pi[i] = ++j;
    }
    return pi;
}
```

**에라토스테네스의 체**

```cpp
vector<bool> sieve(int n) {
    vector<bool> isPrime(1 + n, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    return isPrime;
}
```

```java
static boolean[] sieve(int n) {
    boolean[] isPrime = new boolean[1 + n];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    return isPrime;
}
```

```python
def sieve(n):
    is_prime = [True] * (1 + n)
    is_prime[0] = is_prime[1] = False
    for i in range(2, math.isqrt(n) + 1):
        if is_prime[i]:
            is_prime[i * i :: i] = [False] * len(range(i * i, n + 1, i))
    return is_prime
```

**유니온 파인드** (부모 배열은 `p`)

```cpp
int find(int x) {
    if (x == p[x]) return x;
    return p[x] = find(p[x]);
}

bool unite(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) return false;
    p[x] = y;
    return true;
}
```

```java
static int find(int x) {
    if (x == p[x]) return x;
    return p[x] = find(p[x]);
}

static boolean union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) return false;
    p[x] = y;
    return true;
}
```

```python
def find(x):
    while x != p[x]:
        p[x] = p[p[x]]
        x = p[x]
    return x


def union(x, y):
    x, y = find(x), find(y)
    if x == y:
        return False
    p[x] = y
    return True
```
