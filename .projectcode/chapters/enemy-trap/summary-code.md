# enemy-trap 코드 요약

## T1 물방울에 닿은 적군 가두기
커밋: 121078b

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Bubble.java | 고침 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Enemy.java | 고침 |

```diff
// bubble/src/bubble/game/Bubble.java
@@ -38,4 +38,8 @@ public class Bubble extends Sprite {
 		keepInWall();
 		setLocation(x, y);
 	}
+
+	public void pop() {
+		popped = true;
+	}
 }
```

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -89,6 +89,13 @@ public class BubbleFrame extends JFrame {
 		}
 		for (Bubble bubble : bubbles) {
 			bubble.move();
+			for (Enemy enemy : enemies) {
+				boolean hit = bubble.getBounds().intersects(enemy.getBounds());
+				if (hit && !bubble.isPopped() && !enemy.isBubbled()) {
+					enemy.trap();
+					bubble.pop();
+				}
+			}
 			if (bubble.isPopped()) {
 				remove(bubble);
 			}
```

```diff
// bubble/src/bubble/game/Enemy.java
@@ -1,43 +1,57 @@
-package bubble.game;
-
-import javax.swing.ImageIcon;
-
-public class Enemy extends Sprite {
-
-	private static final int SPEED = 2;
-
-	private ImageIcon enemyR;
-	private ImageIcon enemyL;
-
-	public Enemy(int x, int y, Direction direction) {
-		super(x, y, direction);
-		enemyR = new ImageIcon("image/enemyR.png");
-		enemyL = new ImageIcon("image/enemyL.png");
-		if (direction == Direction.LEFT) {
-			setIcon(enemyL);
-		} else {
-			setIcon(enemyR);
-		}
-	}
-
-	public void move() {
-		if (direction == Direction.LEFT) {
-			x -= SPEED;
-		} else {
-			x += SPEED;
-		}
-		if (x < 40) {
-			direction = Direction.RIGHT;
-		}
-		if (x > 910) {
-			direction = Direction.LEFT;
-		}
-		keepInWall();
-		if (direction == Direction.LEFT) {
-			setIcon(enemyL);
-		} else {
-			setIcon(enemyR);
-		}
-		setLocation(x, y);
-	}
-}
+package bubble.game;
+
+import javax.swing.ImageIcon;
+
+import lombok.Getter;
+
+public class Enemy extends Sprite {
+
+	private static final int SPEED = 2;
+
+	private ImageIcon enemyR;
+	private ImageIcon enemyL;
+	private ImageIcon enemyBubbled;
+	@Getter
+	private boolean bubbled;
+
+	public Enemy(int x, int y, Direction direction) {
+		super(x, y, direction);
+		enemyR = new ImageIcon("image/enemyR.png");
+		enemyL = new ImageIcon("image/enemyL.png");
+		enemyBubbled = new ImageIcon("image/enemyBubbled.png");
+		if (direction == Direction.LEFT) {
+			setIcon(enemyL);
+		} else {
+			setIcon(enemyR);
+		}
+	}
+
+	public void move() {
+		if (direction == Direction.LEFT) {
+			x -= SPEED;
+		} else {
+			x += SPEED;
+		}
+		if (x < 40) {
+			direction = Direction.RIGHT;
+		}
+		if (x > 910) {
+			direction = Direction.LEFT;
+		}
+		keepInWall();
+		if (direction == Direction.LEFT) {
+			setIcon(enemyL);
+		} else {
+			setIcon(enemyR);
+		}
+		if (bubbled) {
+			setIcon(enemyBubbled);
+		}
+		setLocation(x, y);
+	}
+
+	public void trap() {
+		bubbled = true;
+		setIcon(enemyBubbled);
+	}
+}
```

## T2 갇힌 적군 멈추기
커밋: 23309b6

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -84,8 +84,10 @@ public class BubbleFrame extends JFrame {
 		player.move();
 		player.fall(floors);
 		for (Enemy enemy : enemies) {
-			enemy.move();
-			enemy.fall(floors);
+			if (!enemy.isBubbled()) {
+				enemy.move();
+				enemy.fall(floors);
+			}
 		}
 		for (Bubble bubble : bubbles) {
 			bubble.move();
```

## T3 장 끝 코드를 ex12로 남기기
커밋: e3f6794

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex12/ | 복사 6개 |
