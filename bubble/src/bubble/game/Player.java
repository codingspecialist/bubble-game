package bubble.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Setter;

public class Player extends JLabel {

	private static final int SPEED = 4;

	private int x;
	private int y;
	@Setter
	private boolean left;
	@Setter
	private boolean right;
	private ImageIcon playerR;

	public Player() {
		playerR = new ImageIcon("image/playerR.png");
		x = 80;
		y = 570;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void move() {
		if (left) {
			x -= SPEED;
		}
		if (right) {
			x += SPEED;
		}
		setLocation(x, y);
	}
}
