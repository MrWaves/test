package com.example.test.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        test3();
    }

    /*
     * 有格式输出时间
     */
    private static void test1(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = now.format(formatter);
        System.out.println(time);  //2019-12-16 17:25:23

    }

    /*
     * 无格式输出时间
     */
    private static void test2() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));

        System.out.println(now);  //2019-12-16T17:26:33.152
    }

    /*
     * 输出日期
     */
    private static void test3() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        System.out.println(date);   // 2020-01-01
    }
}
