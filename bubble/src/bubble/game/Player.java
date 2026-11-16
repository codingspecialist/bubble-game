package bubble.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;

	public Player() {
		playerR = new ImageIcon("image/playerR.png");
		x = 80;
		y = 570;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void moveLeft() {
		x -= 10;
		setLocation(x, y);
	}

	public void moveRight() {
		x += 10;
		setLocation(x, y);
	}
}
