# bubble-pop 코드 요약

## T1 시간이 지난 물방울 지우기
커밋: 32bdc47

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/Bubble.java | 고침 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/Bubble.java
@@ -3,15 +3,21 @@ package bubble.game;
 import javax.swing.ImageIcon;
 import javax.swing.JLabel;
 
+import lombok.Getter;
+
 public class Bubble extends JLabel {
 
 	private static final int SPEED = 6;
 	private static final int RANGE = 300;
+	private static final int LIFE = 150;
 
 	private int x;
 	private int y;
 	private Direction direction;
 	private int distance;
+	private int time;
+	@Getter
+	private boolean popped;
 
 	public Bubble(Player player) {
 		x = player.getX();
@@ -23,6 +29,10 @@ public class Bubble extends JLabel {
 	}
 
 	public void move() {
+		time++;
+		if (time > LIFE) {
+			popped = true;
+		}
 		if (distance < RANGE) {
 			if (direction == Direction.LEFT) {
 				x -= SPEED;
```

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -77,7 +77,12 @@ public class BubbleFrame extends JFrame {
 		player.fall(floors);
 		for (Bubble bubble : bubbles) {
 			bubble.move();
+			if (bubble.isPopped()) {
+				remove(bubble);
+			}
 		}
+		bubbles.removeIf(bubble -> bubble.isPopped());
+		repaint();
 	}
 
 	private void shoot() {
```

## T2 장 끝 코드를 ex09로 남기기
커밋: 199fa24

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex09/ | 복사 4개 |
