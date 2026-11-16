# bgm 코드 요약

## T1 배경음악 반복 재생하기
커밋: 08d0c5c

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 |
| bubble/src/bubble/game/Sound.java | 새로 |

```diff
// bubble/src/bubble/game/BubbleFrame.java
@@ -79,6 +79,9 @@ public class BubbleFrame extends JFrame {
 
 		new Timer(16, e -> tick()).start();
 
+		Sound bgm = new Sound("sound/bgm.wav");
+		bgm.loop();
+
 		pack();
 		setResizable(false);
 		setLocationRelativeTo(null);
```

```java
// bubble/src/bubble/game/Sound.java
package bubble.game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	private Clip clip;

	public Sound(String file) {
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(file));
			clip = AudioSystem.getClip();
			clip.open(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loop() {
		if (clip != null) {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
}
```

## T2 장 끝 코드를 ex14로 남기기
커밋: 43c00ad

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex14/ | 복사 7개 |
