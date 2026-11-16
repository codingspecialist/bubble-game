# wall-stop 코드 요약

## T1 양쪽 벽에 벽돌 쌓기
커밋: 95b3c19

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -1,53 +1,65 @@
-package bubble.game;
-
-import java.awt.event.KeyAdapter;
-import java.awt.event.KeyEvent;
-
-import javax.swing.ImageIcon;
-import javax.swing.JFrame;
-import javax.swing.JLabel;
-import javax.swing.Timer;
-
-public class BubbleFrame extends JFrame {
-
-	private Player player;
-
-	public BubbleFrame() {
-		setTitle("버블 게임");
-		setContentPane(new JLabel(new ImageIcon("image/background.png")));
-		setLayout(null);
-
-		player = new Player();
-		add(player);
-
-		addKeyListener(new KeyAdapter() {
-			@Override
-			public void keyPressed(KeyEvent e) {
-				switch (e.getKeyCode()) {
-				case KeyEvent.VK_LEFT -> player.setLeft(true);
-				case KeyEvent.VK_RIGHT -> player.setRight(true);
-				}
-			}
-
-			@Override
-			public void keyReleased(KeyEvent e) {
-				switch (e.getKeyCode()) {
-				case KeyEvent.VK_LEFT -> player.setLeft(false);
-				case KeyEvent.VK_RIGHT -> player.setRight(false);
-				}
-			}
-		});
-
-		new Timer(16, e -> player.move()).start();
-
-		pack();
-		setResizable(false);
-		setLocationRelativeTo(null);
-		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
-		setVisible(true);
-	}
-
-	public static void main(String[] args) {
-		new BubbleFrame();
-	}
-}
+package bubble.game;
+
+import java.awt.event.KeyAdapter;
+import java.awt.event.KeyEvent;
+
+import javax.swing.ImageIcon;
+import javax.swing.JFrame;
+import javax.swing.JLabel;
+import javax.swing.Timer;
+
+public class BubbleFrame extends JFrame {
+
+	private Player player;
+	private ImageIcon brickIcon = new ImageIcon("image/brick.png");
+
+	public BubbleFrame() {
+		setTitle("버블 게임");
+		setContentPane(new JLabel(new ImageIcon("image/background.png")));
+		setLayout(null);
+
+		player = new Player();
+		add(player);
+
+		for (int y = 0; y < 640; y += 20) {
+			addBrick(0, y);
+			addBrick(960, y);
+		}
+
+		addKeyListener(new KeyAdapter() {
+			@Override
+			public void keyPressed(KeyEvent e) {
+				switch (e.getKeyCode()) {
+				case KeyEvent.VK_LEFT -> player.setLeft(true);
+				case KeyEvent.VK_RIGHT -> player.setRight(true);
+				}
+			}
+
+			@Override
+			public void keyReleased(KeyEvent e) {
+				switch (e.getKeyCode()) {
+				case KeyEvent.VK_LEFT -> player.setLeft(false);
+				case KeyEvent.VK_RIGHT -> player.setRight(false);
+				}
+			}
+		});
+
+		new Timer(16, e -> player.move()).start();
+
+		pack();
+		setResizable(false);
+		setLocationRelativeTo(null);
+		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
+		setVisible(true);
+	}
+
+	private void addBrick(int x, int y) {
+		JLabel brick = new JLabel(brickIcon);
+		brick.setBounds(x, y, 40, 20);
+		add(brick);
+	}
+
+	public static void main(String[] args) {
+		new BubbleFrame();
+	}
+}
```

## T2 벽에서 멈추기
커밋: f85017b

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Player.java | 고침 |

```diff
// bubble/src/bubble/game/Player.java
@@ -39,6 +39,12 @@ public class Player extends JLabel {
 			x += SPEED;
 			direction = Direction.RIGHT;
 		}
+		if (x < 40) {
+			x = 40;
+		}
+		if (x > 910) {
+			x = 910;
+		}
 		if (direction == Direction.LEFT) {
 			setIcon(playerL);
 		} else {
```

## T3 장 끝 코드를 ex05로 남기기
커밋: 0ccc18c

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex05/ | 복사 3개 |
