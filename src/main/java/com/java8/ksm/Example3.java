package com.java8.ksm;

import java.util.function.UnaryOperator;

public class Example3 {

	public static void main(String[] args) {
		
		// 람다 표현식 기본 형식
		UnaryOperator<Integer> plus100_1 = (num) -> {
			return num+100;
		};
		
		// 인자가 하나일 경우, 인자쪽에 괄호 제거
		UnaryOperator<Integer> plus100_2 = num -> {
			return num+100;
		};
		
		// 리턴 식이 하나의 식일 경우 중괄호 및 return 생략 가능
		UnaryOperator<Integer> plus100_3 = num -> num+100;
		
		System.out.println(plus100_1.apply(50));
		System.out.println(plus100_2.apply(50));
		System.out.println(plus100_3.apply(50));
		

	}

}
