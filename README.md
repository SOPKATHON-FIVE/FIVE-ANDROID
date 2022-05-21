# FIVE-ANDROID

## 💚 서비스이름

### 🔑 로그인유 LOG:IN U 🔑

```
 💡 서비스 한줄 소개 : 타인의 일상을 살아보는 서비스
```

## Default Branch

develop branch

## 개발 담당 부분

| 이름 | 담당|
| --- | --- |
| 문다빈 | MypageFragment xml 파일 | ViewApater 구현 | 리사이클러뷰 구현 | 서버연결 |
| 박현정 | HomeFragment 뷰 | Daily Adatper 구현 | 해야할 리스트 중첩 리사이클러뷰 구현 | Response data 생성| 서버 통신 연결|
| 우진실 | WriteActivity 구현 | 리스트 추가 구현 | 서버 통신 연결| 

### HomeFragment
다른 사람의 일상을 recyclerview로 보여준다. 데이터는 api 서버 연결을 통해 받아온 데이터를 연결한다.
## WriteActivity
공유할 나의 일상을 작성한다. 이때 일상 데이터는 3~5개로 제한하여 서버로 전달한다. 3개가 안된다면 화면이 넘어가지 않도록 설정한다.

## MyPageFragment
나의 일상과 내가 담은 일상을 viewpager로 나타낸다. 내가 좋아요 한 다른 사람들의 일상과 나의 일상을 리사이클러뷰에 보여준다.
이때 진행완료 버튼을 클릭시 다른 사람의 일상을 몇 퍼센트 살았는지에 대한 팝업창이 뜬다.
로그아웃 버튼 구현 


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

자세한 깃플로우 전략의 경우 [링크](https://github.com/8-seconds/WIKI_FOR_8_SECONDS/blob/main/GitHub/GitFlowAraboza.md)참조
## 레이아웃 구현
fragment_home, activity_write, fragment_my_page
<HomeActivity>
 <img width="369" alt="33" src="https://user-images.githubusercontent.com/81394850/169671736-4da142c0-7d05-4d69-905e-8443dc720cfc.png">


<WriteActivity>
<img width="369" alt="11" src="https://user-images.githubusercontent.com/81394850/169670258-b5bef2aa-384e-4626-9c8b-3677bad526b4.png">

<MyPageFragment>
 타인의 일상뷰
 <img width="369" alt="22" src="https://user-images.githubusercontent.com/81394850/169670348-0ce64379-7342-4b2e-8b12-f734e06795fc.png">
 
 
 나의 일상
 <img width="369" alt="10101010" src="https://user-images.githubusercontent.com/81394850/169671948-df687664-3051-4af3-b498-f7dc9b159857.png">


 로그아웃탭
 <img width="369" alt="555555" src="https://user-images.githubusercontent.com/81394850/169671899-2b712db8-d3a5-4447-9d6d-6930cde9b724.png">


