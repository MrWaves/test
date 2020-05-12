package com.example.test.java;

/**
 * @Package: com.example.test
 * @Author: Mr.Waves
 * @Date: 2019/4/2 19:57
 * @Description: 精确小数计算
 **/
import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        test2();
    }

    /*
     * null
     */
    private static void test1() {
        Integer a = null;
        BigDecimal b = new BigDecimal(a);
        System.out.println(a);  // NullPointerException
    }

    /*
     * add
     */
    private static void test2() {
        BigDecimal a = new BigDecimal("0.00");
        a = a.add(new BigDecimal("2.45"));
        System.out.println(a);  // 2.45
    }
}
