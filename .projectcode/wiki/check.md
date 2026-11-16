# 점검

| 점검 | 결과 |
|---|---|
| 장 상태 | 맞음. 15장 모두 tasks.md가 체크돼 있고 done 태그가 있다 |
| 진행 중 | 맞음. 진행 중인 장이 없다 |
| 장 자료 | 맞음. 15장 모두 captures.md, tree.md, summary-code.md, 장 끝 사진이 있다 |
| 사진 | 맞음. captures.md의 파일 60개가 모두 있다 |
| 미룬 것 | 미룬 것 3개 모두 장을 정하지 않았다 |
| 테스트 | 행동 테스트는 하지 않는다. game과 ex01~ex15가 모두 컴파일되고 장마다 창 사진으로 확인했다 |

## 어긋난 것
- enemy-trap: Enemy.java move의 if (bubbled) 세 줄은 T2부터 불리지 않는다. 지울지 정해야 한다
- sprite-refactor: tasks.md T2의 Why가 fall이 한 글자도 다르지 않다고 쓴다. Enemy에는 onGround 줄이 없었다
- game-over: 게임오버 뒤에도 스페이스를 누르면 멈춘 물방울이 생긴다
- bubble 코드: 커밋마다 줄바꿈이 CRLF와 LF로 섞였다. 따라치기 lecture 브랜치는 LF로 맞췄다
