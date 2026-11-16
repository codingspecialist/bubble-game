# enemy-trap 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Enemy.java | 고침 | 갇힘 상태와 갇힌 그림 |
| bubble/src/bubble/game/Bubble.java | 고침 | pop으로 바로 터진다 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 물방울과 적군이 겹치는지 확인한다 |
| bubble/src/bubble/ex12/ | 새로 | 장 끝 코드 |

## 코드 계획
Enemy.java
- bubbled 칸에 갇혔는지 기억하고 @Getter를 붙인다
- enemyBubbled 그림을 읽어 둔다
- trap은 bubbled를 true로 하고 그림을 enemyBubbled로 바꾼다

Bubble.java
- pop은 popped를 true로 한다. 다음 틱 지우기는 bubble-pop 장의 코드가 한다

BubbleFrame.java
- T1에서 tick의 물방울 for 문 안에 적군 for 문을 둔다
- 물방울이 안 터졌고, 적군이 안 갇혔고, getBounds().intersects가 참이면 trap과 pop을 부른다
- getBounds는 JLabel이 가진 자리와 크기의 Rectangle이다
- T2에서 적군 for 문은 갇히지 않은 적군만 move와 fall을 부른다

## 핵심 코드
for (Enemy enemy : enemies) {
	boolean hit = bubble.getBounds().intersects(enemy.getBounds());
	if (hit && !bubble.isPopped() && !enemy.isBubbled()) {
		enemy.trap();
		bubble.pop();
	}
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Enemy.java, BubbleFrame.java |
| S2 | Bubble.java, BubbleFrame.java |
| S3 | BubbleFrame.java |
| S4 | BubbleFrame.java |
| S5 | ex12 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
