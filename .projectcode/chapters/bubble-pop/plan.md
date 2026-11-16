# bubble-pop 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Bubble.java | 고침 | 시간을 세고 다 되면 터짐을 표시한다 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 터진 물방울을 화면과 목록에서 지운다 |
| bubble/src/bubble/ex09/ | 새로 | 장 끝 코드 |

## 코드 계획
Bubble.java
- LIFE는 150 틱이다
- time 칸에 지난 틱 수를 센다. move 첫 줄에서 1을 더한다
- time이 LIFE보다 크면 popped를 true로 한다. popped에 @Getter를 붙인다

BubbleFrame.java
- tick의 for 문에서 move 뒤 popped면 remove(bubble)로 화면에서 지운다
- for 문이 끝난 뒤 bubbles.removeIf로 목록에서 뺀다. for 문 안에서 목록을 지우면 예외가 난다
- 지운 자리가 다시 그려지게 repaint 한다

## 핵심 코드
for (Bubble bubble : bubbles) {
	bubble.move();
	if (bubble.isPopped()) {
		remove(bubble);
	}
}
bubbles.removeIf(bubble -> bubble.isPopped());
repaint();

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Bubble.java, BubbleFrame.java |
| S2 | BubbleFrame.java |
| S3 | ex09 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
