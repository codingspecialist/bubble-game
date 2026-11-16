# 시나리오별 구조도

## 걷고 뛰기

```mermaid
flowchart LR
  A[화살표 키] --> B[KeyAdapter]
  B --> C[Player 플래그]
  D["Timer tick"] --> E["Player.move"]
  E --> F["Sprite.fall"]
  F --> G[floors 목록]
```

만든 장: player-move, wall-stop, floor-gravity, player-jump, sprite-refactor
맡는 파일
- bubble/src/bubble/game/BubbleFrame.java
- bubble/src/bubble/game/Player.java
- bubble/src/bubble/game/Sprite.java
- bubble/src/bubble/game/Direction.java

## 물방울로 가두고 터트리기

```mermaid
flowchart LR
  A[스페이스] --> B["shoot"]
  B --> C[bubbles 목록]
  D["Timer tick"] --> E["Bubble.move"]
  E --> F["intersects"]
  F --> G["Enemy.trap"]
  G --> H["Enemy.pop"]
  H --> I[CLEAR!]
```

만든 장: bubble-shoot, bubble-pop, enemy, enemy-trap, enemy-pop
맡는 파일
- bubble/src/bubble/game/BubbleFrame.java
- bubble/src/bubble/game/Bubble.java
- bubble/src/bubble/game/Enemy.java

## 게임오버

```mermaid
flowchart LR
  A["Timer tick"] --> B["intersects"]
  B --> C["gameOver"]
  C --> D["timer.stop"]
  C --> E[GAME OVER]
  C --> F["Sound.play"]
```

만든 장: bgm, game-over
맡는 파일
- bubble/src/bubble/game/BubbleFrame.java
- bubble/src/bubble/game/Sound.java
- bubble/src/bubble/game/Player.java
