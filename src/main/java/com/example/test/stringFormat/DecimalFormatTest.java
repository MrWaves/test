package com.example.test.stringFormat;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * @Author: bo.wang
 * @Date: 2017/12/25
 * @Project: test
 */
public class DecimalFormatTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int i=4,j=7;
        DecimalFormat df=new DecimalFormat("0.00");
        String str=df.format((float)i/j);
        System.out.println(str);
    }


}
