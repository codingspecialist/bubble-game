package bubble.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel {

	private int x;
	private int y;
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
}
