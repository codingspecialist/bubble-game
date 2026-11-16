package bubble.ex09;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BubbleFrame extends JFrame {

	private Player player;
	private ImageIcon brickIcon = new ImageIcon("image/brick.png");
	private List<Rectangle> floors = new ArrayList<>();
	private List<Bubble> bubbles = new ArrayList<>();

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

		floors.add(new Rectangle(40, 620, 920, 20));
		floors.add(new Rectangle(160, 490, 240, 20));
		floors.add(new Rectangle(600, 490, 240, 20));
		floors.add(new Rectangle(360, 360, 280, 20));
		floors.add(new Rectangle(40, 230, 240, 20));
		floors.add(new Rectangle(720, 230, 240, 20));
		for (Rectangle floor : floors) {
			for (int x = floor.x; x < floor.x + floor.width; x += 40) {
				addBrick(x, floor.y);
			}
		}

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT -> player.setLeft(true);
				case KeyEvent.VK_RIGHT -> player.setRight(true);
				case KeyEvent.VK_UP -> player.jump();
				case KeyEvent.VK_SPACE -> shoot();
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

		new Timer(16, e -> tick()).start();

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void tick() {
		player.move();
		player.fall(floors);
		for (Bubble bubble : bubbles) {
			bubble.move();
			if (bubble.isPopped()) {
				remove(bubble);
			}
		}
		bubbles.removeIf(bubble -> bubble.isPopped());
		repaint();
	}

	private void shoot() {
		Bubble bubble = new Bubble(player);
		bubbles.add(bubble);
		add(bubble);
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
