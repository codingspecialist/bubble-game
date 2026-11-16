package bubble.ex11;

import javax.swing.ImageIcon;

import lombok.Setter;

public class Player extends Sprite {

	private static final int SPEED = 4;
	private static final int JUMP = -18;

	@Setter
	private boolean left;
	@Setter
	private boolean right;
	private ImageIcon playerR;
	private ImageIcon playerL;

	public Player() {
		super(80, 40, Direction.RIGHT);
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
		setIcon(playerR);
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
		keepInWall();
		if (direction == Direction.LEFT) {
			setIcon(playerL);
		} else {
			setIcon(playerR);
		}
		setLocation(x, y);
	}

	public void jump() {
		if (onGround) {
			dy = JUMP;
		}
	}
}
