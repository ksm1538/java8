package com.java8.ksm;

import java.lang.annotation.Annotation;
import java.util.function.Function;

public class Example2 {
	public static void main(String[] args) {
		Function<Integer, Integer> plus50 = (num) -> num+50;
		System.out.println(plus50.apply(10));

		Function<Integer, Integer> divide = (num) -> num/2;
		System.out.println(divide.apply(10));
	}

}
