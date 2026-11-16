# game-over 코드 요약

## T1 적군에 닿으면 루프 멈추기
커밋: ef0bd1f

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Player.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -19,6 +19,7 @@ public class BubbleFrame extends JFrame {
 	private List<Bubble> bubbles = new ArrayList<>();
 	private List<Enemy> enemies = new ArrayList<>();
 	private JLabel clear;
+	private Timer timer;
 
 	public BubbleFrame() {
 		setTitle("버블 게임");
@@ -77,7 +78,8 @@ public class BubbleFrame extends JFrame {
 			}
 		});
 
-		new Timer(16, e -> tick()).start();
+		timer = new Timer(16, e -> tick());
+		timer.start();
 
 		Sound bgm = new Sound("sound/bgm.wav");
 		bgm.loop();
@@ -118,6 +120,10 @@ public class BubbleFrame extends JFrame {
 				enemy.pop();
 				remove(enemy);
 			}
+			if (touch && !enemy.isBubbled()) {
+				gameOver();
+				return;
+			}
 		}
 		enemies.removeIf(enemy -> enemy.isPopped());
 		if (enemies.isEmpty()) {
@@ -126,6 +132,11 @@ public class BubbleFrame extends JFrame {
 		repaint();
 	}
 
+	private void gameOver() {
+		timer.stop();
+		player.die();
+	}
+
 	private void shoot() {
 		Bubble bubble = new Bubble(player);
 		bubbles.add(bubble);
```

```diff
// bubble/src/bubble/game/Player.java
@@ -1,49 +1,55 @@
-package bubble.game;
-
-import javax.swing.ImageIcon;
-
-import lombok.Setter;
-
-public class Player extends Sprite {
-
-	private static final int SPEED = 4;
-	private static final int JUMP = -18;
-
-	@Setter
-	private boolean left;
-	@Setter
-	private boolean right;
-	private ImageIcon playerR;
-	private ImageIcon playerL;
-
-	public Player() {
-		super(80, 40, Direction.RIGHT);
-		playerR = new ImageIcon("image/playerR.png");
-		playerL = new ImageIcon("image/playerL.png");
-		setIcon(playerR);
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
-		keepInWall();
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
+	private ImageIcon playerDie;
+
+	public Player() {
+		super(80, 40, Direction.RIGHT);
+		playerR = new ImageIcon("image/playerR.png");
+		playerL = new ImageIcon("image/playerL.png");
+		playerDie = new ImageIcon("image/playerDie.png");
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
+
+	public void die() {
+		setIcon(playerDie);
+	}
+}
```

## T2 GAME OVER 맨 앞에 보이기
커밋: a161681

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -19,6 +19,7 @@ public class BubbleFrame extends JFrame {
 	private List<Bubble> bubbles = new ArrayList<>();
 	private List<Enemy> enemies = new ArrayList<>();
 	private JLabel clear;
+	private JLabel gameover;
 	private Timer timer;
 
 	public BubbleFrame() {
@@ -58,6 +59,11 @@ public class BubbleFrame extends JFrame {
 		clear.setVisible(false);
 		add(clear, 0);
 
+		gameover = new JLabel(new ImageIcon("image/gameover.png"));
+		gameover.setBounds(250, 279, 500, 82);
+		gameover.setVisible(false);
+		add(gameover, 0);
+
 		addKeyListener(new KeyAdapter() {
 			@Override
 			public void keyPressed(KeyEvent e) {
@@ -135,6 +141,7 @@ public class BubbleFrame extends JFrame {
 	private void gameOver() {
 		timer.stop();
 		player.die();
+		gameover.setVisible(true);
 	}
 
 	private void shoot() {
```

## T3 배경음악 끄고 게임오버 소리 내기
커밋: ce7585c

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Sound.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -21,6 +21,7 @@ public class BubbleFrame extends JFrame {
 	private JLabel clear;
 	private JLabel gameover;
 	private Timer timer;
+	private Sound bgm;
 
 	public BubbleFrame() {
 		setTitle("버블 게임");
@@ -87,7 +88,7 @@ public class BubbleFrame extends JFrame {
 		timer = new Timer(16, e -> tick());
 		timer.start();
 
-		Sound bgm = new Sound("sound/bgm.wav");
+		bgm = new Sound("sound/bgm.wav");
 		bgm.loop();
 
 		pack();
@@ -142,6 +143,8 @@ public class BubbleFrame extends JFrame {
 		timer.stop();
 		player.die();
 		gameover.setVisible(true);
+		bgm.stop();
+		new Sound("sound/gameover.wav").play();
 	}
 
 	private void shoot() {
```

```diff
// bubble/src/bubble/game/Sound.java
@@ -1,28 +1,40 @@
-package bubble.game;
-
-import java.io.File;
-
-import javax.sound.sampled.AudioInputStream;
-import javax.sound.sampled.AudioSystem;
-import javax.sound.sampled.Clip;
-
-public class Sound {
-
-	private Clip clip;
-
-	public Sound(String file) {
-		try {
-			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(file));
-			clip = AudioSystem.getClip();
-			clip.open(stream);
-		} catch (Exception e) {
-			e.printStackTrace();
-		}
-	}
-
-	public void loop() {
-		if (clip != null) {
-			clip.loop(Clip.LOOP_CONTINUOUSLY);
-		}
-	}
-}
+package bubble.game;
+
+import java.io.File;
+
+import javax.sound.sampled.AudioInputStream;
+import javax.sound.sampled.AudioSystem;
+import javax.sound.sampled.Clip;
+
+public class Sound {
+
+	private Clip clip;
+
+	public Sound(String file) {
+		try {
+			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(file));
+			clip = AudioSystem.getClip();
+			clip.open(stream);
+		} catch (Exception e) {
+			e.printStackTrace();
+		}
+	}
+
+	public void loop() {
+		if (clip != null) {
+			clip.loop(Clip.LOOP_CONTINUOUSLY);
+		}
+	}
+
+	public void play() {
+		if (clip != null) {
+			clip.start();
+		}
+	}
+
+	public void stop() {
+		if (clip != null) {
+			clip.stop();
+		}
+	}
+}
```

## T4 장 끝 코드를 ex15로 남기기
커밋: 9bbb1eb

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex15/ | 복사 7개 |
