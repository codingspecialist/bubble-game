# floor-gravity 작업

- [ ] T1 발판 목록을 벽돌로 그리기
  - 근거: S1
  - 파일: bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 바닥과 발판 다섯 개가 벽돌로 보인다
  - Why: 착지를 확인할 발판 목록을 먼저 만들고 같은 목록으로 그린다
- [ ] T2 중력으로 떨어져 발판에 서기
  - 근거: S2, S3, S4
  - 파일: bubble/src/bubble/game/Player.java, bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 펭귄이 왼쪽 위에서 떨어져 발판에 서고, 오른쪽으로 걸어 나가면 아래 발판으로 떨어진다
  - Why: 매 틱 속도를 더하면 떨어질수록 빨라지고, 발판을 지나치기 전에 세워야 한다
- [ ] T3 장 끝 코드를 ex06으로 남기기
  - 근거: S5
  - 파일: bubble/src/bubble/ex06
  - 실행하면: bubble.ex06.BubbleFrame도 펭귄이 떨어져 발판에 선다
  - Why: 장마다 끝난 코드를 따로 실행해 볼 수 있게 남긴다
- [ ] 수렴 점검
- [ ] 캡처
- [ ] 도식
