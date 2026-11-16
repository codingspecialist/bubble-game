package bubble.ex15;

import javax.swing.ImageIcon;

import lombok.Getter;

public class Bubble extends Sprite {

	private static final int SPEED = 6;
	private static final int RANGE = 300;
	private static final int LIFE = 150;

	private int distance;
	private int time;
	@Getter
	private boolean popped;

	public Bubble(Player player) {
		super(player.getX(), player.getY(), player.getDirection());
		setIcon(new ImageIcon("image/bubble.png"));
	}

	public void move() {
		time++;
		if (time > LIFE) {
			popped = true;
		}
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
		keepInWall();
		setLocation(x, y);
	}

	public void pop() {
		popped = true;
	}
}
