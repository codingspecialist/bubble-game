# player-jump 흐름

```mermaid
flowchart LR
  A[위 화살표] --> B["jump()"]
  B --> C{onGround}
  C -->|예| D["dy = JUMP"]
  D --> E["fall이 y를 올림"]
  E --> F[중력이 dy를 줄임]
  F --> G[내려오다 발판에 서기]
```
