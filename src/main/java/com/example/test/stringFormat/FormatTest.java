package com.example.test.stringFormat;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * @Author: bo.wang
 * @Date: 2017/12/25
 * @Project: test
 */
public class FormatTest {
    public static void main(String[] args) {
        test3();
    }

    private static void test1() {
        int i=4,j=7;
        DecimalFormat df=new DecimalFormat("0.00");
        String str=df.format((float)i/j);
        System.out.println(str);
    }

    //date(year-month-day)
    private static void test2(){
        String str = String.format("%tF",new Date());
        System.out.println(str);
    }

    //date(year-month-day) time(24)
    private static void test3(){
        String str = String.format("%tF %<tT",new Date());
        System.out.println(str);
    }
}
