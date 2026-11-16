# enemy 코드 요약

## T1 적군 셋 세우기
커밋: fde32c2

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Enemy.java | 새로 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -17,6 +17,7 @@ public class BubbleFrame extends JFrame {
 	private ImageIcon brickIcon = new ImageIcon("image/brick.png");
 	private List<Rectangle> floors = new ArrayList<>();
 	private List<Bubble> bubbles = new ArrayList<>();
+	private List<Enemy> enemies = new ArrayList<>();
 
 	public BubbleFrame() {
 		setTitle("버블 게임");
@@ -43,6 +44,13 @@ public class BubbleFrame extends JFrame {
 			}
 		}
 
+		enemies.add(new Enemy(500, 570, Direction.LEFT));
+		enemies.add(new Enemy(880, 570, Direction.LEFT));
+		enemies.add(new Enemy(700, 440, Direction.LEFT));
+		for (Enemy enemy : enemies) {
+			add(enemy);
+		}
+
 		addKeyListener(new KeyAdapter() {
 			@Override
 			public void keyPressed(KeyEvent e) {
```

```java
// bubble/src/bubble/game/Enemy.java
package bubble.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel {

	private int x;
	private int y;
	private Direction direction;
	private ImageIcon enemyR;
	private ImageIcon enemyL;

	public Enemy(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		enemyR = new ImageIcon("image/enemyR.png");
		enemyL = new ImageIcon("image/enemyL.png");
		if (direction == Direction.LEFT) {
			setIcon(enemyL);
		} else {
			setIcon(enemyR);
		}
		setSize(50, 50);
		setLocation(x, y);
	}
}
```

## T2 적군이 혼자 걷고 벽에서 돌아서기
커밋: 8e95ee5

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Enemy.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -83,6 +83,10 @@ public class BubbleFrame extends JFrame {
 	private void tick() {
 		player.move();
 		player.fall(floors);
+		for (Enemy enemy : enemies) {
+			enemy.move();
+			enemy.fall(floors);
+		}
 		for (Bubble bubble : bubbles) {
 			bubble.move();
 			if (bubble.isPopped()) {
```

```diff
// bubble/src/bubble/game/Enemy.java
@@ -1,12 +1,19 @@
 package bubble.game;
 
+import java.awt.Rectangle;
+import java.util.List;
+
 import javax.swing.ImageIcon;
 import javax.swing.JLabel;
 
 public class Enemy extends JLabel {
 
+	private static final int SPEED = 2;
+	private static final int GRAVITY = 1;
+
 	private int x;
 	private int y;
+	private int dy;
 	private Direction direction;
 	private ImageIcon enemyR;
 	private ImageIcon enemyL;
@@ -25,4 +32,41 @@ public class Enemy extends JLabel {
 		setSize(50, 50);
 		setLocation(x, y);
 	}
+
+	public void move() {
+		if (direction == Direction.LEFT) {
+			x -= SPEED;
+		} else {
+			x += SPEED;
+		}
+		if (x < 40) {
+			x = 40;
+			direction = Direction.RIGHT;
+		}
+		if (x > 910) {
+			x = 910;
+			direction = Direction.LEFT;
+		}
+		if (direction == Direction.LEFT) {
+			setIcon(enemyL);
+		} else {
+			setIcon(enemyR);
+		}
+		setLocation(x, y);
+	}
+
+	public void fall(List<Rectangle> floors) {
+		int bottom = y + 50;
+		dy += GRAVITY;
+		y += dy;
+		for (Rectangle floor : floors) {
+			boolean above = bottom <= floor.y && y + 50 >= floor.y;
+			boolean across = x + 50 > floor.x && x < floor.x + floor.width;
+			if (above && across) {
+				y = floor.y - 50;
+				dy = 0;
+			}
+		}
+		setLocation(x, y);
+	}
 }
```

## T3 장 끝 코드를 ex10으로 남기기
커밋: 574a1e9

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex10/ | 복사 5개 |
