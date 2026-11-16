# bubble-shoot 코드 요약

## T1 스페이스로 물방울 만들기
커밋: 0838deb

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Bubble.java | 새로 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Player.java | 고침 |

```java
// bubble/src/bubble/game/Bubble.java
package bubble.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	private int x;
	private int y;
	private Direction direction;

	public Bubble(Player player) {
		x = player.getX();
		y = player.getY();
		direction = player.getDirection();
		setIcon(new ImageIcon("image/bubble.png"));
		setSize(50, 50);
		setLocation(x, y);
	}
}
```

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -49,6 +49,7 @@ public class BubbleFrame extends JFrame {
 				case KeyEvent.VK_LEFT -> player.setLeft(true);
 				case KeyEvent.VK_RIGHT -> player.setRight(true);
 				case KeyEvent.VK_UP -> player.jump();
+				case KeyEvent.VK_SPACE -> shoot();
 				}
 			}
 
@@ -73,6 +74,11 @@ public class BubbleFrame extends JFrame {
 		setVisible(true);
 	}
 
+	private void shoot() {
+		Bubble bubble = new Bubble(player);
+		add(bubble);
+	}
+
 	private void addBrick(int x, int y) {
 		JLabel brick = new JLabel(brickIcon);
 		brick.setBounds(x, y, 40, 20);
```

```diff
// bubble/src/bubble/game/Player.java
@@ -6,6 +6,7 @@ import java.util.List;
 import javax.swing.ImageIcon;
 import javax.swing.JLabel;
 
+import lombok.Getter;
 import lombok.Setter;
 
 public class Player extends JLabel {
@@ -22,6 +23,7 @@ public class Player extends JLabel {
 	private boolean left;
 	@Setter
 	private boolean right;
+	@Getter
 	private Direction direction;
 	private ImageIcon playerR;
 	private ImageIcon playerL;
```

## T2 물방울 목록을 루프에서 움직이기
커밋: 306ffa0

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Bubble.java | 고침 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/Bubble.java
@@ -1,20 +1,44 @@
-package bubble.game;
-
-import javax.swing.ImageIcon;
-import javax.swing.JLabel;
-
-public class Bubble extends JLabel {
-
-	private int x;
-	private int y;
-	private Direction direction;
-
-	public Bubble(Player player) {
-		x = player.getX();
-		y = player.getY();
-		direction = player.getDirection();
-		setIcon(new ImageIcon("image/bubble.png"));
-		setSize(50, 50);
-		setLocation(x, y);
-	}
-}
+package bubble.game;
+
+import javax.swing.ImageIcon;
+import javax.swing.JLabel;
+
+public class Bubble extends JLabel {
+
+	private static final int SPEED = 6;
+	private static final int RANGE = 300;
+
+	private int x;
+	private int y;
+	private Direction direction;
+	private int distance;
+
+	public Bubble(Player player) {
+		x = player.getX();
+		y = player.getY();
+		direction = player.getDirection();
+		setIcon(new ImageIcon("image/bubble.png"));
+		setSize(50, 50);
+		setLocation(x, y);
+	}
+
+	public void move() {
+		if (distance < RANGE) {
+			if (direction == Direction.LEFT) {
+				x -= SPEED;
+			} else {
+				x += SPEED;
+			}
+			distance += SPEED;
+		} else if (y > 20) {
+			y -= 2;
+		}
+		if (x < 40) {
+			x = 40;
+		}
+		if (x > 910) {
+			x = 910;
+		}
+		setLocation(x, y);
+	}
+}
```

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -16,6 +16,7 @@ public class BubbleFrame extends JFrame {
 	private Player player;
 	private ImageIcon brickIcon = new ImageIcon("image/brick.png");
 	private List<Rectangle> floors = new ArrayList<>();
+	private List<Bubble> bubbles = new ArrayList<>();
 
 	public BubbleFrame() {
 		setTitle("버블 게임");
@@ -62,10 +63,7 @@ public class BubbleFrame extends JFrame {
 			}
 		});
 
-		new Timer(16, e -> {
-			player.move();
-			player.fall(floors);
-		}).start();
+		new Timer(16, e -> tick()).start();
 
 		pack();
 		setResizable(false);
@@ -74,8 +72,17 @@ public class BubbleFrame extends JFrame {
 		setVisible(true);
 	}
 
+	private void tick() {
+		player.move();
+		player.fall(floors);
+		for (Bubble bubble : bubbles) {
+			bubble.move();
+		}
+	}
+
 	private void shoot() {
 		Bubble bubble = new Bubble(player);
+		bubbles.add(bubble);
 		add(bubble);
 	}
 
```

## T3 장 끝 코드를 ex08로 남기기
커밋: 971a09e

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex08/ | 복사 4개 |
