package bubble.game;

import javax.swing.ImageIcon;

import lombok.Getter;

public class Enemy extends Sprite {

	private static final int SPEED = 2;

	private ImageIcon enemyR;
	private ImageIcon enemyL;
	private ImageIcon enemyBubbled;
	@Getter
	private boolean bubbled;
	@Getter
	private boolean popped;

	public Enemy(int x, int y, Direction direction) {
		super(x, y, direction);
		enemyR = new ImageIcon("image/enemyR.png");
		enemyL = new ImageIcon("image/enemyL.png");
		enemyBubbled = new ImageIcon("image/enemyBubbled.png");
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
		if (bubbled) {
			setIcon(enemyBubbled);
		}
		setLocation(x, y);
	}

	public void trap() {
		bubbled = true;
		setIcon(enemyBubbled);
	}

	public void pop() {
		popped = true;
	}
}
