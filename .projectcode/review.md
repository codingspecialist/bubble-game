# 따라치기 코드 리뷰

## project-setup T1

### .classpath

#### 개념 이클립스
##### 무엇
- .project는 이클립스가 이 폴더를 자바 프로젝트로 알아보게 하는 설정 파일이다
- .classpath는 소스 폴더, 결과 폴더, 쓸 JDK와 라이브러리를 적는다
##### 쉬운 방법과 비교
- 이클립스 메뉴로 새 프로젝트를 만들어도 같은 두 파일이 생긴다
- 파일을 미리 넣어 두면 File > Import > Existing Projects로 bubble 폴더를 열기만 하면 된다
##### 이 예제에서는
- kind="src" path="src"는 자바 소스가 src 폴더에 있다는 뜻이다
- JavaSE-21은 이 프로젝트가 Java 21로 컴파일된다는 뜻이다
- kind="output" path="bin"은 컴파일한 class 파일이 bin에 쌓인다는 뜻이다

### .project

#### 코드
- natures의 javanature가 이 폴더를 자바 프로젝트로 알아보게 한다

### src/bubble/game/BubbleFrame.java

#### 개념 폴더 구조
##### 무엇
- 자바 패키지 이름은 폴더 경로와 같다. bubble.game 패키지는 src/bubble/game 폴더다
##### 왜
- 장마다 끝난 코드를 bubble.ex01 같은 다른 패키지에 복사해 둔다. 패키지가 다르면 같은 클래스 이름이 부딪히지 않는다
##### 이 예제에서는
- 진도 코드는 늘 bubble.game에서 고친다

#### 코드
- main은 프로그램이 시작하는 메서드다. 지금은 준비됐다는 글자만 찍는다

## project-setup T2

### .classpath

#### 개념 Lombok
##### 무엇
- Lombok은 컴파일할 때 getter, setter 같은 반복 코드를 대신 만들어 주는 라이브러리다
##### 왜
- 게임 물체마다 칸이 많다. 칸마다 setLeft, getDirection을 손으로 쓰면 읽을 코드가 길어진다
##### 쉬운 방법과 비교
- 손으로 getter, setter를 써도 똑같이 돈다. 4장에서 @Setter 한 줄이 메서드 하나를 대신하는 것을 본다
##### 헷갈리는 개념
- Lombok은 실행할 때가 아니라 컴파일할 때 일한다. 그래서 javac에 -processorpath로 넘기고, 이클립스에는 lombok.jar를 더블클릭해 설치한다
##### 이 예제에서는
- lib/lombok.jar를 라이브러리로 붙였다

#### 코드
- kind="lib"는 jar 파일을 라이브러리로 붙인다는 뜻이다

## game-window T1

### src/bubble/game/BubbleFrame.java

#### 개념 JFrame
##### 무엇
- JFrame은 제목 줄과 닫기 단추가 있는 창이다
##### 왜
- BubbleFrame이 JFrame을 상속하면 BubbleFrame 자체가 게임 창이 된다. setTitle처럼 창의 메서드를 바로 부른다
##### 쉬운 방법과 비교
- main에서 new JFrame()을 만들어 써도 된다. 창에 넣을 것이 많아지면 상속한 클래스 하나에 모으는 편이 읽기 쉽다
##### 이 예제에서는
- 생성자가 창을 준비하고 마지막에 setVisible(true)로 보인다

#### 코드
- setSize(1000, 640)은 창 바깥 크기다. 제목 줄까지 들어간 크기라 안쪽은 조금 작다
- setLocationRelativeTo(null)은 창을 화면 가운데 놓는다
- EXIT_ON_CLOSE가 없으면 창을 닫아도 프로그램이 계속 돈다

## game-window T2

### src/bubble/game/BubbleFrame.java

#### 개념 JLabel 배경
##### 무엇
- JLabel은 글자나 그림 한 장을 보여 주는 부품이다
- setContentPane은 창 안쪽 판을 바꾼다. 배경 그림을 가진 JLabel을 판으로 삼았다
##### 왜
- 판이 배경 그림이면 그 위에 플레이어와 벽돌을 add로 올리기만 하면 된다
##### 이 예제에서는
- background.png가 1000x640이라 판도 1000x640이 된다

