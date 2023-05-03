package com.java8.ksm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface CustomAnnotationBox {
    CustomAnnotation[] value();         // CustomAnnotation 사용
}
