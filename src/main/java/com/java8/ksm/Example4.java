package com.java8.ksm;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Example4 {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);

        // 일반적인 for문
        for(int num : numList)
            System.out.println(num);

        // forEach는 Consumer 함수형 인터페이스가 사용
        // 1. 람다표현식 방식
        numList.forEach((num)-> System.out.println(num));

        // 2. 메서드 레퍼런스 방식
        numList.forEach(System.out::println);


        // spliterator
        Spliterator<Integer> spliterator = numList.spliterator();
        while (spliterator.tryAdvance(System.out::println));


        // removeIf
        numList.removeIf(num->num == 2);
        numList.forEach(System.out::println);
    }
}
