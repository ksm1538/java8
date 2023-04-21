package com.java8.ksm;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Example9 {
    public static void main(String[] args) {

        // 기계 시간으로 표현(현재 UTC(GMT) 반환)
        Instant now = Instant.now();
        System.out.println(now);

        // 현재 시스템(서울)의 지역에 맞는 시간을 보여주도록
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        // 현재 시스템 지역의 시간을 가져옴
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        // LocalDateTime.of 를 이용해서 시간 설정이 가능하다.
        LocalDateTime luckyDate =
                LocalDateTime.of(2077, Month.JULY, 7, 7, 7, 7);
        System.out.println(luckyDate);

        // 날짜만 표시할 때는 LocalDate
        LocalDate today = LocalDate.now();
        LocalDate myBirthDay = LocalDate.of(1996, Month.DECEMBER, 25);

        // Period.between 을 이용해서 두 날짜의 차이 확인
        Period period = Period.between(myBirthDay, today);
        System.out.println(period);

        // LocalDate.until() 을 이용해서도 Period 를 표현 가능
        Period period2 = today.until(myBirthDay);
        System.out.println(period2);

        // Duration
        // 현재시간에 +10일
        Instant instant2 = now.plus(10, ChronoUnit.HOURS);
        Duration between = Duration.between(now, instant2);
        System.out.println(between);


        /**** Date Format ****/
        // LocalDateTime 을 원하는 형식으로 표현
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        System.out.println(localDateTime.format(dateTimeFormatter));

        // String 형식의 날짜를 LocalDate 로 변경 (LocalDateTime, LocalTime 도 가능)
        LocalDate localDate = LocalDate.parse("1996.12.25", dateTimeFormatter);
        System.out.println(localDate);

    }
}
