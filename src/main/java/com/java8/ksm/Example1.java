package com.java8.ksm;

public class Example1 {

	public static void main(String[] args) {
		
		/** 함수형 인터페이스의 추상 메서드를 정의하는 방법 **/
		
		// 기존의 익명 내부 클래스 방식 (anonymous inner class)
		ExampleInterface1 interface1 = new ExampleInterface1() {
			@Override
			public void doIt() {
				// TODO Auto-generated method stub
				System.out.println("doIt1 !!!");
			}
		};
		interface1.doIt();
		
		// 람다 표현식 방식 (lambda Expression)
		ExampleInterface1 interface2 = () -> System.out.println("doIt2 !!!");
		interface2.doIt();
	}

}
