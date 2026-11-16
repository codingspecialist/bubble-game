# enemy-pop 코드 요약

## T1 갇힌 적군에 닿으면 터트리기
커밋: af25fc5

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Enemy.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -103,6 +103,14 @@ public class BubbleFrame extends JFrame {
 			}
 		}
 		bubbles.removeIf(bubble -> bubble.isPopped());
+		for (Enemy enemy : enemies) {
+			boolean touch = player.getBounds().intersects(enemy.getBounds());
+			if (touch && enemy.isBubbled()) {
+				enemy.pop();
+				remove(enemy);
+			}
+		}
+		enemies.removeIf(enemy -> enemy.isPopped());
 		repaint();
 	}
 
```

```diff
// bubble/src/bubble/game/Enemy.java
@@ -13,6 +13,8 @@ public class Enemy extends Sprite {
 	private ImageIcon enemyBubbled;
 	@Getter
 	private boolean bubbled;
+	@Getter
+	private boolean popped;
 
 	public Enemy(int x, int y, Direction direction) {
 		super(x, y, direction);
@@ -54,4 +56,8 @@ public class Enemy extends Sprite {
 		bubbled = true;
 		setIcon(enemyBubbled);
 	}
+
+	public void pop() {
+		popped = true;
+	}
 }
```

## T2 적군을 다 터트리면 CLEAR! 보이기
커밋: ff2e42b

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -18,6 +18,7 @@ public class BubbleFrame extends JFrame {
 	private List<Rectangle> floors = new ArrayList<>();
 	private List<Bubble> bubbles = new ArrayList<>();
 	private List<Enemy> enemies = new ArrayList<>();
+	private JLabel clear;
 
 	public BubbleFrame() {
 		setTitle("버블 게임");
@@ -51,6 +52,11 @@ public class BubbleFrame extends JFrame {
 			add(enemy);
 		}
 
+		clear = new JLabel(new ImageIcon("image/clear.png"));
+		clear.setBounds(250, 258, 500, 124);
+		clear.setVisible(false);
+		add(clear, 0);
+
 		addKeyListener(new KeyAdapter() {
 			@Override
 			public void keyPressed(KeyEvent e) {
@@ -111,6 +117,9 @@ public class BubbleFrame extends JFrame {
 			}
 		}
 		enemies.removeIf(enemy -> enemy.isPopped());
+		if (enemies.isEmpty()) {
+			clear.setVisible(true);
+		}
 		repaint();
 	}
 
```

## T3 장 끝 코드를 ex13으로 남기기
커밋: 755a8d6

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex13/ | 복사 6개 |