#### 개념 절대 배치
##### 무엇
- setLayout(null)은 자동 배치를 끄는 것이다. 부품마다 x, y 좌표로 직접 놓는다
##### 왜
- 게임 물체는 매 순간 좌표가 바뀐다. 자동 배치는 버튼을 줄 세우는 데 맞고 게임에는 맞지 않는다
##### 헷갈리는 개념
- 배치를 끄면 부품마다 크기도 직접 정해야 한다. 크기가 없으면 보이지 않는다

#### 코드
- setSize 대신 pack을 썼다. 판의 크기에 창을 맞춰서 창 안쪽이 정확히 1000x640이 된다
- setResizable(false)는 창 크기를 못 바꾸게 막는다. 좌표가 늘 같은 자리를 가리킨다

## player T1

### src/bubble/game/Player.java

#### 개념 JLabel 상속
##### 무엇
- Player가 JLabel을 상속했다. 플레이어가 곧 그림 한 장이고, setLocation으로 옮기면 그림이 옮겨진다
##### 쉬운 방법과 비교
- BubbleFrame에서 JLabel 하나를 만들어 써도 지금은 똑같이 보인다
- 4장부터 움직임, 6장부터 중력이 붙는다. 그 코드를 둘 자리가 Player 클래스다
##### 이 예제에서는
- x, y 칸이 지금 자리다. 칸을 바꾼 뒤 setLocation(x, y)로 그림에 알린다

#### 개념 ImageIcon
##### 무엇
- ImageIcon은 파일에서 그림을 읽어 JLabel에 넣을 수 있게 한다
##### 헷갈리는 개념
- 경로 image/playerR.png는 실행한 폴더 기준이다. bubble 폴더에서 실행해야 그림이 보인다

#### 코드
- setSize(50, 50)은 그림 크기와 같다. 절대 배치라 크기를 직접 정한다

### src/bubble/game/BubbleFrame.java

#### 코드
- player를 칸으로 둔다. 뒤 장에서 키를 누를 때 이 player를 부른다
- add(player)는 배경 판 위에 플레이어를 올린다

## player-move T1

### src/bubble/game/Player.java

#### 코드
- moveLeft, moveRight는 x를 10 바꾸고 setLocation 한다

### src/bubble/game/BubbleFrame.java

#### 개념 KeyAdapter
##### 무엇
- 키를 누르고 떼는 일을 이벤트라고 한다. KeyListener가 그 이벤트를 받는다
- KeyAdapter는 KeyListener의 메서드를 빈 몸통으로 미리 채운 클래스다. 필요한 메서드만 고쳐 쓴다
##### 쉬운 방법과 비교
- KeyListener를 바로 구현하면 쓰지 않는 keyTyped까지 비워서 적어야 한다
##### 이 예제에서는
- 창에 addKeyListener로 붙였다. 창이 키를 받는다

#### 코드
- e.getKeyCode()는 누른 키의 번호다. KeyEvent.VK_LEFT가 왼쪽 화살표다
- case 화살표(->) 문법은 break를 쓰지 않아도 다음 case로 넘어가지 않는다
- 키를 꾹 누르면 한 번 움직이고 잠깐 멈췄다가 다시 움직인다. 운영체제의 키 반복 때문이다. 다음 단계에서 고친다

## player-move T2

### src/bubble/game/Player.java

#### 개념 Lombok
##### 이 예제에서는
- @Setter를 칸에 붙이면 setLeft(boolean)이 생긴다. 메서드를 쓰지 않았는데 BubbleFrame이 player.setLeft를 부른다
- 클래스 전체가 아니라 left, right 칸에만 붙였다. x 칸에 getter가 생기면 JLabel의 getX와 이름이 겹친다

#### 코드
- SPEED는 static final 상수다. 한 틱에 4씩 움직인다. 숫자를 한 곳에서 바꾼다
- move는 left, right 상태를 보고 움직인다. 키 이벤트가 아니라 루프가 부른다

### src/bubble/game/BubbleFrame.java

