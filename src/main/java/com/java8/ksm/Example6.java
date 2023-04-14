package com.java8.ksm;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example6 {
    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        list1.add(new Person(1, "Gabriel", true));
        list1.add(new Person(2, "Abbey", false));
        list1.add(new Person(3, "Daisy", true));
        list1.add(new Person(4, "Fabiola", false));
        list1.add(new Person(5, "Jack", true));
        list1.add(new Person(6, "Macy", false));
        list1.add(new Person(7, "Olivia", true));

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person(8, "Rachael", true));
        list2.add(new Person(9, "Sally", false));
        list2.add(new Person(10, "Wayne", true));

        List<List<Person>> allList = new ArrayList<>();
        allList.add(list1);
        allList.add(list2);

        // filter를 이용
        System.out.println("== list1에서 name 이 A로 시작하는 리스트 ==");
        list1.stream().filter(p->p.getName().startsWith("A")).forEach(System.out::println);

        System.out.println("== list1에서 isAdult가 false인 Person의 id만 출력 ==");
        // Predicate.not() : Predicate 구문에서 !와 같은 역할
        list1.stream().filter(Predicate.not(Person::isAdult)).forEach(p-> System.out.println(p.getId()));

        System.out.println("== list1에서 모든 name 출력 ==");
        // map 이용
        list1.stream().map(p->p.getName()).forEach(System.out::println);

        System.out.println("== allList에서 모든 name 출력 ==");
        // flatMap : List안에 있는 List를 제거하고 안에 있는 알맹이만 취급할 수 있도록 도와주는 역할
        allList.stream().flatMap(list -> list.stream()).forEach(p-> System.out.println(p.getName()));

        System.out.println("== allList에서 이름에 s가 들어가는 학생이 있는지 확인 ==");
        boolean isExist = allList.stream().flatMap(list -> list.stream()).anyMatch(p -> p.getName().contains("s"));
        System.out.println(isExist);

        System.out.println("== allList에서 성인만 추출해서 리스트 만들기 ==");
        List<Person> collect = allList.stream().flatMap(list -> list.stream()).filter(p -> p.isAdult()).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("== 5부터 1씩 증가하는 무한 stream에서 앞에 5개 빼고, 5개까지만 보여주기 ==");
        Stream.iterate(5, num->num+1)
                .skip(5)
                .limit(5)
                .forEach(System.out::println);
    }
}


