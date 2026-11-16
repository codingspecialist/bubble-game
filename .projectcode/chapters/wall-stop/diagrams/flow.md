# wall-stop 흐름

```mermaid
flowchart LR
  A["player.move()"] --> B[x 바꾸기]
  B --> C{"x < 40 또는 x > 910"}
  C -->|예| D[벽 앞으로 되돌림]
  C -->|아니오| E["setLocation"]
  D --> E
```
