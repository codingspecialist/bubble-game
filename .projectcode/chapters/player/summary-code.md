# player 코드 요약

## T1 플레이어를 창에 놓기
커밋: 893ca2b

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Player.java | 새로 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -6,10 +6,16 @@ import javax.swing.JLabel;
 
 public class BubbleFrame extends JFrame {
 
+	private Player player;
+
 	public BubbleFrame() {
 		setTitle("버블 게임");
 		setContentPane(new JLabel(new ImageIcon("image/background.png")));
 		setLayout(null);
+
+		player = new Player();
+		add(player);
+
 		pack();
 		setResizable(false);
 		setLocationRelativeTo(null);
```

```java
// bubble/src/bubble/game/Player.java
package bubble.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;

	public Player() {
		playerR = new ImageIcon("image/playerR.png");
		x = 80;
		y = 570;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}
}
```

## T2 장 끝 코드를 ex03으로 남기기
커밋: 6047ad2

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex03/ | 복사 2개 |
