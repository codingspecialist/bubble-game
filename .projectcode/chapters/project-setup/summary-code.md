# project-setup 코드 요약

## T1 이클립스 프로젝트와 main 만들기
커밋: 1bd3083

| 파일 | 변경 |
|---|---|
| bubble/.classpath | 새로 |
| bubble/.project | 새로 |
| bubble/src/bubble/game/BubbleFrame.java | 새로 |

```xml
// bubble/.classpath
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-21"/>
	<classpathentry kind="output" path="bin"/>
</classpath>
```

```xml
// bubble/.project
<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>bubble</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
</projectDescription>
```

```java
// bubble/src/bubble/game/BubbleFrame.java
package bubble.game;

public class BubbleFrame {

	public static void main(String[] args) {
		System.out.println("버블 게임 준비");
	}
}
```

## T2 Lombok 붙이기
커밋: 0c77187

| 파일 | 변경 |
|---|---|
| bubble/.classpath | 고침 |
| bubble/lib/lombok.jar | 새로 |

```diff
// bubble/.classpath
@@ -2,5 +2,6 @@
 <classpath>
 	<classpathentry kind="src" path="src"/>
 	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-21"/>
+	<classpathentry kind="lib" path="lib/lombok.jar"/>
 	<classpathentry kind="output" path="bin"/>
 </classpath>
```

## T3 그림과 소리 파일 넣기
커밋: 034ba8f

| 파일 | 변경 |
|---|---|
| bubble/image/ | 새로 11개 |
| bubble/sound/ | 새로 2개 |

## T4 장 끝 코드를 ex01로 남기기
커밋: c2db631

| 파일 | 변경 |
|---|---|
| bubble/src/bubble/ex01/ | 복사 1개 |
