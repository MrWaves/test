package com.example.test.stringFormat;

import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        test1();
    }

    //正则判断数字与否
    private static void test1() {
        Pattern pattern=Pattern.compile("[0-9]*");
        boolean result = pattern.matcher("015").matches();
        System.out.println(result);
        System.out.println(Integer.parseInt("015"));
    }

    private static void test2() {
        Pattern pattern=Pattern.compile("[\\+\\-\\*\\/]");
        System.out.println(pattern.matcher("8").matches());
    }
}