#### 개념 Timer 게임 루프
##### 무엇
- javax.swing.Timer는 정한 시간마다 같은 일을 부른다. 16ms마다면 1초에 약 60번이다
- 이렇게 계속 도는 반복을 게임 루프(game loop)라고 한다
##### 왜
- 앞 단계는 키 이벤트가 올 때만 움직여서 처음에 멈칫했다
- 이제 키는 누름, 뗌 상태만 바꾸고 움직임은 루프가 맡는다. 누르고 있는 동안 매 틱 4씩 간다
##### 쉬운 방법과 비교
- 물체마다 스레드를 만들어 while 문으로 돌려도 움직인다. 물체가 열 개면 스레드도 열 개라 순서가 꼬이고 화면이 깨지기 쉽다
- Timer 하나는 Swing 화면 스레드에서 돌아서 물체를 차례로 움직인다. 15장에서 timer.stop() 한 줄로 게임 전체를 멈춘다
##### 헷갈리는 개념
- java.util.Timer와 다르다. 이름이 같으니 import가 javax.swing.Timer인지 본다

#### 코드
- e -> player.move()는 람다다. 시간이 될 때마다 이 줄이 불린다
- keyReleased에서 false로 돌려놓아야 키를 떼면 멈춘다

## player-move T3

### src/bubble/game/Direction.java

#### 개념 Direction enum
##### 무엇
- enum은 정해진 값 몇 개만 가질 수 있는 타입이다. Direction은 LEFT, RIGHT 둘뿐이다
##### 쉬운 방법과 비교
- boolean lookLeft나 문자열 "left"로도 된다. 문자열은 오타가 나도 컴파일러가 못 잡는다
- 8장에서 물방울이, 10장에서 적군이 같은 Direction을 쓴다

### src/bubble/game/Player.java

#### 코드
- direction은 마지막으로 움직인 쪽이다. 키를 떼도 그쪽을 계속 본다
- direction에 따라 playerL, playerR 그림을 고른다

## wall-stop T1

### src/bubble/game/BubbleFrame.java

#### 개념 벽돌 그리기
##### 무엇
- 벽돌 하나는 40x20 그림을 가진 JLabel이다. for 문으로 여러 개를 놓아 벽을 쌓는다
##### 왜
- 벽돌을 놓는 일을 양쪽 벽과 뒤 장의 발판에서 되풀이한다. 그래서 addBrick 메서드로 나눴다
##### 헷갈리는 개념
- 먼저 add 한 부품이 위에 그려진다. 플레이어를 먼저 add 해서 벽돌 위에 보인다

#### 코드
- brickIcon 하나를 모든 벽돌이 같이 쓴다. 그림 파일을 한 번만 읽는다
- y를 0부터 620까지 20씩 늘리면 벽돌 32개가 한 줄로 선다

## wall-stop T2

### src/bubble/game/Player.java

#### 개념 이동 뒤 좌표 확인
##### 무엇
- 먼저 움직이고, 벽을 넘었으면 벽 앞으로 되돌린다
##### 쉬운 방법과 비교
- 움직이기 전에 if (x - SPEED >= 40)처럼 미리 막아도 된다. 속도가 바뀌면 조건마다 고쳐야 한다
- 뒤에 맞추면 얼마나 움직였든 마지막 자리만 보면 된다
##### 이 예제에서는
- 왼쪽 벽은 x 0~40, 오른쪽 벽은 960~1000이다. 플레이어 너비가 50이라 오른쪽 끝은 910이다

## floor-gravity T1

### src/bubble/game/BubbleFrame.java

#### 개념 Rectangle 목록
##### 무엇
- Rectangle은 x, y, width, height 네 값을 가진 사각형이다
- 발판마다 Rectangle 하나를 List에 담았다
##### 왜
- 같은 목록으로 벽돌을 그리고, 다음 단계에서 같은 목록으로 착지를 확인한다. 그림과 충돌이 어긋나지 않는다
##### 쉬운 방법과 비교
- 배경 그림에 발판을 그리고 색으로 충돌을 찾는 방법도 있다. 그러면 발판 자리가 그림에만 있어 코드에서 보이지 않는다

#### 코드
- 발판 너비는 40의 배수다. 벽돌이 딱 맞게 깔린다
- floor.x처럼 Rectangle의 칸을 바로 읽는다

## floor-gravity T2

### src/bubble/game/Player.java

#### 개념 중력
##### 무엇
- dy는 한 틱에 아래로 가는 거리, 곧 속도다. 매 틱 dy에 GRAVITY를 더하면 떨어질수록 빨라진다
##### 쉬운 방법과 비교
- 매 틱 y를 일정하게 늘리면 떨어지긴 하지만 무게감이 없다. 7장 점프에서 위로 쏜 속도가 줄어들다 바뀌는 것도 이 더하기 덕분이다

