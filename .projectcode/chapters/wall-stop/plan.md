# wall-stop 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 양쪽 벽에 벽돌을 쌓는다 |
| bubble/src/bubble/game/Player.java | 고침 | 이동 뒤 x가 벽 안쪽인지 확인한다 |
| bubble/src/bubble/ex05/ | 새로 | 장 끝 코드 |

## 코드 계획
BubbleFrame.java
- addBrick(x, y) 메서드를 둔다. 벽돌 JLabel을 만들어 40x20으로 놓고 add 한다. 벽돌을 여러 곳에서 쌓으므로 나눈다
- for 문으로 y를 0부터 620까지 20씩 늘리며 x 0과 960에 벽돌을 놓는다
- 벽돌 그림은 ImageIcon 하나를 칸에 두고 모든 벽돌이 같이 쓴다
- 벽돌은 플레이어 뒤에 add 한다. 먼저 add 한 것이 위에 그려진다

Player.java
- move에서 x를 바꾼 뒤 40보다 작으면 40, 910보다 크면 910으로 맞춘다
- 910은 오른쪽 벽 960에서 플레이어 너비 50을 뺀 값이다

## 핵심 코드
private void addBrick(int x, int y) {
	JLabel brick = new JLabel(brickIcon);
	brick.setBounds(x, y, 40, 20);
	add(brick);
}

if (x < 40) {
	x = 40;
}
if (x > 910) {
	x = 910;
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | BubbleFrame.java |
| S2 | Player.java |
| S3 | ex05 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
