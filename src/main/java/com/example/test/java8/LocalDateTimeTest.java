package com.example.test.java8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        test();
    }

    private static void test(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String front = now.format(formatter);
        System.out.println(front);

    }
}
