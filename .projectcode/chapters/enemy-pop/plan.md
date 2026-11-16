# enemy-pop 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Enemy.java | 고침 | 터짐 상태 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 갇힌 적군에 닿으면 지우고, 다 지우면 CLEAR!를 보인다 |
| bubble/src/bubble/ex13/ | 새로 | 장 끝 코드 |

## 코드 계획
Enemy.java
- popped 칸과 pop 메서드를 둔다. Bubble의 popped와 같은 모양이다

BubbleFrame.java
- T1에서 tick 끝에 적군 for 문을 하나 더 둔다
- player.getBounds().intersects(enemy.getBounds())이고 갇힌 적군이면 pop 하고 remove 한다
- for 문 뒤에 enemies.removeIf로 터진 적군을 뺀다. bubble-pop 장과 같은 순서다
- T2에서 clear 칸에 CLEAR! 그림 JLabel을 둔다. 가운데 (250, 258)에 500x124로 놓는다
- 처음에는 setVisible(false)로 숨기고 add(clear, 0)으로 맨 앞에 넣는다. 0번 자리가 가장 위에 그려진다
- tick에서 enemies.isEmpty()면 setVisible(true) 한다

## 핵심 코드
for (Enemy enemy : enemies) {
	boolean touch = player.getBounds().intersects(enemy.getBounds());
	if (touch && enemy.isBubbled()) {
		enemy.pop();
		remove(enemy);
	}
}
enemies.removeIf(enemy -> enemy.isPopped());

add(clear, 0);

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Enemy.java, BubbleFrame.java |
| S2 | BubbleFrame.java |
| S3 | BubbleFrame.java |
| S4 | BubbleFrame.java |
| S5 | ex13 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
