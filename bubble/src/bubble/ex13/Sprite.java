package bubble.ex13;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JLabel;

import lombok.Getter;

public class Sprite extends JLabel {

	private static final int GRAVITY = 1;

	protected int x;
	protected int y;
	protected int dy;
	protected boolean onGround;
	@Getter
	protected Direction direction;

	public Sprite(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		setSize(50, 50);
		setLocation(x, y);
	}

	protected void keepInWall() {
		if (x < 40) {
			x = 40;
		}
		if (x > 910) {
			x = 910;
		}
	}

	public void fall(List<Rectangle> floors) {
		int bottom = y + 50;
		dy += GRAVITY;
		y += dy;
		onGround = false;
		for (Rectangle floor : floors) {
			boolean above = bottom <= floor.y && y + 50 >= floor.y;
			boolean across = x + 50 > floor.x && x < floor.x + floor.width;
			if (above && across) {
				y = floor.y - 50;
				dy = 0;
				onGround = true;
			}
		}
		setLocation(x, y);
	}
}
