# wall-stop 작업

- [ ] T1 양쪽 벽에 벽돌 쌓기
  - 근거: S1
  - 파일: bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 창 왼쪽과 오른쪽 끝에 벽돌 벽이 보이고, 펭귄은 아직 벽을 지나간다
  - Why: 벽이 보여야 어디서 멈춰야 하는지 눈으로 확인한다
- [ ] T2 벽에서 멈추기
  - 근거: S2
  - 파일: bubble/src/bubble/game/Player.java
  - 실행하면: 왼쪽 화살표를 계속 눌러도 펭귄이 왼쪽 벽 앞에서 멈춘다
  - Why: 움직인 뒤 좌표를 확인해 되돌리면 벽을 넘지 않는다
- [ ] T3 장 끝 코드를 ex05로 남기기
  - 근거: S3
  - 파일: bubble/src/bubble/ex05
  - 실행하면: bubble.ex05.BubbleFrame도 벽 앞에서 펭귄이 멈춘다
  - Why: 장마다 끝난 코드를 따로 실행해 볼 수 있게 남긴다
- [ ] 수렴 점검
- [ ] 캡처
- [ ] 도식
