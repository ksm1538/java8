package com.java8.ksm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Example7 {
    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        Person examplePerson = new Person(1, "Gabriel", true);
        examplePerson.setFriend(new Person(4, "Fabiola", false));
        list1.add(examplePerson);
        list1.add(new Person(2, "Abbey", false));

        // filter 로 찾은 결과를 컬렉션이 아닌 객체 하나로 반환하는 경우, Optional로 반환한다.
        // why? filter 로 찾은 결과가 있을 수도 없을 수도 있기 때문.
        Optional<Person> nameG = list1.stream()
                .filter(p -> p.getName().startsWith("G"))
                .findFirst();


        System.out.println("== nameG 에 값이 있으면 true로 ==");
        System.out.println(nameG.isPresent());

        System.out.println("== nameG 에 값이 있으면 출력 == ");
        // 1. get() 을 이용한 방법. get() 을 이용하려면 안전하게 값이 있는 지 체크하고 get()을 쓰는 게 좋다.
        if(nameG.isPresent()) {
            Person personNameA = nameG.get();
            System.out.println(personNameA);
        }

        // 2. ifPresent() 를 이용한 방법
        nameG.ifPresent(p -> System.out.println(p));

        System.out.println("== nameG 에 값이 없으면 p2 출력 == ");
        Person p2 = new Person(3, "Daisy", true);
        System.out.println(nameG.orElse(p2));

        System.out.println("== Optional 값 안에 Optional 인스턴스가 있을 때 ==");
        // 1. map 이용
        Optional<Optional<Person>> person = nameG.map(p -> p.getFriend());
        Optional<Person> person1 = person.map(p -> p.get());
        System.out.println(person1);

        // 2.flatMap 이용
        Optional<Person> person2 = nameG.flatMap(p -> p.getFriend());
        System.out.println(person2);
    }
}
