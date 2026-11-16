# 로드맵

강의: 버블 게임으로 배우는 자바 Swing 게임 만들기
목표: 키보드로 움직이고 물방울로 적을 가두는 2D 게임을 처음부터 만든다
대상: 자바 문법 기초를 아는 학생
결과물: 이동, 점프, 물방울 공격, 적군, 배경음악, 게임오버가 되는 Swing 게임
참고: https://github.com/codingspecialist/java-bubble-game-v2

## 선수 지식

- 자바: 클래스, 상속, 인터페이스, enum, 컬렉션(List)
- 자바: 람다, 패키지, switch

## 학습 목표

- Swing 창, JLabel과 ImageIcon으로 그림 놓기
- 키 이벤트와 KeyAdapter
- 게임 루프(Timer) 하나로 모든 물체 움직이기
- Rectangle로 발판, 벽, 물체끼리 충돌 확인하기
- 리스트로 여러 물체 관리하고 지우기
- 상속으로 겹치는 코드 합치기
- Lombok으로 getter, setter 줄이기
- Clip으로 소리 재생

## 진행 방식

- 진도 코드는 bubble.game 패키지에서 쌓는다. 따라치기는 이 코드다
- 장이 끝나면 그 장까지의 코드를 bubble.ex01 같은 패키지에 따로 남긴다. 장마다 따로 실행해 본다

## 참고와 달라진 점

- 움직임마다 스레드를 만들지 않는다. Timer 게임 루프 하나가 매 틱 모든 물체를 갱신한다
- 숨은 색깔 지도 대신 Rectangle 목록으로 벽과 발판을 확인한다. 같은 목록으로 벽돌도 그린다
- PlayerWay, EnemyWay를 Direction 하나로 합친다
- Player, Enemy, Bubble의 겹치는 코드를 부모 클래스 Sprite로 합친다

## 장

| 번호 | 장 ID | 이름 | 종류 | 배울 것 | 상태 |
|---|---|---|---|---|---|
| 1 | project-setup | 프로젝트 뼈대 | 기능 | 폴더 구조, 이클립스, Lombok, 그림과 소리 파일 | 완료 |
| 2 | game-window | 게임 창과 배경 | 기능 | JFrame, 절대 배치, JLabel 배경 | 완료 |
| 3 | player | 플레이어 놓기 | 기능 | JLabel 상속, ImageIcon | 완료 |
| 4 | player-move | 좌우 이동 | 기능 | KeyAdapter, Timer 게임 루프, Direction enum, Lombok | 완료 |
| 5 | wall-stop | 벽에서 멈추기 | 기능 | 벽돌 그리기, 이동 뒤 좌표 확인 | 완료 |
| 6 | floor-gravity | 발판과 중력 | 기능 | Rectangle 목록, 중력, 착지 | 완료 |
| 7 | player-jump | 점프 | 기능 | 위로 향하는 속도, 발판 아래에서 올라타기 | 완료 |
| 8 | bubble-shoot | 물방울 쏘기 | 기능 | 리스트로 여러 물체 갱신 | 완료 |
| 9 | bubble-pop | 물방울 사라지기 | 기능 | remove와 repaint, removeIf | 완료 |
| 10 | enemy | 적군 만들기 | 기능 | 혼자 걷는 물체, 벽에서 돌아서기 | 완료 |
| 11 | sprite-refactor | 공통 부모 Sprite | 리팩터 | 상속으로 겹치는 코드 합치기, protected | 완료 |
| 12 | enemy-trap | 적군 가두기 | 기능 | Rectangle intersects, 상태 바꾸기 | 완료 |
| 13 | enemy-pop | 갇힌 적군 터트리기 | 기능 | 리스트에서 적군 지우기, 클리어, 화면 맨 앞에 놓기 | 완료 |
| 14 | bgm | 배경음악 | 기능 | Clip으로 wav 반복 재생 | 진행 중 |
| 15 | game-over | 게임오버 | 기능 | 게임 루프 멈추기, 소리 한 번 재생 | 대기 |

## 미룬 것

- 점수
- 갇힌 적군이 떠오르거나 시간이 지나 풀려나기
- 스테이지 여러 개

## 하지 않는 것

- 행동 테스트(JUnit). 검증은 컴파일과 창 사진으로 한다
- 게임 엔진과 외부 그래픽 라이브러리
- 네트워크, 저장
