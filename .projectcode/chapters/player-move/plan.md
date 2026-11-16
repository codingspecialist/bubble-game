# player-move 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Player.java | 고침 | 움직이기와 바라보는 쪽 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 키 듣기와 게임 루프 |
| bubble/src/bubble/game/Direction.java | 새로 | 왼쪽, 오른쪽 두 값 |
| bubble/src/bubble/ex04/ | 새로 | 장 끝 코드 |

## 코드 계획
T1 키를 누를 때마다 움직이기
- Player에 moveLeft, moveRight를 두고 x를 10씩 바꾼 뒤 setLocation 한다
- BubbleFrame에 KeyAdapter를 붙이고 keyPressed에서 키 코드로 나눠 부른다. switch 화살표 문법을 쓴다
- 키를 꾹 누르면 처음에 한 번 움직이고 잠깐 멈췄다 움직인다. 다음 task의 이유가 된다

T2 게임 루프로 부드럽게 움직이기
- Player에 left, right 불리언을 두고 Lombok @Setter를 칸마다 붙인다
- moveLeft, moveRight를 지우고 move 하나로 바꾼다. left면 x를 SPEED만큼 빼고, right면 더한다
- SPEED는 4다. private static final로 둔다
- keyPressed는 setLeft(true), keyReleased는 setLeft(false)처럼 불리언만 바꾼다
- javax.swing.Timer를 16ms로 만들고 매 틱 player.move()를 부른다
- @Setter는 left, right 칸에만 붙인다. 클래스에 붙이면 x, y의 getX가 JLabel의 getX와 겹친다

T3 움직이는 쪽 바라보기
- Direction enum에 LEFT, RIGHT를 둔다
- Player에 direction 칸을 두고 처음은 RIGHT다
- move에서 left면 LEFT, right면 RIGHT로 바꾸고, direction에 따라 playerL, playerR을 setIcon 한다

## 핵심 코드
@Setter
private boolean left;

public void move() {
	if (left) {
		x -= SPEED;
		direction = Direction.LEFT;
	}
	...
	setLocation(x, y);
}

new Timer(16, e -> player.move()).start();

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Player.java, BubbleFrame.java |
| S2 | Player.java, BubbleFrame.java |
| S3 | Direction.java, Player.java |
| S4 | ex04 |

## 라이브러리
- Lombok. contract.md에 있다

## 다른 장 파일
- 없음
