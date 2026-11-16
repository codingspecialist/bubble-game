# 프로젝트 규칙

## 기술

| 항목 | 선택 |
|---|---|
| 언어 | Java 21 |
| 화면 | Swing |
| IDE | 이클립스. bubble에 .project와 .classpath를 넣는다 |
| 빌드 도구 | 없음. javac |
| 학생 코드 라이브러리 | Lombok 1.18.48 (bubble/lib/lombok.jar) |
| 테스트 | 없음. 컴파일과 창 사진으로 확인한다 |
| 그림 | codex CLI의 생성형 AI로 그리고 tools/make-images.py로 다듬는다 |
| 소리 | tools/make-sounds.py로 합성한 wav |

## 폴더

| 무엇 | 폴더 |
|---|---|
| 학생 코드 | bubble |
| 진도 코드 | bubble/src/bubble/game |
| 장 끝 코드 | bubble/src/bubble/ex01 ~ ex15. 장이 끝날 때 진도 코드를 복사한다 |
| 그림, 소리 | bubble/image, bubble/sound |
| 그림과 소리 만드는 도구 | tools. 학생에게 주지 않는다 |
| 컴파일 결과 | bubble/bin. git에 올리지 않는다 |

## 실행

- 명령은 모두 bubble 폴더에서 친다. 그림과 소리를 bubble 폴더 기준 경로로 읽는다
- 빌드: javac -encoding UTF-8 -d bin -cp lib/lombok.jar -processorpath lib/lombok.jar src/bubble/game/*.java
- 실행: java -cp "bin;lib/lombok.jar" bubble.game.BubbleFrame
- 장 끝 코드 실행: 두 명령의 game을 ex05처럼 바꾼다
- javac에 파일을 별표로 모두 넘긴다. 하나만 넘기면 Lombok이 함께 컴파일되는 파일을 처리하지 않는다

## 캡처

| 종류 | 주소나 명령 |
|---|---|
| window | 게임 창을 띄우고 키 이벤트를 보낸 뒤 창 내용을 PNG로 찍는다. projectcode-capture/WindowShot.java |
| run | 창이 없는 project-setup 장만. 실행 줄 |

## 이클립스

- bubble 폴더를 프로젝트로 연다
- lib/lombok.jar를 더블클릭해 이클립스에 설치한다
- BubbleFrame을 열고 Run을 누른다
