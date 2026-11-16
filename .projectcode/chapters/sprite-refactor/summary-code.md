# sprite-refactor 코드 요약

## T1 Sprite를 만들고 Player가 물려받기
커밋: 1cd93e6

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Player.java | 고침 |
| bubble/src/bubble/game/Sprite.java | 새로 |

```diff
// bubble/src/bubble/game/Player.java
@@ -1,87 +1,49 @@
-package bubble.game;
-
-import java.awt.Rectangle;
-import java.util.List;
-
-import javax.swing.ImageIcon;
-import javax.swing.JLabel;
-
-import lombok.Getter;
-import lombok.Setter;
-
-public class Player extends JLabel {
-
-	private static final int SPEED = 4;
-	private static final int GRAVITY = 1;
-	private static final int JUMP = -18;
-
-	private int x;
-	private int y;
-	private int dy;
-	private boolean onGround;
-	@Setter
-	private boolean left;
-	@Setter
-	private boolean right;
-	@Getter
-	private Direction direction;
-	private ImageIcon playerR;
-	private ImageIcon playerL;
-
-	public Player() {
-		playerR = new ImageIcon("image/playerR.png");
-		playerL = new ImageIcon("image/playerL.png");
-		x = 80;
-		y = 40;
-		direction = Direction.RIGHT;
-		setIcon(playerR);
-		setSize(50, 50);
-		setLocation(x, y);
-	}
-
-	public void move() {
-		if (left) {
-			x -= SPEED;
-			direction = Direction.LEFT;
-		}
-		if (right) {
-			x += SPEED;
-			direction = Direction.RIGHT;
-		}
-		if (x < 40) {
-			x = 40;
-		}
-		if (x > 910) {
-			x = 910;
-		}
-		if (direction == Direction.LEFT) {
-			setIcon(playerL);
-		} else {
-			setIcon(playerR);
-		}
-		setLocation(x, y);
-	}
-
-	public void jump() {
-		if (onGround) {
-			dy = JUMP;
-		}
-	}
-
-	public void fall(List<Rectangle> floors) {
-		int bottom = y + 50;
-		dy += GRAVITY;
-		y += dy;
-		onGround = false;
-		for (Rectangle floor : floors) {
-			boolean above = bottom <= floor.y && y + 50 >= floor.y;
-			boolean across = x + 50 > floor.x && x < floor.x + floor.width;
-			if (above && across) {
-				y = floor.y - 50;
-				dy = 0;
-				onGround = true;
-			}
-		}
-		setLocation(x, y);
-	}
-}
+package bubble.game;
+
+import javax.swing.ImageIcon;
+
+import lombok.Setter;
+
+public class Player extends Sprite {
+
+	private static final int SPEED = 4;
+	private static final int JUMP = -18;
+
+	@Setter
+	private boolean left;
+	@Setter
+	private boolean right;
+	private ImageIcon playerR;
+	private ImageIcon playerL;
+
+	public Player() {
+		super(80, 40, Direction.RIGHT);
+		playerR = new ImageIcon("image/playerR.png");
+		playerL = new ImageIcon("image/playerL.png");
+		setIcon(playerR);
+	}
+
+	public void move() {
+		if (left) {
+			x -= SPEED;
+			direction = Direction.LEFT;
+		}
+		if (right) {
+			x += SPEED;
+			direction = Direction.RIGHT;
+		}
+		keepInWall();
+		if (direction == Direction.LEFT) {
+			setIcon(playerL);
+		} else {
+			setIcon(playerR);
+		}
+		setLocation(x, y);
+	}
+
+	public void jump() {
+		if (onGround) {
+			dy = JUMP;
+		}
+	}
+}
```

```java
// bubble/src/bubble/game/Sprite.java
package bubble.game;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JLabel;

import lombok.Getter;

public class Sprite extends JLabel {

	private static final int GRAVITY = 1;

	protected int x;
	protected int y;
	protected int dy;
	protected boolean onGround;
	@Getter
	protected Direction direction;

	public Sprite(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		setSize(50, 50);
		setLocation(x, y);
	}

	protected void keepInWall() {
		if (x < 40) {
			x = 40;
		}
		if (x > 910) {
			x = 910;
		}
	}

	public void fall(List<Rectangle> floors) {
		int bottom = y + 50;
		dy += GRAVITY;
		y += dy;
		onGround = false;
		for (Rectangle floor : floors) {
			boolean above = bottom <= floor.y && y + 50 >= floor.y;
			boolean across = x + 50 > floor.x && x < floor.x + floor.width;
			if (above && across) {
				y = floor.y - 50;
				dy = 0;
				onGround = true;
			}
		}
		setLocation(x, y);
	}
}
```

