package com.java8.ksm;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Example3 {

	public static void main(String[] args) {

		/** Lambda Expression **/
		System.out.println("==== LAMBDA EXPRESSION ====");

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
		

		/** Method Reference **/
		System.out.println("==== METHOD REFERENCE ====");
		// 1. 기본 static Method 참조 방법
		String str1 = CustomString.staticPrint("Animal");

		UnaryOperator<String> uo1 = CustomString::staticPrint;
		String str2 = uo1.apply("Animal");
		System.out.println(str1);
		System.out.println(str2);


		// 2. 기본 Method 참조 방법
		CustomString cs = new CustomString();
		String str3 = cs.name("Human");

		UnaryOperator<String> uo2 = cs::name;
		String str4 = uo2.apply("Human");
		System.out.println(str3);
		System.out.println(str4);


		// 3. 생성자를 호출하는 방법(입력값이 없는 생성자)
		CustomString cs2 = new CustomString();

		Supplier<CustomString> supplier = CustomString::new;
		CustomString cs3 = supplier.get();


		// 4. 생성자를 호출하는 방법(입력값이 있는 생성자)
		CustomString cs4 = new CustomString("Earth");

		Function<String, CustomString> function = CustomString::new;
		CustomString cs5 = function.apply("Earth");
	}

}
