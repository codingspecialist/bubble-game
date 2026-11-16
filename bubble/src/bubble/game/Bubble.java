package bubble.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	private static final int SPEED = 6;
	private static final int RANGE = 300;

	private int x;
	private int y;
	private Direction direction;
	private int distance;

	public Bubble(Player player) {
		x = player.getX();
		y = player.getY();
		direction = player.getDirection();
		setIcon(new ImageIcon("image/bubble.png"));
		setSize(50, 50);
		setLocation(x, y);
	}

	public void move() {
		if (distance < RANGE) {
			if (direction == Direction.LEFT) {
				x -= SPEED;
			} else {
				x += SPEED;
			}
			distance += SPEED;
		} else if (y > 20) {
			y -= 2;
		}
		if (x < 40) {
			x = 40;
		}
		if (x > 910) {
			x = 910;
		}
		setLocation(x, y);
	}
}