#### 개념 착지
##### 무엇
- above는 움직이기 전 발이 발판 위였는데 지금은 발판에 닿았거나 지나쳤다는 뜻이다
- across는 가로로 발판과 겹친다는 뜻이다
- 둘 다 맞으면 발판 위로 올려 세우고 dy를 0으로 한다
##### 왜
- 빨리 떨어지면 한 틱에 발판 두께보다 많이 내려간다. 지금 자리만 보면 발판을 뚫고 지나간다. 움직이기 전 자리와 함께 봐서 막는다

#### 코드
- 처음 자리를 y 40으로 바꿔 시작하자마자 떨어지는 모습을 본다

### src/bubble/game/BubbleFrame.java

#### 코드
- 람다를 중괄호로 바꿔 두 줄을 부른다. 좌우로 움직인 뒤 떨어진다

## player-jump T1

### src/bubble/game/Player.java

#### 개념 위로 향하는 속도
##### 무엇
- 점프는 dy에 음수를 넣는 것뿐이다. y가 줄어 올라가고, 중력이 dy를 1씩 키워 결국 내려온다
##### 이 예제에서는
- JUMP -18이면 약 150만큼 올라간다. 발판 사이 높이 130보다 조금 높다

#### 개념 발판 아래에서 올라타기
##### 무엇
- 올라갈 때는 움직이기 전 발이 발판 아래라 above가 거짓이다. 그래서 발판을 뚫고 올라간다
- 내려올 때 above가 참이 되어 그 위에 선다. 코드를 더하지 않았다

#### 코드
- onGround는 이번 틱에 발판에 섰는지다. 공중에서 다시 뛰지 못하게 막는다
- fall에서 먼저 false로 두고 발판에 세울 때만 true로 한다

### src/bubble/game/BubbleFrame.java

#### 코드
- 위 화살표는 누르는 순간 한 번 jump를 부른다. 떼는 일은 없어서 keyReleased에 넣지 않았다

## bubble-shoot T1

### src/bubble/game/Bubble.java

#### 코드
- 생성자가 Player를 받는다. 쏜 순간 플레이어의 자리와 방향을 물방울이 가져간다
- player.getX()는 JLabel이 가진 메서드다. 화면 위 지금 x를 준다

### src/bubble/game/Player.java

#### 코드
- @Getter를 direction에 붙여 getDirection()을 만든다

### src/bubble/game/BubbleFrame.java

#### 코드
- 스페이스를 누를 때마다 shoot이 새 물방울을 만든다. 아직 움직이지 않는다

## bubble-shoot T2

### src/bubble/game/BubbleFrame.java

#### 개념 리스트로 여러 물체 갱신
##### 무엇
- 물방울은 몇 개가 될지 모른다. List에 모아 두고 루프에서 for 문으로 하나씩 움직인다
##### 쉬운 방법과 비교
- 칸을 bubble1, bubble2로 만들면 개수가 정해진다. 세 번째를 쏘는 순간 둘 곳이 없다
##### 이 예제에서는
- 10장 적군도 같은 방법으로 enemies 목록에 담는다

#### 코드
- 루프에서 할 일이 늘어 tick 메서드로 뺐다. Timer는 tick만 부른다

### src/bubble/game/Bubble.java

#### 코드
- distance가 RANGE 300이 될 때까지 옆으로 날고, 그 뒤 y 20까지 2씩 떠오른다
- 벽 확인은 Player와 같다. 11장에서 한 곳으로 합친다

## bubble-pop T1

### src/bubble/game/Bubble.java

#### 코드
- time은 생긴 뒤 지난 틱 수다. LIFE 150을 넘으면 popped가 된다
- 물방울은 스스로 화면에서 빠지지 못한다. 상태만 바꾸고 지우는 일은 BubbleFrame이 한다

### src/bubble/game/BubbleFrame.java

#### 개념 remove와 repaint
##### 무엇
- remove는 판에서 부품을 뺀다. repaint는 판을 다시 그린다
##### 왜
- 빼기만 하면 그 자리에 그림이 남아 보일 수 있다. 다시 그려야 사라진다

