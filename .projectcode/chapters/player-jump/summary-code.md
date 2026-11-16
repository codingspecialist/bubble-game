# player-jump 코드 요약

## T1 위 화살표로 점프하기
커밋: cd38737

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Player.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -48,6 +48,7 @@ public class BubbleFrame extends JFrame {
 				switch (e.getKeyCode()) {
 				case KeyEvent.VK_LEFT -> player.setLeft(true);
 				case KeyEvent.VK_RIGHT -> player.setRight(true);
+				case KeyEvent.VK_UP -> player.jump();
 				}
 			}
 
```

```diff
// bubble/src/bubble/game/Player.java
@@ -12,10 +12,12 @@ public class Player extends JLabel {
 
 	private static final int SPEED = 4;
 	private static final int GRAVITY = 1;
+	private static final int JUMP = -18;
 
 	private int x;
 	private int y;
 	private int dy;
+	private boolean onGround;
 	@Setter
 	private boolean left;
 	@Setter
@@ -58,16 +60,24 @@ public class Player extends JLabel {
 		setLocation(x, y);
 	}
 
+	public void jump() {
+		if (onGround) {
+			dy = JUMP;
+		}
+	}
+
 	public void fall(List<Rectangle> floors) {
 		int bottom = y + 50;
 		dy += GRAVITY;
 		y += dy;
+		onGround = false;
 		for (Rectangle floor : floors) {
 			boolean above = bottom <= floor.y && y + 50 >= floor.y;
 			boolean across = x + 50 > floor.x && x < floor.x + floor.width;
 			if (above && across) {
 				y = floor.y - 50;
 				dy = 0;
+				onGround = true;
 			}
 		}
 		setLocation(x, y);
```

## T2 장 끝 코드를 ex07로 남기기
커밋: fd97269

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex07/ | 복사 3개 |
