package com.java8.ksm;

import java.util.Date;

public class Example8 {
    public static void main(String[] args) throws InterruptedException {

        Date now = new Date();
        long time = now.getTime();

        System.out.println(time);             // 기계용 시간

        System.out.println(now);
        Thread.sleep(1000*2);           // 2초 멈춤
        Date DateSec2 = new Date();
        System.out.println(DateSec2);

        DateSec2.setTime(time);               // 시간을 자유자재로 설정할 수 있음(mutable함)
        System.out.println(DateSec2);
    }
}