#### 개념 removeIf
##### 무엇
- removeIf는 조건이 참인 것을 목록에서 한 번에 뺀다
##### 쉬운 방법과 비교
- for 문 안에서 bubbles.remove(bubble)을 부르면 ConcurrentModificationException이 난다. 돌고 있는 목록을 바꿔서다
- 그래서 for 문에서는 화면에서만 지우고, 끝난 뒤 removeIf로 목록에서 뺀다

## enemy T1

### src/bubble/game/Enemy.java

#### 코드
- 생성자가 x, y, direction을 받는다. 적군마다 서 있는 자리가 달라서다
- this.x = x는 같은 이름의 매개변수와 칸을 가른다

### src/bubble/game/BubbleFrame.java

#### 코드
- 적군 셋을 enemies 목록에 넣고 for 문으로 모두 add 한다

## enemy T2

### src/bubble/game/Enemy.java

#### 개념 혼자 걷는 물체
##### 무엇
- 적군은 키가 없다. move가 불릴 때마다 바라보는 쪽으로 SPEED만큼 간다
##### 이 예제에서는
- 루프의 tick이 적군마다 move와 fall을 부른다. 플레이어와 같은 길이다

#### 개념 벽에서 돌아서기
##### 무엇
- 벽을 넘었으면 벽 앞으로 맞추고 direction을 반대로 바꾼다. 다음 틱부터 반대로 걷는다

#### 코드
- fall은 Player의 fall을 옮겼다. 적군은 뛰지 않아 onGround 줄만 뺐다. 다음 장에서 합친다

## sprite-refactor T1

### src/bubble/game/Sprite.java

#### 개념 상속으로 겹치는 코드 합치기
##### 무엇
- Player, Enemy, Bubble은 모두 자리, 방향, 50x50 그림, 벽을 가진다. 이 공통을 부모 Sprite에 둔다
##### 왜
- 10장 Enemy의 fall은 Player와 거의 같다. 착지 버그를 고치려면 두 곳을 고쳐야 한다
##### 쉬운 방법과 비교
- 복사해 두어도 지금은 돈다. 물체 종류가 늘수록 같은 버그를 여러 번 고친다
##### 헷갈리는 개념
- 인터페이스는 할 일의 이름만 정하고 코드를 물려주지 않는다. 같은 코드를 나누려면 부모 클래스를 쓴다

#### 개념 protected
##### 무엇
- protected 칸은 자식 클래스가 바로 읽고 바꾼다. 밖의 다른 클래스는 바꾸지 못하게 할 때 쓴다
##### 헷갈리는 개념
- private이면 자식도 x를 못 쓴다. public이면 BubbleFrame도 x를 바꿀 수 있다. 자바에서는 같은 패키지도 protected 칸을 쓸 수 있다

#### 코드
- keepInWall은 벽 확인 네 줄을 한 메서드로 묶었다

### src/bubble/game/Player.java

#### 코드
- super(80, 40, Direction.RIGHT)가 부모 생성자를 부른다. 자리와 크기는 부모가 정한다
- 칸과 fall이 사라졌다. 동작은 그대로다

## sprite-refactor T2

### src/bubble/game/Enemy.java

#### 코드
- 벽에 닿았는지 보고 방향만 바꾼다. x 맞추기는 keepInWall이 한다
- fall이 사라졌다. tick의 enemy.fall(floors)는 부모의 fall을 부른다

## sprite-refactor T3

### src/bubble/game/Bubble.java

#### 코드
- super에 플레이어의 자리와 방향을 넘긴다
- 물방울은 떨어지지 않는다. 부모의 fall을 부르지 않으면 된다

## enemy-trap T1

### src/bubble/game/BubbleFrame.java

#### 개념 Rectangle intersects
##### 무엇
- getBounds()는 JLabel의 자리와 크기를 Rectangle로 준다
- intersects는 두 사각형이 조금이라도 겹치면 참이다
##### 쉬운 방법과 비교
- 두 물체의 x, y 차이를 직접 비교해도 된다. 조건 네 개를 손으로 쓰다 틀리기 쉽다

#### 코드
- 이미 터진 물방울과 이미 갇힌 적군은 건너뛴다. 물방울 하나가 적군 하나만 가둔다

### src/bubble/game/Enemy.java

