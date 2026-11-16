package bubble.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private Player player;

	public BubbleFrame() {
		setTitle("버블 게임");
		setContentPane(new JLabel(new ImageIcon("image/background.png")));
		setLayout(null);

		player = new Player();
		add(player);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT -> player.moveLeft();
				case KeyEvent.VK_RIGHT -> player.moveRight();
				}
			}
		});

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
