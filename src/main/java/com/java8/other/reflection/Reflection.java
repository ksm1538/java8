package com.java8.other.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // 1. {클래스 이름}.class
        Class<?> clazz1 = Person.class;

        // 2. {인스턴스}.getClass()
        Person person = new Person("김멍목", 28);
        Class<?> clazz2 =  person.getClass();

        // 3.Class.forName("클래스 주소")
        Class<?> clazz3 = Class.forName("com.java8.other.reflection.Person");

        // .getConstructor() 를 이용해서 생성자를 가져올 수 있으며, 파라미터에 따라 생성자를 구분 가능
        Constructor<?> declaredConstructor1 = clazz2.getDeclaredConstructor();
        Constructor<?> declaredConstructor2 = clazz2.getDeclaredConstructor(String.class, int.class);
        Object instance = declaredConstructor2.newInstance("멍목2", 7);       // 방금 알아낸 생성자로 인스턴스 생성
        System.out.println(instance.toString());


        // Class 로 가져온 private 메서드를 실행해보기
        Method method = clazz2.getDeclaredMethod("privatePrint");
        method.setAccessible(true);     // 접근제어자 신경쓰지 않겠다.
        System.out.println(method.getName());
        method.invoke(person);        // 해당 메서드 실행
    }
}
