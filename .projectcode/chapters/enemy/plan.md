# enemy 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Enemy.java | 새로 | 적군 그림, 걷기, 돌아서기, 떨어지기 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 적군 목록을 만들고 루프에서 움직인다 |
| bubble/src/bubble/ex10/ | 새로 | 장 끝 코드 |

## 코드 계획
Enemy.java
- JLabel을 상속한다. 생성자가 x, y, direction을 받는다. 적군마다 자리가 달라서다
- enemyR, enemyL 그림을 읽고 direction에 맞는 그림을 setIcon 한다
- SPEED는 2, GRAVITY는 1이다
- move는 direction대로 x를 바꾸고, 40보다 작으면 40으로 맞추고 RIGHT로, 910보다 크면 910으로 맞추고 LEFT로 돌아선다. 그림도 바꾼다
- fall은 Player의 fall과 같다. 겹침은 sprite-refactor 장에서 합친다

BubbleFrame.java
- enemies 칸에 Enemy 목록을 둔다
- 적군 (500, 570, LEFT), (880, 570, LEFT), (700, 440, LEFT)을 만들어 목록에 넣고 add 한다
- tick에서 for 문으로 적군마다 move, fall(floors)를 부른다

## 핵심 코드
public void move() {
	if (direction == Direction.LEFT) {
		x -= SPEED;
	} else {
		x += SPEED;
	}
	if (x < 40) {
		x = 40;
		direction = Direction.RIGHT;
	}
	...
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Enemy.java, BubbleFrame.java |
| S2 | Enemy.java, BubbleFrame.java |
| S3 | Enemy.java |
| S4 | Enemy.java, BubbleFrame.java |
| S5 | ex10 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