#### 개념 상태 바꾸기
##### 무엇
- bubbled 칸 하나가 적군의 상태다. trap이 true로 바꾸고 그림도 갇힌 그림으로 바꾼다
##### 이 예제에서는
- 이 단계에서는 move가 그림을 다시 바꾸므로 갇혔으면 다시 갇힌 그림을 넣는다. 갇힌 채로 아직 걷는다

### src/bubble/game/Bubble.java

#### 코드
- pop은 popped를 true로 한다. 다음 지우기는 bubble-pop 장의 코드가 그대로 한다

## enemy-trap T2

### src/bubble/game/BubbleFrame.java

#### 코드
- 갇히지 않은 적군만 move와 fall을 부른다. 상태 하나로 루프가 다르게 움직인다

## enemy-pop T1

### src/bubble/game/Enemy.java

#### 코드
- popped와 pop은 Bubble과 같은 모양이다

### src/bubble/game/BubbleFrame.java

#### 개념 리스트에서 적군 지우기
##### 무엇
- 물방울 지우기와 같다. for 문에서 화면에서 빼고, 끝난 뒤 removeIf로 목록에서 뺀다

#### 코드
- 갇힌 적군에 닿을 때만 터진다. 갇히지 않은 적군에 닿는 일은 15장에서 만든다

## enemy-pop T2

### src/bubble/game/BubbleFrame.java

#### 개념 클리어
##### 무엇
- 적군 목록이 비면 이긴 것이다. enemies.isEmpty()로 안다

#### 개념 화면 맨 앞에 놓기
##### 무엇
- add(clear, 0)은 0번 자리에 넣는다. 절대 배치에서는 0번 부품이 가장 위에 그려진다
##### 쉬운 방법과 비교
- 이길 때 add(clear)를 부르면 맨 뒤에 들어가 벽돌과 펭귄에 가린다
##### 이 예제에서는
- 처음에 숨겨 맨 앞에 넣어 두고 이길 때 setVisible(true)만 부른다. 여러 번 불려도 같다

## bgm T1

### src/bubble/game/Sound.java

#### 개념 Clip으로 wav 반복 재생
##### 무엇
- AudioInputStream은 wav 파일을 읽은 소리 흐름이다
- Clip은 소리를 메모리에 올려 두고 재생, 반복, 멈춤을 하는 부품이다
- loop(Clip.LOOP_CONTINUOUSLY)는 끝나면 처음부터 끝없이 반복한다
##### 쉬운 방법과 비교
- BubbleFrame 안에 이 코드를 바로 써도 된다. 15장 게임오버 소리도 같은 코드라 Sound로 묶었다
##### 헷갈리는 개념
- 파일을 못 찾거나 소리 장치가 없으면 예외가 난다. 잡아서 출력만 하고 clip은 null로 남는다. 그래서 loop에서 null을 확인한다

### src/bubble/game/BubbleFrame.java

#### 코드
- 창이 준비된 뒤 배경음악을 튼다

## game-over T1

### src/bubble/game/BubbleFrame.java

#### 개념 게임 루프 멈추기
##### 무엇
- 모든 움직임이 Timer 하나에서 나온다. timer.stop()이면 게임 전체가 멈춘다
##### 왜
- 멈추려면 Timer를 붙잡아 둬야 한다. 그래서 지역 변수 대신 timer 칸에 담았다

#### 코드
- 갇히지 않은 적군에 닿으면 gameOver를 부르고 return으로 tick을 바로 끝낸다. 남은 적군을 더 보지 않아 gameOver가 두 번 불리지 않는다

### src/bubble/game/Player.java

#### 코드
- die는 쓰러진 그림으로 바꾼다. 루프가 멈춰 move가 그림을 다시 바꾸지 않는다

## game-over T2

### src/bubble/game/BubbleFrame.java

#### 코드
- CLEAR!와 같은 방법이다. 숨겨서 맨 앞에 넣고 gameOver에서 보인다

## game-over T3

### src/bubble/game/Sound.java

#### 개념 소리 한 번 재생
##### 무엇
- clip.start()는 한 번 재생하고 끝난다. loop와 같은 Clip의 다른 메서드다
- clip.stop()은 재생을 멈춘다

### src/bubble/game/BubbleFrame.java

#### 코드
- bgm을 칸으로 옮겼다. gameOver에서 멈추려면 붙잡아 둬야 한다
- 게임오버 소리는 한 번만 쓰므로 만들자마자 play 한다
