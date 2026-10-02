<div align="center">

# PS

**알고리즘 문제풀이 기록**
_One day One Problem_

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![C++](https://img.shields.io/badge/C++-00599C?style=flat-square&logo=cplusplus&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white)
![SQL](https://img.shields.io/badge/SQL-4479A1?style=flat-square&logo=mysql&logoColor=white)

[![BOJ](https://img.shields.io/badge/BOJ-0076C0?style=flat-square)](https://solved.ac/qwera1997/)
[![Programmers](https://img.shields.io/badge/Programmers-202B3D?style=flat-square)](https://school.programmers.co.kr/)
[![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/FickleBoBo/)
[![Codeforces](https://img.shields.io/badge/Codeforces-1F8ACB?style=flat-square&logo=codeforces&logoColor=white)](https://codeforces.com/profile/FickleBoBo)
[![SWEA](https://img.shields.io/badge/SWEA-386BC4?style=flat-square)](https://swexpertacademy.com/)
![Softeer](https://img.shields.io/badge/Softeer-002C5E?style=flat-square)
[![Blog](https://img.shields.io/badge/Blog-ficklebobo.dev-1F8ACB?style=flat-square)](https://ficklebobo.dev)

</div>

---

## 🧠 Goal

- 겸손하게 정진하자
- 최선의 해결책을 찾아나가자
- 블로그에 문제 풀이를 정리하자

## 📊 Stats

<div align="center">

<a href="https://solved.ac/qwera1997/"><img src="https://mazassumnida.wtf/api/v2/generate_badge?boj=qwera1997" width="400" alt="Solved.ac Profile"></a>

<a href="https://leetcode.com/FickleBoBo/"><img src="https://leetcard.jacoblin.cool/FickleBoBo?theme=dark&amp;font=Nunito&amp;ext=heatmap" width="400" alt="LeetCode"></a>

<a href="https://codeforces.com/profile/FickleBoBo"><img src="https://codeforces-readme-stats.vercel.app/api/card?username=FickleBoBo" width="400" alt="Codeforces"></a>

</div>

## 📁 Structure

```
{year}-{month}/
└── src/
    └── day_XX/                  # XX = 그 달의 일자 (문제 푼 날)
        └── {출처}_{문제번호}/
            └── Main.* / Solution.*
```

예시 — `2026-10/src/day_01/`

```
├── prms_42628/Solution.{java,cpp,py}
├── leet_1143/Solution.{java,cpp,py}
└── cofo_2130b/Main.cpp
```

| 접두사     | 출처                                   | 파일                                            |
| ---------- | -------------------------------------- | ----------------------------------------------- |
| `boj_`     | BOJ                                    | `Main.{java,cpp}`                               |
| `prms_`    | Programmers                            | `Solution.{java,cpp,py}` (SQL은 `Solution.sql`) |
| `leet_`    | LeetCode                               | `Solution.{java,cpp,py}`                        |
| `cofo_`    | Codeforces 문제 풀이                   | `Main.cpp`                                      |
| `live_`    | 대회 실전 풀이 (종료 시점 그대로 보존) | `Main.cpp`                                      |
| `swea_`    | SWEA                                   | `Solution.java`                                 |
| `softeer_` | Softeer                                | `Main.java`                                     |

같은 문제의 다른 접근은 `Main2`/`Solution2` … 처럼 숫자를 붙이고, 실패한 시도는 폴더명 끝에 `_fail`을 붙인다. 이미지는 풀이 폴더의 `assets/photoN.*`에 둔다.

## 🛠️ Skills

이 레포의 반복 작업은 Claude Code 스킬로 자동화해 뒀다. (`.claude/skills/`)

| 스킬             | 역할                                                                                                     |
| ---------------- | -------------------------------------------------------------------------------------------------------- |
| `ps-new-month`   | 새 달이 시작되면 `{year}-{month}/` 모듈 폴더와 `.iml`을 만들고 IDE 모듈에 등록, 세팅 커밋까지            |
| `ps-new-problem` | 열려 있는 Chrome 탭의 문제 URL(Programmers·LeetCode·Codeforces)로 `day_XX/` 폴더와 언어별 시작 코드 생성 |
| `ps-audit`       | 날짜별(`day_XX`) 풀이를 `CONVENTIONS.md` 기준으로 점검 — 정답성·복잡도·네이밍·관용구, 🔴🟡🟢 등급        |

## 📖 Conventions

풀이 스타일(네이밍, 언어별 관용구, 채점기 baseline)은 [`CONVENTIONS.md`](CONVENTIONS.md)에 정리한다.

---
