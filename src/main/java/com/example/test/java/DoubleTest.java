package com.example.test.java;

public class DoubleTest {
    public static void main(String[] args) {
        test1();
    }

    /*
     * double会有小量的精度损失，建议用BigDecimal替换
     */
    private static void test1() {
        double v = Double.parseDouble("1");
        double v1 = Double.parseDouble("1.5");
        System.out.println(v/v1);

        System.out.println((float) 3/2);
    }
}
