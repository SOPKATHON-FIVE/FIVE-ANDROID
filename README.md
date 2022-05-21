# FIVE-ANDROID
오조오조오조오조오조오조오조오조오조오조


# 서비스이름

소개멘트

## Default Branch

develop branch

## 개발 담당 부분

| 이름 | 담당|
| --- | --- |
| 문다빈 | 마이페이지, 서버연결 |
| 박현정 | 홈 뷰, 상세뷰 |
| 우진실 | 일상 작성 |
|  |  |

## Code Convention
[안드로이드 코딩 컨벤션](https://github.com/SOPKATHON-FIVE/FIVE-ANDROID/wiki/Android-Coding-Convention)

## Branch Strategy
### Git Flow

기본적으로 Git Flow 전략을 이용한다. 작업 시작 시 선행되어야 할 작업은 다음과 같다.

```
1. Issue를 생성한다.
2. feature Branch를 생성한다.
3. Add - Commit - Push - Pull Request 의 과정을 거친다.
4. Pull Request가 작성되면 작성자 이외의 다른 팀원이 Code Review를 한다.
5. Code Review가 완료되면 Pull Request 작성자가 develop Branch로 merge 한다.
6. merge된 작업이 있을 경우, 다른 브랜치에서 작업을 진행 중이던 개발자는 본인의 브랜치로 merge된 작업을 Pull 받아온다.
7. 종료된 Issue와 Pull Request의 Label과 Project를 관리한다.
```
