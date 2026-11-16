# game-window 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 | JFrame을 상속해 게임 창을 띄운다 |
| bubble/src/bubble/ex02/BubbleFrame.java | 새로 | 장 끝 코드 |

## 코드 계획
BubbleFrame.java
- JFrame을 상속한다. 게임 창 자체가 BubbleFrame이다
- 생성자에서 제목, 크기, 가운데 놓기, 닫으면 끝내기, 보이기를 차례로 한다
- 배경은 JLabel에 ImageIcon을 넣어 창의 content pane으로 삼는다
- content pane의 배치를 null로 바꿔 뒤 장에서 좌표로 물체를 놓는다
- 크기는 setSize 대신 pack으로 배경 그림 크기에 맞춘다. 창 안이 정확히 1000x640이 된다
- 크기 바꾸기를 막는다
- main은 new BubbleFrame()만 한다
- 그림 경로는 bubble 폴더 기준 image/background.png다

## 핵심 코드
public class BubbleFrame extends JFrame {

	public BubbleFrame() {
		setTitle("버블 게임");
		setContentPane(new JLabel(new ImageIcon("image/background.png")));
		setLayout(null);
		pack();
	}
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | BubbleFrame.java |
| S2 | BubbleFrame.java |
| S3 | BubbleFrame.java |
| S4 | ex02/BubbleFrame.java |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
