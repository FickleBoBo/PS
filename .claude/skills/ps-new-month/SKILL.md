---
name: ps-new-month
description: PS 알고리즘 문제풀이 레포에서 새 달이 시작될 때 {year}-{month} 모듈 폴더, .iml 파일, .idea/modules.xml 등록, 커밋까지 세팅한다. "새 달 모듈 만들어줘", "이번 달 세팅해줘", "new month" 같은 요청에 사용.
---

# PS 새 달 모듈 세팅

파일 생성, modules.xml 등록, 커밋까지 `new-month.sh`가 전부 처리한다. 인자는 호출자(Claude)가 채운다.

## 실행

가장 흔한 형태(연월 생략, 모델명만 전달):

```
<이 스킬의 base directory>/new-month.sh "<현재 실행 중인 모델명, 예: Claude Sonnet 5>"
```

특정 달을 지정해야 하는 경우(둘 다 명시):

```
<이 스킬의 base directory>/new-month.sh <YYYY-MM> "<현재 실행 중인 모델명>"
```

- 인자가 1개면 모델명으로 취급하고 연월은 오늘 날짜로 정한다. 다른 달을 지정할 때만 인자 2개를 쓴다.
- 모델명은 지금 실행 중인 자기 자신의 실제 모델명("Claude " 접두사 포함)을 넣는다. 과거 기록 값을 베끼지 않는다. 모르면 인자 없이 호출해도 된다("Claude Code"로 대체).
- 해당 `{year}-{month}/`가 이미 있으면 스크립트가 아무것도 안 하고 exit 1 한다. 이미 존재한다고 보고하고 끝낸다.
- 스크립트가 하는 일 (3단계):
  1. `{year}-{month}/src/` 생성 → `{year}-{month}.iml` 생성 (다른 달과 **바이트 단위로 동일한** 템플릿, 파일 끝 개행 없음)
  2. `.idea/modules.xml`에 `<module>` 줄 등록 — 이미 등록돼 있으면 건너뜀(멱등)
  3. `git add` 후 `git commit -m "chore: {year}-{month} 모듈 세팅"`(co-author 트레일러 포함) — 경로를 `{year}-{month}/{year}-{month}.iml`로 못박아 `.iml` 하나만 담는다(인덱스에 있던 다른 staged 변경은 안 건드림)
- `.idea/modules.xml`은 `.gitignore` 대상이라(IDE 로컬 설정) 2단계 등록은 **로컬에만 반영되고 git 이력에는 안 남는다**.

## 실패 시

스크립트가 0이 아닌 코드로 종료하면 재시도 없이 stderr 메시지를 그대로 사용자에게 보고한다.

- **`git commit` 단계에서 실패한 경우**(pre-commit hook 거부 등)는 그 시점에 이미 디렉터리·`.iml` 생성, `.iml` staged, `modules.xml` 등록까지 끝난 상태로 남는다. 재시도하면 "already exists"로 막히므로, 재시도하지 말고 `git commit -- {year}-{month}/{year}-{month}.iml`을 직접 마무리하거나, 완전히 되돌리려면 디렉터리를 지우고(`git rm --cached` 포함) `.idea/modules.xml`의 등록 줄도 수동으로 제거해야 한다고 안내한다.
