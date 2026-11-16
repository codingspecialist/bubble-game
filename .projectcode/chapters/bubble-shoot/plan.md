# bubble-shoot 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Bubble.java | 새로 | 물방울 그림, 날기, 뜨기 |
| bubble/src/bubble/game/Player.java | 고침 | direction에 @Getter를 붙인다 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 스페이스로 쏘고 루프에서 물방울 목록을 움직인다 |
| bubble/src/bubble/ex08/ | 새로 | 장 끝 코드 |

## 코드 계획
Bubble.java
- JLabel을 상속한다. 생성자가 Player를 받아 getX, getY, getDirection으로 처음 자리와 방향을 정한다
- SPEED는 6, RANGE는 300이다. distance에 날아간 거리를 더한다
- move는 distance가 RANGE보다 작으면 방향대로 옆으로 가고, 아니면 y가 20보다 클 때 2씩 위로 간다
- 이동 뒤 x를 40과 910 사이로 맞춘다. 벽 코드는 Player와 같다. 겹침은 sprite-refactor 장에서 합친다

Player.java
- direction 칸에 @Getter를 붙인다

BubbleFrame.java
- T1에서 shoot 메서드가 물방울을 만들어 add 한다. 아직 움직이지 않는다
- T2에서 bubbles 칸에 Bubble 목록을 두고 shoot이 목록에도 넣는다
- 루프에서 할 일이 늘어 tick 메서드로 뺀다. Timer는 e -> tick()을 부른다
- tick은 플레이어를 움직인 뒤 for 문으로 목록의 물방울을 모두 move 한다

## 핵심 코드
private void tick() {
	player.move();
	player.fall(floors);
	for (Bubble bubble : bubbles) {
		bubble.move();
	}
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Bubble.java, Player.java, BubbleFrame.java |
| S2 | Bubble.java, BubbleFrame.java |
| S3 | Bubble.java |
| S4 | Bubble.java |
| S5 | BubbleFrame.java |
| S6 | ex08 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
