package com.java8.ksm;

import java.util.Arrays;

@CustomAnnotation("JAVA")
@CustomAnnotation("PYTHON")
public class Example15 {
    public static void main(String[] args) {
        /** Annotation Value 가져오기 **/

        // 1. getAnnotationsByType 사용
        System.out.println("1. getAnnotationsByType 사용");
        CustomAnnotation[] customAnnotations = Example15.class.getAnnotationsByType(CustomAnnotation.class);
        Arrays.stream(customAnnotations).forEach(a -> {
            System.out.println(a.value());
        });

        // 2. CustomAnnotationBox 사용
        System.out.println("2. CustomAnnotationBox 사용");
        CustomAnnotationBox customAnnotationBox = Example15.class.getAnnotation(CustomAnnotationBox.class);
        Arrays.stream(customAnnotationBox.value()).forEach(a -> {
            System.out.println(a.value());
        });
    }
}
