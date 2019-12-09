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
        test();
    }

    private static void test() {
        BigDecimal a = new BigDecimal(0);
        a=a.add(new BigDecimal("2.5"));  //0+2.5=2.5
        System.out.println(a);

    }
}
