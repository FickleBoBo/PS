---
name: ps-new-problem
description: PS 알고리즘 문제풀이 레포에서 프로그래머스·LeetCode·Codeforces 문제의 day_XX/{judge}_{id}/ 폴더와 언어별 보일러플레이트를 만든다(프로그래머스·LeetCode 는 Java/C++/Python, Codeforces 는 C++). 인자 없이 호출되면 현재 Chrome에 열려있는 문제 탭들을 자동으로 스캔해서 한번에 세팅한다. "새 문제 만들어줘", "문제 세팅해줘", "스캐폴드해줘" 같은 요청, 또는 특정 문제로 템플릿 요청 시 사용.
---

# PS 문제 스캐폴딩 (프로그래머스 · LeetCode · Codeforces)

전체 과정(문제 탐지, day_XX 결정, 시작 코드 fetch, 파일 생성)을 `new-problem.py`가 전부 처리한다.

## 실행

```
<이 스킬의 base directory>/new-problem.py [문제 ...]
```

- **인자 없이 호출**(기본, 사용자가 보통 이렇게 부름): 열려있는 Chrome 탭을 스캔해서 아래 3개 저지의 문제 URL을 전부 추출해 한번에 처리한다. 지원 안 하는 사이트 탭은 무시.
- **특정 문제를 인자로 줄 때**: 다음 중 아무 형태나 (여러 개면 공백 구분)
  - 문제 URL 그대로 (`https://leetcode.com/problems/two-sum/`)
  - 프로그래머스 = 숫자 (`42578`), LeetCode = slug (`two-sum`), Codeforces = `2148A` (대소문자 아무거나)
  - 모호하면 접두사: `prms:42578` `leet:two-sum` `cofo:2148A`
- 이번 달(`{year}-{month}`) 모듈이 없으면 에러 종료 — `ps-new-month` 먼저 실행하라고 안내.
- day_XX 번호 = **스킬 실행 시각의 '일'**(`date.today().day`, zero-pad). 같은 날 재실행하면 같은 `day_XX`에 누적되고, 안 푼 날은 폴더가 안 생겨 자연히 건너뛴다. 달이 바뀌면 모듈이 갈리므로 리셋. Claude가 계산할 필요 없음.
- 이미 존재하는 `{judge}_{id}/` 폴더는 건너뛴다(skipped 보고) — **오늘 day_XX 안에서만** 검사. 예전 day에 같은 문제가 있어도 오늘 다시 지정하면 새로 만든다(다른 날 재도전 워크플로 허용).
- **git add/commit은 하지 않는다** — 스캐폴딩만. 풀이 커밋은 블로그 레포 담당([[ps-blog-pipeline]], `PS/CLAUDE.md` 작업 범위 참조).

## 저지별 동작

| 저지         | URL 패턴                                                                                       | 폴더                     | 파일         | 시작 코드                                                                        |
| ------------ | ---------------------------------------------------------------------------------------------- | ------------------------ | ------------ | -------------------------------------------------------------------------------- |
| 프로그래머스 | `school.programmers.co.kr/learn/courses/30/lessons/{id}`                                       | `prms_{id}`              | `Solution.*` | 공식 스켈레톤 fetch (언어별)                                                     |
| LeetCode     | `leetcode.com/problems/{slug}`                                                                 | `leet_{frontendId}`      | `Solution.*` | 공식 GraphQL `codeSnippets` fetch (로그인 불필요, **프리미엄 문제는 실패 처리**) |
| Codeforces   | `codeforces.com/(contest\|gym)/{c}/problem/{x}`<br>`codeforces.com/problemset/problem/{c}/{x}` | `cofo_{c}{x}` (x 소문자) | `Main.cpp`   | **C++ 만** 생성. 시작 코드 개념이 없어 고정 보일러플레이트 (네트워크 안 씀)      |

### 생성되는 파일 상세

- **프로그래머스**: Java엔 `package day_XX.prms_{id};`, cpp는 `#include`/`using` 줄을 `bits/stdc++.h` 고정 헤더로 교체. 표준입출력(`main`) 스타일 문제면 cpp `main()` 동기화 해제 + py `input = sys.stdin.readline`을 덧붙인다.
- **LeetCode**: 항상 `class Solution` 시그니처 스타일. Java는 `package` + (시그니처가 `java.util` 타입을 참조하면) `import java.util.*;`, cpp는 `bits/stdc++.h` 헤더 프리펜드, py는 스니펫을 그대로(typing import 안 붙임 — 구형 `List[..]` 표기는 저장 시 에디터 포매팅이 정리).
- **Codeforces**: `Main.cpp` 하나만 — `#include <bits/stdc++.h>` + `ios::sync_with_stdio(0); cin.tie(0);` 가 들어간 `int main()`. (Java/Python 은 안 만든다 — 사용자 방침)
- 원본이 CRLF여도 전부 LF로 정규화. 로그인 없이 받는 **기본** 스켈레톤이라 과거에 풀어놨어도 항상 깨끗하게 생성된다.

## 실패 시

- 지원 저지 탭이 하나도 없으면(또는 인자 파싱 실패) 에러 메시지 그대로 보고.
- 특정 문제 fetch 실패(네트워크, 없는 slug/번호, LeetCode 프리미엄)는 그 문제만 `failed`로 보고하고 나머지는 정상 처리. 재시도 없음.
- 종료 코드는 **전부 실패했을 때만** 1, 일부라도 생성되면 0 — 성공/실패는 stdout `created:` / stderr `failed:` 목록으로 판단.
- day_XX 디렉터리는 하나라도 생성 성공했을 때만 만들어진다(전부 실패 시 빈 day 폴더 안 남음).
