# sprite-refactor 공통 부모 Sprite

종류: 리팩터
배울 것: 상속으로 겹치는 코드 합치기, protected

## 할 일
- S1 Player, Enemy, Bubble이 함께 쓰는 위치, 방향, 크기 정하기를 부모 Sprite 한 곳에 둔다
- S2 벽 안쪽으로 맞추기를 Sprite 한 곳에 둔다
- S3 중력으로 떨어져 발판에 서기를 Sprite 한 곳에 둔다
- S4 장 끝 코드를 ex11 패키지에 남긴다

## 그대로인 것
- 플레이어, 적군, 물방울의 동작과 모습은 바뀌지 않는다
