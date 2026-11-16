# game-window 코드 요약

## T1 빈 게임 창 띄우기
커밋: f348664

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -1,8 +1,18 @@
 package bubble.game;
 
-public class BubbleFrame {
+import javax.swing.JFrame;
+
+public class BubbleFrame extends JFrame {
+
+	public BubbleFrame() {
+		setTitle("버블 게임");
+		setSize(1000, 640);
+		setLocationRelativeTo(null);
+		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
+		setVisible(true);
+	}
 
 	public static void main(String[] args) {
-		System.out.println("버블 게임 준비");
+		new BubbleFrame();
 	}
 }
```

## T2 배경 그림 깔기
커밋: ae22a3b

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -1,12 +1,17 @@
 package bubble.game;
 
+import javax.swing.ImageIcon;
 import javax.swing.JFrame;
+import javax.swing.JLabel;
 
 public class BubbleFrame extends JFrame {
 
 	public BubbleFrame() {
 		setTitle("버블 게임");
-		setSize(1000, 640);
+		setContentPane(new JLabel(new ImageIcon("image/background.png")));
+		setLayout(null);
+		pack();
+		setResizable(false);
 		setLocationRelativeTo(null);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		setVisible(true);
```

## T3 장 끝 코드를 ex02로 남기기
커밋: 1552c3f

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex02/ | 복사 1개 |
