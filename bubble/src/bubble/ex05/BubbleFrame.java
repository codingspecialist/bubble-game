package bubble.ex05;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BubbleFrame extends JFrame {

	private Player player;
	private ImageIcon brickIcon = new ImageIcon("image/brick.png");

	public BubbleFrame() {
		setTitle("버블 게임");
		setContentPane(new JLabel(new ImageIcon("image/background.png")));
		setLayout(null);

		player = new Player();
		add(player);

		for (int y = 0; y < 640; y += 20) {
			addBrick(0, y);
			addBrick(960, y);
		}

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT -> player.setLeft(true);
				case KeyEvent.VK_RIGHT -> player.setRight(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT -> player.setLeft(false);
				case KeyEvent.VK_RIGHT -> player.setRight(false);
				}
			}
		});

		new Timer(16, e -> player.move()).start();

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void addBrick(int x, int y) {
		JLabel brick = new JLabel(brickIcon);
		brick.setBounds(x, y, 40, 20);
		add(brick);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
