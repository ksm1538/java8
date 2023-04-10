package com.java8.ksm;

@FunctionalInterface
public interface ExampleInterface1 {
	
	// 인터페이스에 추상 메서드가 하나만 있는 것을 '함수형 인터페이스'라고 한다.	(abstract 생략된 것임)
	// 다른 static, default 메서드는 상관 X
	// @FunctionalInterface 어노테이션을 추가하면, 함수형 인터페이스를 관리하기 수월해진다. (추상 메서드가 2개 이상이 되면 컴파일 단계에서 알려줌)
	abstract void doIt();
	
	static void print() {
		System.out.println("PRINT");
	}
	
	default void print2() {
		System.out.println("PRINT2");
	}
	
}
