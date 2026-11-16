# floor-gravity 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 발판 목록을 만들고 벽돌로 그린다. 루프에서 fall을 부른다 |
| bubble/src/bubble/game/Player.java | 고침 | 중력으로 떨어지고 발판에 선다 |
| bubble/src/bubble/ex06/ | 새로 | 장 끝 코드 |

## 코드 계획
BubbleFrame.java
- floors 칸에 Rectangle 목록을 둔다. ArrayList다
- 바닥 (40, 620, 920, 20)과 발판 다섯 개를 add 한다
- 발판 (160, 490, 240, 20), (600, 490, 240, 20), (360, 360, 280, 20), (40, 230, 240, 20), (720, 230, 240, 20)
- 발판마다 x를 40씩 늘리며 addBrick 한다. 같은 목록으로 그리고 같은 목록으로 착지를 확인한다
- Timer 람다를 중괄호로 바꿔 move 뒤에 fall(floors)를 부른다

Player.java
- dy 칸에 아래로 가는 속도를 둔다. GRAVITY는 1이다
- fall은 움직이기 전의 발 높이 bottom을 기억하고, dy에 GRAVITY를 더하고, y에 dy를 더한다
- 발판마다 두 조건을 본다. above는 움직이기 전 발이 발판 위였고 지금 발판에 닿았는지, across는 가로로 겹치는지
- 둘 다 맞으면 y를 발판 위로 맞추고 dy를 0으로 한다
- 처음 위치를 80, 40으로 바꿔 왼쪽 위 발판으로 떨어지게 한다

## 핵심 코드
public void fall(List<Rectangle> floors) {
	int bottom = y + 50;
	dy += GRAVITY;
	y += dy;
	for (Rectangle floor : floors) {
		boolean above = bottom <= floor.y && y + 50 >= floor.y;
		boolean across = x + 50 > floor.x && x < floor.x + floor.width;
		if (above && across) {
			y = floor.y - 50;
			dy = 0;
		}
	}
	setLocation(x, y);
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | BubbleFrame.java |
| S2 | Player.java, BubbleFrame.java |
| S3 | Player.java |
| S4 | Player.java |
| S5 | ex06 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
