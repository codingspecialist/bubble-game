# player-jump 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/Player.java | 고침 | jump와 서 있는지 기억하기 |
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 위 화살표로 jump를 부른다 |
| bubble/src/bubble/ex07/ | 새로 | 장 끝 코드 |

## 코드 계획
Player.java
- JUMP는 -18이다. dy가 음수면 위로 간다
- onGround 칸에 서 있는지 기억한다
- fall에서 발판을 보기 전에 onGround를 false로 두고, 발판에 세울 때 true로 한다
- jump는 onGround일 때만 dy를 JUMP로 바꾼다
- 올라갈 때는 움직이기 전 발이 발판 아래라 above가 거짓이다. 그래서 발판을 뚫고 올라가고 내려올 때 선다. 코드를 더하지 않는다

BubbleFrame.java
- keyPressed의 switch에 VK_UP -> player.jump()를 더한다

## 핵심 코드
public void jump() {
	if (onGround) {
		dy = JUMP;
	}
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | Player.java, BubbleFrame.java |
| S2 | Player.java |
| S3 | Player.java |
| S4 | ex07 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
