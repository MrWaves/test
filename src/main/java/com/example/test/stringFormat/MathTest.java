package com.example.test.stringFormat;

public class MathTest {
    public static void main(String[] args) {
        test1();
    }

    //求算数平方根
    private static void test1() {
        double sqrt = Math.sqrt(10);
        System.out.println(String.format("%.2f",sqrt));
        System.out.println(sqrt%1==0);
    }
}
