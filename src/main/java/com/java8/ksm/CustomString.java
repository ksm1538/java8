package com.java8.ksm;

public class CustomString {
    private String str;

    public CustomString() {}

    public CustomString(String str){
        this.str = str;
    }

    public String name(String str) {
        return "name : " + str;
    }

    public static String staticPrint(String str) {
        return "staticPrint : " + str;
    }

    public String getStr() {
        return str;
    }
}
