package bubble.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	private int x;
	private int y;
	private Direction direction;

	public Bubble(Player player) {
		x = player.getX();
		y = player.getY();
		direction = player.getDirection();
		setIcon(new ImageIcon("image/bubble.png"));
		setSize(50, 50);
		setLocation(x, y);
	}
}
