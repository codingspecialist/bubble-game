package bubble.ex10;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel {

	private static final int SPEED = 2;
	private static final int GRAVITY = 1;

	private int x;
	private int y;
	private int dy;
	private Direction direction;
	private ImageIcon enemyR;
	private ImageIcon enemyL;

	public Enemy(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		enemyR = new ImageIcon("image/enemyR.png");
		enemyL = new ImageIcon("image/enemyL.png");
		if (direction == Direction.LEFT) {
			setIcon(enemyL);
		} else {
			setIcon(enemyR);
		}
		setSize(50, 50);
		setLocation(x, y);
	}

	public void move() {
		if (direction == Direction.LEFT) {
			x -= SPEED;
		} else {
			x += SPEED;
		}
		if (x < 40) {
			x = 40;
			direction = Direction.RIGHT;
		}
		if (x > 910) {
			x = 910;
			direction = Direction.LEFT;
		}
		if (direction == Direction.LEFT) {
			setIcon(enemyL);
		} else {
			setIcon(enemyR);
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
