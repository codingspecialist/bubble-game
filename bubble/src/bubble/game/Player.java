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
	private Direction direction;
	private ImageIcon playerR;
	private ImageIcon playerL;

	public Player() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
		x = 80;
		y = 570;
		direction = Direction.RIGHT;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void move() {
		if (left) {
			x -= SPEED;
			direction = Direction.LEFT;
		}
		if (right) {
			x += SPEED;
			direction = Direction.RIGHT;
		}
		if (direction == Direction.LEFT) {
			setIcon(playerL);
		} else {
			setIcon(playerR);
		}
		setLocation(x, y);
	}
}
