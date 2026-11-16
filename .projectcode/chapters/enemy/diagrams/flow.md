# enemy 흐름

```mermaid
flowchart LR
  A["tick()"] --> B["for 모든 적군"]
  B --> C["enemy.move()"]
  C --> D{벽에 닿음}
  D -->|예| E[돌아서기]
  D -->|아니오| F["enemy.fall(floors)"]
  E --> F
```
