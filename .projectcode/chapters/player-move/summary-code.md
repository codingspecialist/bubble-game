# player-move 코드 요약

## T1 키를 누를 때마다 움직이기
커밋: ccf858e

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Player.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -1,29 +1,42 @@
-package bubble.game;
-
-import javax.swing.ImageIcon;
-import javax.swing.JFrame;
-import javax.swing.JLabel;
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
+
+public class BubbleFrame extends JFrame {
+
+	private Player player;
+
+	public BubbleFrame() {
+		setTitle("버블 게임");
+		setContentPane(new JLabel(new ImageIcon("image/background.png")));
+		setLayout(null);
+
+		player = new Player();
+		add(player);
+
+		addKeyListener(new KeyAdapter() {
+			@Override
+			public void keyPressed(KeyEvent e) {
+				switch (e.getKeyCode()) {
+				case KeyEvent.VK_LEFT -> player.moveLeft();
+				case KeyEvent.VK_RIGHT -> player.moveRight();
+				}
+			}
+		});
+
+		pack();
+		setResizable(false);
+		setLocationRelativeTo(null);
+		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
+		setVisible(true);
+	}
+
+	public static void main(String[] args) {
+		new BubbleFrame();
+	}
+}
```

```diff
// bubble/src/bubble/game/Player.java
@@ -1,20 +1,30 @@
-package bubble.game;
-
-import javax.swing.ImageIcon;
-import javax.swing.JLabel;
-
-public class Player extends JLabel {
-
-	private int x;
-	private int y;
-	private ImageIcon playerR;
-
-	public Player() {
-		playerR = new ImageIcon("image/playerR.png");
-		x = 80;
-		y = 570;
-		setIcon(playerR);
-		setSize(50, 50);
-		setLocation(x, y);
-	}
-}
+package bubble.game;
+
+import javax.swing.ImageIcon;
+import javax.swing.JLabel;
+
+public class Player extends JLabel {
+
+	private int x;
+	private int y;
+	private ImageIcon playerR;
+
+	public Player() {
+		playerR = new ImageIcon("image/playerR.png");
+		x = 80;
+		y = 570;
+		setIcon(playerR);
+		setSize(50, 50);
+		setLocation(x, y);
+	}
+
+	public void moveLeft() {
+		x -= 10;
+		setLocation(x, y);
+	}
+
+	public void moveRight() {
+		x += 10;
+		setLocation(x, y);
+	}
+}
```

## T2 게임 루프로 부드럽게 움직이기
커밋: d75e873

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Player.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -1,42 +1,53 @@
-package bubble.game;
-
-import java.awt.event.KeyAdapter;
-import java.awt.event.KeyEvent;
-
-import javax.swing.ImageIcon;
-import javax.swing.JFrame;
-import javax.swing.JLabel;
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
-				case KeyEvent.VK_LEFT -> player.moveLeft();
-				case KeyEvent.VK_RIGHT -> player.moveRight();
-				}
-			}
-		});
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
+
+	public BubbleFrame() {
+		setTitle("버블 게임");
+		setContentPane(new JLabel(new ImageIcon("image/background.png")));
+		setLayout(null);
+
+		player = new Player();
+		add(player);
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
+	public static void main(String[] args) {
+		new BubbleFrame();
+	}
+}
```

```diff
// bubble/src/bubble/game/Player.java
@@ -1,30 +1,38 @@
-package bubble.game;
-
-import javax.swing.ImageIcon;
-import javax.swing.JLabel;
-
-public class Player extends JLabel {
-
-	private int x;
-	private int y;
-	private ImageIcon playerR;
-
-	public Player() {
-		playerR = new ImageIcon("image/playerR.png");
-		x = 80;
-		y = 570;
-		setIcon(playerR);
-		setSize(50, 50);
-		setLocation(x, y);
-	}
-
-	public void moveLeft() {
-		x -= 10;
-		setLocation(x, y);
-	}
-
-	public void moveRight() {
-		x += 10;
-		setLocation(x, y);
-	}
-}
+package bubble.game;
+
+import javax.swing.ImageIcon;
+import javax.swing.JLabel;
+
+import lombok.Setter;
+
+public class Player extends JLabel {
+
+	private static final int SPEED = 4;
+
+	private int x;
+	private int y;
+	@Setter
+	private boolean left;
+	@Setter
+	private boolean right;
+	private ImageIcon playerR;
+
+	public Player() {
+		playerR = new ImageIcon("image/playerR.png");
+		x = 80;
+		y = 570;
+		setIcon(playerR);
+		setSize(50, 50);
+		setLocation(x, y);
+	}
+
+	public void move() {
+		if (left) {
+			x -= SPEED;
+		}
+		if (right) {
+			x += SPEED;
+		}
+		setLocation(x, y);
+	}
+}
```

## T3 움직이는 쪽 바라보기
커밋: 86b1c36

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Direction.java | 새로 |
| bubble/src/bubble/game/Player.java | 고침 |

```java
// bubble/src/bubble/game/Direction.java
package bubble.game;

public enum Direction {
	LEFT, RIGHT
}
```

```diff
// bubble/src/bubble/game/Player.java
@@ -1,38 +1,49 @@
-package bubble.game;
-
-import javax.swing.ImageIcon;
-import javax.swing.JLabel;
-
-import lombok.Setter;
-
-public class Player extends JLabel {
-
-	private static final int SPEED = 4;
-
-	private int x;
-	private int y;
-	@Setter
-	private boolean left;
-	@Setter
-	private boolean right;
-	private ImageIcon playerR;
-
-	public Player() {
-		playerR = new ImageIcon("image/playerR.png");
-		x = 80;
-		y = 570;
-		setIcon(playerR);
-		setSize(50, 50);
-		setLocation(x, y);
-	}
-
-	public void move() {
-		if (left) {
-			x -= SPEED;
-		}
-		if (right) {
-			x += SPEED;
-		}
-		setLocation(x, y);
-	}
-}
+package bubble.game;
+
+import javax.swing.ImageIcon;
+import javax.swing.JLabel;
+
+import lombok.Setter;
+
+public class Player extends JLabel {
+
+	private static final int SPEED = 4;
+
+	private int x;
+	private int y;
+	@Setter
+	private boolean left;
+	@Setter
+	private boolean right;
+	private Direction direction;
+	private ImageIcon playerR;
+	private ImageIcon playerL;
+
+	public Player() {
+		playerR = new ImageIcon("image/playerR.png");
+		playerL = new ImageIcon("image/playerL.png");
+		x = 80;
+		y = 570;
+		direction = Direction.RIGHT;
+		setIcon(playerR);
+		setSize(50, 50);
+		setLocation(x, y);
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
+		if (direction == Direction.LEFT) {
+			setIcon(playerL);
+		} else {
+			setIcon(playerR);
+		}
+		setLocation(x, y);
+	}
+}
```

## T4 장 끝 코드를 ex04로 남기기
커밋: f97d047

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex04/ | 복사 3개 |
