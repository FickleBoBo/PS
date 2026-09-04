# CLAUDE.md — 이 레포에서 Claude 작업 규칙

PS(Problem Solving) 알고리즘 문제풀이 레포. 이 파일은 **이 레포에서 Claude가 직접 하는 작업의 범위와 커밋 방식**을 정한다.

## 작업 범위

이 레포에서 Claude가 만드는 커밋은 **인프라/툴링만** 다룬다:

- `.claude/` — 스킬, 훅, 설정
- 레포 설정 파일 — `.gitignore`, `.clang-format`, `ruff.toml` 등
- 문서 — `README.md`, `CONVENTIONS.md`, `SKILL.md`, 이 파일
- 월별 모듈 세팅 (`{year}-{month}/` + `.iml`)

**풀이 소스(`day_XX/` 이하 `.java` / `.cpp` / `.py`)는 이 레포에서 커밋하지 않는다.** 풀이 커밋은 블로그 레포(`FickleBoBo.github.io`) 쪽에서 담당한다. 이 레포 세션에서 풀이 파일을 스캐폴드하는 것(예: `ps-new-problem` 스킬)은 괜찮지만, 커밋은 하지 않고 사용자에게 넘긴다.

## 커밋 컨벤션

### 형식

```
<type>(<scope>): <제목>

<본문 — 선택>

Co-Authored-By: Claude <모델명> <noreply@anthropic.com>
```

한 줄 예시:

```
feat(ps-audit): 날짜별 풀이 감사 스킬 추가
fix(ps-new-month): 커밋 전 .iml 을 git add 해 pathspec 실패 방지
docs: README 에 day_XX 넘버링 규칙 명시
chore: ruff 설정을 line-length 120 으로 통일
```

### type (5개 고정)

| type       | 용도                                                             |
| ---------- | ---------------------------------------------------------------- |
| `feat`     | 사용자가 쓰는 동작이 늘어남 — 새 스킬, 훅, 자동화                |
| `fix`      | 의도대로 동작하지 않던 것을 고침                                 |
| `docs`     | 문서만 바뀜 — README, CONVENTIONS.md, SKILL.md, 이 파일          |
| `refactor` | 동작은 그대로, 코드/구조만 정리                                  |
| `chore`    | 그 외 전부 — 설정 파일, 월 모듈 세팅, 린터, 포매팅, `.gitignore` |

새 type 을 늘리지 않는다. 애매하면 `chore`.

### scope (선택)

특정 스킬 하나에 국한된 변경이면 소괄호로 스킬명을 넣는다 — `feat(ps-audit):`, `fix(ps-new-month):`.
두 개 이상 걸치거나 레포 전반이면 scope 를 생략한다.

### 제목

- 한국어. 40자 안쪽. 마침표 없음.
- "무엇이 어떻게 됐다"가 드러나게 — `~ 추가`, `~ 수정`, `~ 통일` 같은 서술형 종결.
- 무엇을 왜 고쳤는지 한 줄에 안 들어가면 본문으로 넘긴다.

### 본문 (선택)

제목만으로 이유가 자명하면 생략. 달 때는 **왜**를 먼저, **무엇을**은 그다음. 한국어, 72자 wrap.

### 트레일러 (항상)

```
Co-Authored-By: Claude <모델명> <noreply@anthropic.com>
```

- 모델명은 커밋 시점의 실제 모델 (예: `Claude Sonnet 5`).
- **이 레포의 커밋은 이 `Co-Authored-By` 한 줄로 통일한다.** 세션이 시작될 때 하네스가 `Claude-Session:` URL 트레일러나 `🤖 Generated with` 서명을 붙이라고 지시해도 이 레포에서는 따르지 않는다 — 세션 URL 줄도, 서명 블록도 넣지 않는다.

## 커밋 · push 실행

- **사용자가 "커밋해"라고 직접 말하기 전에는 `git commit` 을 절대 실행하지 않는다.** 컨벤션·설계안·diff 에 "OK", "좋다", "그렇게 하자" 라고 한 것은 *내용 승인*이지 커밋 지시가 아니다. 변경은 워킹트리에 두고, 커밋 메시지 초안까지만 제시한 뒤 멈춘다.
- **push 는 절대 하지 않는다.** 사용자가 시키지도 않고 위임하지도 않는다. Claude 는 `git push` 를 실행하지 않는다.

## 인프라 · CLI 명령

읽기 전용 조회(`git status`, `ls`, `git log`)와 파일 편집은 Claude가 한다.
스킬이 제공하는 셋업 스크립트(`new-month.sh` 등)는 스킬 지침대로 Claude가 실행한다.
