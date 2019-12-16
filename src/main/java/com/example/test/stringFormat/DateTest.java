package com.example.test.stringFormat;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        test1();
    }

    //昨天日期
    private static void test1() {
        System.out.println(String.format("%tF",new Date(System.currentTimeMillis()-(long)24*3600*1000)));
    }
}
