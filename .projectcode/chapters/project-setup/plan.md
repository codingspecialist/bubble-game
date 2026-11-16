# project-setup 계획

## 파일
| 파일 | 새로 또는 고침 | 하는 일 |
|---|---|---|
| bubble/.project | 새로 | 이클립스 자바 프로젝트 설정 |
| bubble/.classpath | 새로 | src, bin, Java 21, lombok.jar 연결 |
| bubble/src/bubble/game/BubbleFrame.java | 새로 | main에서 준비 글자를 찍는다 |
| bubble/lib/lombok.jar | 새로 | Lombok 1.18.48 |
| bubble/image/*.png | 새로 | 그림 11장 |
| bubble/sound/*.wav | 새로 | 배경음악과 게임오버 소리 |
| bubble/src/bubble/ex01/BubbleFrame.java | 새로 | 장 끝 코드 |

## 코드 계획
BubbleFrame.java
- 패키지는 bubble.game이다
- main에서 System.out.println으로 버블 게임 준비를 찍는다

.classpath
- 소스 src, 출력 bin, JRE는 JavaSE-21, 라이브러리 lib/lombok.jar

그림
- tools/make-images.py가 만든 파일을 둔다
- playerR, playerL, playerDie, enemyR, enemyL, enemyBubbled, bubble은 50x50이다
- brick은 40x20, background는 1000x640, gameover와 clear는 가로 500이다

소리
- tools/make-sounds.py가 만든 bgm.wav, gameover.wav를 둔다

ex01
- BubbleFrame.java를 복사하고 패키지만 bubble.ex01로 바꾼다

## 핵심 코드
public static void main(String[] args) {
    System.out.println("버블 게임 준비");
}

## 할 일 연결
| 할 일 | 파일 |
|---|---|
| S1 | .project, .classpath |
| S2 | BubbleFrame.java |
| S3 | lib/lombok.jar, .classpath |
| S4 | image, sound |
| S5 | ex01/BubbleFrame.java |

## 라이브러리
- Lombok 1.18.48. contract.md에 있다

## 다른 장 파일
- 없음
