# game-window 흐름

```mermaid
flowchart LR
  A["main"] --> B["new BubbleFrame()"]
  B --> C[제목 정하기]
  C --> D[배경 JLabel 깔기]
  D --> E["pack 크기 맞추기"]
  E --> F[창 보이기]
```
