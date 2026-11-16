# player 흐름

```mermaid
flowchart LR
  A["new BubbleFrame()"] --> B["new Player()"]
  B --> C[playerR 그림 넣기]
  C --> D["80, 570에 놓기"]
  D --> E["add(player)"]
```
