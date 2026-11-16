# enemy-pop 작업

- [ ] T1 갇힌 적군에 닿으면 터트리기
  - 근거: S1, S2, S3
  - 파일: bubble/src/bubble/game/Enemy.java, bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 적군을 모두 가둔 뒤 펭귄이 걸어가 닿으면 적군이 모두 사라진다
  - Why: 물방울을 지운 방법 그대로 화면과 목록에서 적군을 지운다
- [ ] T2 적군을 다 터트리면 CLEAR! 보이기
  - 근거: S4
  - 파일: bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 마지막 적군이 사라지면 화면 가운데 맨 앞에 CLEAR!가 보인다
  - Why: 목록이 비었는지로 끝을 알고, 0번 자리에 넣어 벽돌보다 앞에 그린다
- [ ] T3 장 끝 코드를 ex13으로 남기기
  - 근거: S5
  - 파일: bubble/src/bubble/ex13
  - 실행하면: bubble.ex13.BubbleFrame도 적군을 다 터트리면 CLEAR!가 보인다
  - Why: 장마다 끝난 코드를 따로 실행해 볼 수 있게 남긴다
- [ ] 수렴 점검
- [ ] 캡처
- [ ] 도식
