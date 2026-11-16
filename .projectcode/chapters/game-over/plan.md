# game-over 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/src/bubble/game/BubbleFrame.java | 고침 | 적군에 닿으면 gameOver를 부른다 |
| bubble/src/bubble/game/Player.java | 고침 | 쓰러진 그림으로 바꾼다 |
| bubble/src/bubble/game/Sound.java | 고침 | 한 번 재생과 멈추기 |
| bubble/src/bubble/ex15/ | 새로 | 장 끝 코드 |

## 코드 계획
BubbleFrame.java
- T1에서 Timer를 timer 칸에 둔다. 멈추려면 붙잡아 둬야 한다
- 적군 for 문에서 닿았는데 갇히지 않은 적군이면 gameOver()를 부르고 tick을 return으로 끝낸다
- gameOver는 timer.stop()과 player.die()를 부른다
- T2에서 gameover 칸에 GAME OVER 그림 JLabel을 (250, 279)에 500x82로 놓는다. clear처럼 숨겨서 add(gameover, 0) 하고 gameOver에서 보인다
- T3에서 bgm을 칸으로 옮긴다. gameOver에서 bgm.stop()을 부르고 new Sound("sound/gameover.wav").play()로 한 번 낸다

Player.java
- playerDie 그림을 읽어 두고 die에서 setIcon 한다

Sound.java
- play는 clip.start(), stop은 clip.stop()이다. loop처럼 clip이 null이면 아무것도 하지 않는다

## 핵심 코드
if (touch && !enemy.isBubbled()) {
	gameOver();
	return;
}

private void gameOver() {
	timer.stop();
	player.die();
	gameover.setVisible(true);
	bgm.stop();
	new Sound("sound/gameover.wav").play();
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | BubbleFrame.java |
| S2 | Player.java, BubbleFrame.java |
| S3 | BubbleFrame.java |
| S4 | Sound.java, BubbleFrame.java |
| S5 | ex15 |

## 라이브러리
- 추가 없음

## 다른 장 파일
- 없음
