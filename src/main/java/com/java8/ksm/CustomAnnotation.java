package com.java8.ksm;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(CustomAnnotationBox.class)      // 어디에서 사용될 건지
public @interface CustomAnnotation {
    String value();
}
