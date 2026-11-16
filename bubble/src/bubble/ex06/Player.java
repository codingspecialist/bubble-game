package bubble.ex06;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Setter;

public class Player extends JLabel {

	private static final int SPEED = 4;
	private static final int GRAVITY = 1;

	private int x;
	private int y;
	private int dy;
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
		y = 40;
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
		if (x < 40) {
			x = 40;
		}
		if (x > 910) {
			x = 910;
		}
		if (direction == Direction.LEFT) {
			setIcon(playerL);
		} else {
			setIcon(playerR);
		}
		setLocation(x, y);
	}

	public void fall(List<Rectangle> floors) {
		int bottom = y + 50;
		dy += GRAVITY;
		y += dy;
		for (Rectangle floor : floors) {
			boolean above = bottom <= floor.y && y + 50 >= floor.y;
			boolean across = x + 50 > floor.x && x < floor.x + floor.width;
			if (above && across) {
				y = floor.y - 50;
				dy = 0;
			}
		}
		setLocation(x, y);
	}
}
