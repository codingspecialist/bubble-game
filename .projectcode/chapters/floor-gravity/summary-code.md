# floor-gravity 코드 요약

## T1 발판 목록을 벽돌로 그리기
커밋: d9d8798

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -1,7 +1,10 @@
 package bubble.game;
 
+import java.awt.Rectangle;
 import java.awt.event.KeyAdapter;
 import java.awt.event.KeyEvent;
+import java.util.ArrayList;
+import java.util.List;
 
 import javax.swing.ImageIcon;
 import javax.swing.JFrame;
@@ -12,6 +15,7 @@ public class BubbleFrame extends JFrame {
 
 	private Player player;
 	private ImageIcon brickIcon = new ImageIcon("image/brick.png");
+	private List<Rectangle> floors = new ArrayList<>();
 
 	public BubbleFrame() {
 		setTitle("버블 게임");
@@ -26,6 +30,18 @@ public class BubbleFrame extends JFrame {
 			addBrick(960, y);
 		}
 
+		floors.add(new Rectangle(40, 620, 920, 20));
+		floors.add(new Rectangle(160, 490, 240, 20));
+		floors.add(new Rectangle(600, 490, 240, 20));
+		floors.add(new Rectangle(360, 360, 280, 20));
+		floors.add(new Rectangle(40, 230, 240, 20));
+		floors.add(new Rectangle(720, 230, 240, 20));
+		for (Rectangle floor : floors) {
+			for (int x = floor.x; x < floor.x + floor.width; x += 40) {
+				addBrick(x, floor.y);
+			}
+		}
+
 		addKeyListener(new KeyAdapter() {
 			@Override
 			public void keyPressed(KeyEvent e) {
```

## T2 중력으로 떨어져 발판에 서기
커밋: ccce0ac

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Player.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -60,7 +60,10 @@ public class BubbleFrame extends JFrame {
 			}
 		});
 
-		new Timer(16, e -> player.move()).start();
+		new Timer(16, e -> {
+			player.move();
+			player.fall(floors);
+		}).start();
 
 		pack();
 		setResizable(false);
```

```diff
// bubble/src/bubble/game/Player.java
@@ -1,5 +1,8 @@
 package bubble.game;
 
+import java.awt.Rectangle;
+import java.util.List;
+
 import javax.swing.ImageIcon;
 import javax.swing.JLabel;
 
@@ -8,9 +11,11 @@ import lombok.Setter;
 public class Player extends JLabel {
 
 	private static final int SPEED = 4;
+	private static final int GRAVITY = 1;
 
 	private int x;
 	private int y;
+	private int dy;
 	@Setter
 	private boolean left;
 	@Setter
@@ -23,7 +28,7 @@ public class Player extends JLabel {
 		playerR = new ImageIcon("image/playerR.png");
 		playerL = new ImageIcon("image/playerL.png");
 		x = 80;
-		y = 570;
+		y = 40;
 		direction = Direction.RIGHT;
 		setIcon(playerR);
 		setSize(50, 50);
@@ -52,4 +57,19 @@ public class Player extends JLabel {
 		}
 		setLocation(x, y);
 	}
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

## T3 장 끝 코드를 ex06으로 남기기
커밋: bba5018

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex06/ | 복사 3개 |
