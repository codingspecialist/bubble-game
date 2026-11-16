package bubble.game;

import javax.swing.JFrame;

public class BubbleFrame extends JFrame {

	public BubbleFrame() {
		setTitle("버블 게임");
		setSize(1000, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
