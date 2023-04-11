package com.java8.ksm;

import java.util.function.*;

public class Example2 {
	public static void main(String[] args) {
		
		/** Function<T, R> **/
		System.out.println("Function");
		// 1. apply
		Function<Integer, Integer> plus50 = (num) -> num+50;
		System.out.println(plus50.apply(10));

		Function<Integer, Integer> divide = (num) -> num/2;
		System.out.println(divide.apply(10));
		
		// 2. compose
		// compose 메서드 안에 있는 인자가 먼저 실행됨. (아래에서는 divide)
		Function<Integer, Integer> divideAndPlus50 = plus50.compose(divide);
		System.out.println(divideAndPlus50.apply(10));
		
		// 3.andThen
		// compose 와 순서가 반대.
		Function<Integer, Integer> plus50AndDivide = plus50.andThen(divide);
		System.out.println(plus50AndDivide.apply(10));
		
		
		
		/** UnaryOperator **/
		System.out.println("UnaryOperator");
		UnaryOperator<Integer> plus500 = (num) -> num+500;
		System.out.println(plus500.apply(10));
		
		
		
		/** Consumer **/
		System.out.println("Consumer");
		Consumer<Integer> doPrint = i -> System.out.println(i);
		doPrint.accept(30);
		
		
		
		/** Supplier **/
		System.out.println("Supplier");
		Supplier<Integer> get100 = () -> 100;
		System.out.println(get100.get());
		
		
		
		/** Predicate**/ 
		System.out.println("Predicate");
		Predicate<Integer> isEqual50 = (num) -> num==50;		// 50과 다르면 false, 같으면 true 반환
		System.out.println(isEqual50.test(100));
	}
	

}
