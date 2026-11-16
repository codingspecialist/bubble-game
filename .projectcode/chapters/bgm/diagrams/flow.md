# bgm 흐름

```mermaid
flowchart LR
  A["new Sound(bgm.wav)"] --> B["getAudioInputStream"]
  B --> C["getClip, open"]
  C --> D["loop()"]
  D --> E[끝나면 처음부터]
  B -->|예외| F["printStackTrace"]
```
