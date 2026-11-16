package bubble.game;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {

	private static final int SPEED = 2;

	private ImageIcon enemyR;
	private ImageIcon enemyL;

	public Enemy(int x, int y, Direction direction) {
		super(x, y, direction);
		enemyR = new ImageIcon("image/enemyR.png");
		enemyL = new ImageIcon("image/enemyL.png");
		if (direction == Direction.LEFT) {
			setIcon(enemyL);
		} else {
			setIcon(enemyR);
		}
	}

	public void move() {
		if (direction == Direction.LEFT) {
			x -= SPEED;
		} else {
			x += SPEED;
		}
		if (x < 40) {
			direction = Direction.RIGHT;
		}
		if (x > 910) {
			direction = Direction.LEFT;
		}
		keepInWall();
		if (direction == Direction.LEFT) {
			setIcon(enemyL);
		} else {
			setIcon(enemyR);
		}
		setLocation(x, y);
	}
}
