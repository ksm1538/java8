package com.java8.ksm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example5 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("lion");
        animals.add("tiger");

        // 1. 원본 컬렉션인 animals에는 변경 X
        System.out.println("=====1=====");
        Stream<String> upperAnimalStream = animals.stream().map(String::toUpperCase);
        animals.forEach(System.out::println);

        // 2. 중개 Operation은 종료 Operation이 있어야 작동한다.
        System.out.println("=====2=====");
        // 종료 Operation이 없어서 작동은 안하고 정의만 내림
        animals.stream().map(s-> {
            System.out.println(s);
            return s.toUpperCase();
        });

        System.out.println("--------");
        // 종료 Operation이 있어서 작동
        List<String> upperCase = animals.stream().map(s -> {
            String upper = s.toUpperCase();
            System.out.println(upper);
            return upper;
        }).collect(Collectors.toList());
    }
}