## T2 Enemy가 Sprite 물려받기
커밋: e89d7e2

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Enemy.java | 고침 |

```diff
// bubble/src/bubble/game/Enemy.java
@@ -1,27 +1,16 @@
 package bubble.game;
 
-import java.awt.Rectangle;
-import java.util.List;
-
 import javax.swing.ImageIcon;
-import javax.swing.JLabel;
 
-public class Enemy extends JLabel {
+public class Enemy extends Sprite {
 
 	private static final int SPEED = 2;
-	private static final int GRAVITY = 1;
 
-	private int x;
-	private int y;
-	private int dy;
-	private Direction direction;
 	private ImageIcon enemyR;
 	private ImageIcon enemyL;
 
 	public Enemy(int x, int y, Direction direction) {
-		this.x = x;
-		this.y = y;
-		this.direction = direction;
+		super(x, y, direction);
 		enemyR = new ImageIcon("image/enemyR.png");
 		enemyL = new ImageIcon("image/enemyL.png");
 		if (direction == Direction.LEFT) {
@@ -29,8 +18,6 @@ public class Enemy extends JLabel {
 		} else {
 			setIcon(enemyR);
 		}
-		setSize(50, 50);
-		setLocation(x, y);
 	}
 
 	public void move() {
@@ -40,13 +27,12 @@ public class Enemy extends JLabel {
 			x += SPEED;
 		}
 		if (x < 40) {
-			x = 40;
 			direction = Direction.RIGHT;
 		}
 		if (x > 910) {
-			x = 910;
 			direction = Direction.LEFT;
 		}
+		keepInWall();
 		if (direction == Direction.LEFT) {
 			setIcon(enemyL);
 		} else {
@@ -54,19 +40,4 @@ public class Enemy extends JLabel {
 		}
 		setLocation(x, y);
 	}
-
-	public void fall(List<Rectangle> floors) {
-		int bottom = y + 50;
-		dy += GRAVITY;
-		y += dy;
-		for (Rectangle floor : floors) {
-			boolean above = bottom <= floor.y && y + 50 >= floor.y;
-			boolean across = x + 50 > floor.x && x < floor.x + floor.width;
-			if (above && across) {
-				y = floor.y - 50;
-				dy = 0;
-			}
-		}
-		setLocation(x, y);
-	}
 }
```

## T3 Bubble이 Sprite 물려받기
커밋: 5641e27

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Bubble.java | 고침 |

```diff
// bubble/src/bubble/game/Bubble.java
@@ -1,31 +1,23 @@
 package bubble.game;
 
 import javax.swing.ImageIcon;
-import javax.swing.JLabel;
 
 import lombok.Getter;
 
-public class Bubble extends JLabel {
+public class Bubble extends Sprite {
 
 	private static final int SPEED = 6;
 	private static final int RANGE = 300;
 	private static final int LIFE = 150;
 
-	private int x;
-	private int y;
-	private Direction direction;
 	private int distance;
 	private int time;
 	@Getter
 	private boolean popped;
 
 	public Bubble(Player player) {
-		x = player.getX();
-		y = player.getY();
-		direction = player.getDirection();
+		super(player.getX(), player.getY(), player.getDirection());
 		setIcon(new ImageIcon("image/bubble.png"));
-		setSize(50, 50);
-		setLocation(x, y);
 	}
 
 	public void move() {
@@ -43,12 +35,7 @@ public class Bubble extends JLabel {
 		} else if (y > 20) {
 			y -= 2;
 		}
-		if (x < 40) {
-			x = 40;
-		}
-		if (x > 910) {
-			x = 910;
-		}
+		keepInWall();
 		setLocation(x, y);
 	}
 }
```

## T4 장 끝 코드를 ex11로 남기기
커밋: 5e295ab

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex11/ | 복사 6개 |
