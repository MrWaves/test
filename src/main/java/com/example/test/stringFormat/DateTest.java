package com.example.test.stringFormat;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String date = String.format("%tF", new Date(System.currentTimeMillis() - (long) 24 * 3600 * 1000));
        System.out.println(date);  // 2020-04-18
    }

    private static void test2(){
        String date = String.format("%tF %<tT",new Date());
        System.out.println(date);  // 2020-04-19 18:31:09
    }
}
