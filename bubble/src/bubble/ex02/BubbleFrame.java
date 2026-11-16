package bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	public BubbleFrame() {
		setTitle("버블 게임");
		setContentPane(new JLabel(new ImageIcon("image/background.png")));
		setLayout(null);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
