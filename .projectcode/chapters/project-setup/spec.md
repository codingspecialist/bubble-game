# project-setup 프로젝트 뼈대

종류: 기능
배울 것: 폴더 구조, 이클립스, Lombok, 그림과 소리 파일

## 할 일
- S1 bubble 폴더를 이클립스 프로젝트로 연다
- S2 실행하면 콘솔에 게임 준비 글자가 나온다
- S3 Lombok을 라이브러리로 붙인다
- S4 게임에 쓸 그림과 소리 파일을 제자리에 둔다
- S5 장 끝 코드를 ex01 패키지에 남긴다

## 실행 결과
$ java -cp "bin;lib/lombok.jar" bubble.game.BubbleFrame
버블 게임 준비

## 흐름
실행 -> main -> 콘솔에 준비 글자

## 안 하는 것
- 게임 창: game-window 장
- 빌드 도구(Maven, Gradle): 안 만듦
