# player 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Player.java | 새로 | 플레이어 그림과 위치 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 플레이어를 만들어 창에 붙인다 |
| bubble/src/bubble/ex03/ | 새로 | 장 끝 코드 |

## 코드 계획
Player.java
- JLabel을 상속한다. 플레이어가 곧 그림 한 장이다
- x, y 칸에 위치를 기억한다. 처음 위치는 80, 570이다
- 오른쪽을 보는 그림 playerR을 ImageIcon으로 읽어 setIcon 한다
- 크기는 50x50이다

BubbleFrame.java
- player 칸을 두고 생성자에서 만들어 add 한다
- add는 setLayout(null) 뒤, pack 앞에 둔다

## 핵심 코드
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
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Player.java, BubbleFrame.java |
| S2 | ex03 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
