# sprite-refactor 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Sprite.java | 새로 | 위치, 방향, 벽, 중력을 가진 부모 |
| bubble/src/bubble/game/Player.java | 고침 | Sprite를 상속하고 겹친 코드를 지운다 |
| bubble/src/bubble/game/Enemy.java | 고침 | Sprite를 상속하고 겹친 코드를 지운다 |
| bubble/src/bubble/game/Bubble.java | 고침 | Sprite를 상속하고 겹친 코드를 지운다 |
| bubble/src/bubble/ex11/ | 새로 | 장 끝 코드 |

## 코드 계획
Sprite.java
- JLabel을 상속한다
- x, y, dy, onGround, direction을 protected로 둔다. 자식이 바로 쓰고 밖에서는 못 바꾼다
- direction에 @Getter를 붙인다
- 생성자는 x, y, direction을 받아 저장하고 50x50 크기로 놓는다
- keepInWall은 x를 40과 910 사이로 맞춘다
- fall은 Player의 fall을 그대로 옮긴다. GRAVITY도 옮긴다

Player.java
- super(80, 40, Direction.RIGHT)를 부른다
- x, y, dy, onGround, direction, GRAVITY, fall을 지운다. 벽 확인은 keepInWall()로 바꾼다

Enemy.java
- super(x, y, direction)를 부른다
- 벽에 닿으면 방향만 바꾸고 x 맞추기는 keepInWall()에 맡긴다
- x, y, dy, direction, GRAVITY, fall을 지운다

Bubble.java
- super(player.getX(), player.getY(), player.getDirection())를 부른다
- x, y, direction을 지우고 벽 확인은 keepInWall()로 바꾼다

## 핵심 코드
public class Sprite extends JLabel {

	protected int x;
	protected int y;
	...
	protected void keepInWall() {
		if (x < 40) {
			x = 40;
		}
		if (x > 910) {
			x = 910;
		}
	}
}

public class Enemy extends Sprite {

	public Enemy(int x, int y, Direction direction) {
		super(x, y, direction);
	}
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Sprite.java, Player.java, Enemy.java, Bubble.java |
| S2 | Sprite.java, Player.java, Enemy.java, Bubble.java |
| S3 | Sprite.java, Player.java, Enemy.java |
| S4 | ex11 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
