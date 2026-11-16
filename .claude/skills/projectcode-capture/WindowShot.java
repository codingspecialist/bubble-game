// projectcode 창 사진 도우미
// 사용: java -cp <학생 bin>;<이 파일 bin> WindowShot <main 클래스> <저장할 png> [단계...]
// 단계: press:RIGHT, release:RIGHT, tap:SPACE, wait:500
// 학생 코드의 main을 같은 JVM에서 부르고, 키 이벤트는 창의 KeyListener에 직접 보낸다.
// 화면을 찍지 않고 창 내용을 이미지에 그려서 저장한다. 다른 창에 가려도 같은 사진이 나온다.

import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WindowShot {

	public static void main(String[] args) throws Exception {
		try {
			shoot(args);
		} finally {
			System.exit(0);
		}
	}

	static void shoot(String[] args) throws Exception {
		String mainClass = args[0];
		String out = args[1];
		Class.forName(mainClass).getMethod("main", String[].class).invoke(null, (Object) new String[0]);
		JFrame frame = findFrame();
		Thread.sleep(800);
		for (int i = 2; i < args.length; i++) {
			step(frame, args[i]);
		}
		Thread.sleep(150);
		BufferedImage[] image = new BufferedImage[1];
		SwingUtilities.invokeAndWait(() -> {
			Container content = frame.getContentPane();
			image[0] = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image[0].createGraphics();
			content.paint(g);
			g.dispose();
		});
		ImageIO.write(image[0], "png", new File(out));
	}

	static JFrame findFrame() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			for (Frame frame : Frame.getFrames()) {
				if (frame instanceof JFrame && frame.isVisible()) {
					return (JFrame) frame;
				}
			}
			Thread.sleep(50);
		}
		throw new IllegalStateException("보이는 JFrame이 없습니다");
	}

	static void step(JFrame frame, String step) throws Exception {
		String[] parts = step.split(":");
		String kind = parts[0];
		if (kind.equals("wait")) {
			Thread.sleep(Long.parseLong(parts[1]));
			return;
		}
		int code = KeyEvent.class.getField("VK_" + parts[1]).getInt(null);
		if (kind.equals("press") || kind.equals("tap")) {
			send(frame, KeyEvent.KEY_PRESSED, code);
		}
		if (kind.equals("tap")) {
			Thread.sleep(50);
		}
		if (kind.equals("release") || kind.equals("tap")) {
			send(frame, KeyEvent.KEY_RELEASED, code);
		}
	}

	static void send(JFrame frame, int id, int code) throws Exception {
		SwingUtilities.invokeAndWait(() -> {
			KeyEvent event = new KeyEvent(frame, id, System.currentTimeMillis(), 0, code, KeyEvent.CHAR_UNDEFINED);
			for (KeyListener listener : frame.getKeyListeners()) {
				if (id == KeyEvent.KEY_PRESSED) {
					listener.keyPressed(event);
				} else {
					listener.keyReleased(event);
				}
			}
		});
	}
}
