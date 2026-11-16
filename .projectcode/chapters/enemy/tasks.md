# enemy 작업

- [ ] T1 적군 셋 세우기
  - 근거: S1
  - 파일: bubble/src/bubble/game/Enemy.java, bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 바닥에 적군 둘, 오른쪽 아래 발판에 적군 하나가 왼쪽을 보고 서 있다
  - Why: 적군도 플레이어처럼 그림 한 장이고, 여럿이라 목록에 담는다
- [ ] T2 적군이 혼자 걷고 벽에서 돌아서기
  - 근거: S2, S3, S4
  - 파일: bubble/src/bubble/game/Enemy.java, bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 적군들이 왼쪽으로 걷고, 발판의 적군은 끝에서 바닥으로 떨어지고, 왼쪽 벽에 닿은 적군은 오른쪽으로 돌아선다
  - Why: 키 대신 루프가 매 틱 적군을 움직이고, 벽 확인 자리에서 방향을 바꾼다
- [ ] T3 장 끝 코드를 ex10으로 남기기
  - 근거: S5
  - 파일: bubble/src/bubble/ex10
  - 실행하면: bubble.ex10.BubbleFrame도 적군이 혼자 걷는다
  - Why: 장마다 끝난 코드를 따로 실행해 볼 수 있게 남긴다
- [ ] 수렴 점검
- [ ] 캡처
- [ ] 도식
