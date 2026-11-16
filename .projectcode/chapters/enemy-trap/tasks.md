# enemy-trap 작업

- [x] T1 물방울에 닿은 적군 가두기
  - 근거: S1, S2, S4
  - 파일: bubble/src/bubble/game/Enemy.java, bubble/src/bubble/game/Bubble.java, bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 물방울에 맞은 적군이 갇힌 그림으로 바뀌고 물방울은 사라진다. 갇힌 채로 아직 걷는다
  - Why: 두 그림의 Rectangle이 겹치는지로 맞았는지 알고, 상태 칸 하나로 적군을 바꾼다
- [x] T2 갇힌 적군 멈추기
  - 근거: S3
  - 파일: bubble/src/bubble/game/BubbleFrame.java
  - 실행하면: 갇힌 적군은 그 자리에 멈추고 다른 적군만 걷는다
  - Why: 상태에 따라 루프가 다르게 움직인다
- [x] T3 장 끝 코드를 ex12로 남기기
  - 근거: S5
  - 파일: bubble/src/bubble/ex12
  - 실행하면: bubble.ex12.BubbleFrame도 물방울로 적군을 가둔다
  - Why: 장마다 끝난 코드를 따로 실행해 볼 수 있게 남긴다
- [ ] 수렴 점검
- [ ] 캡처
- [ ] 도식
