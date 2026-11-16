# bgm 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Sound.java | 새로 | wav 하나를 Clip으로 열고 반복 재생한다 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 시작할 때 배경음악을 튼다 |
| bubble/src/bubble/ex14/ | 새로 | 장 끝 코드 |

## 코드 계획
Sound.java
- 파일 이름을 받는 생성자가 AudioSystem.getAudioInputStream으로 wav를 읽고 AudioSystem.getClip으로 Clip을 얻어 open 한다
- 읽기와 열기는 검사 예외를 던진다. try-catch로 잡아 printStackTrace 한다
- loop는 clip.loop(Clip.LOOP_CONTINUOUSLY)를 부른다. clip이 null이면 아무것도 하지 않는다
- 배경음악과 게임오버 소리가 같은 방법으로 열리므로 BGM이 아니라 Sound라는 이름으로 둔다

BubbleFrame.java
- 생성자 끝, setVisible 앞에서 new Sound("sound/bgm.wav")를 만들고 loop를 부른다

## 핵심 코드
public Sound(String file) {
	try {
		AudioInputStream stream = AudioSystem.getAudioInputStream(new File(file));
		clip = AudioSystem.getClip();
		clip.open(stream);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Sound.java, BubbleFrame.java |
| S2 | Sound.java |
| S3 | Sound.java |
| S4 | ex14 |

## 라이브러리
- 추가 없음. javax.sound.sampled는 JDK에 들어 있다

## 다른 장 파일
- 없음
