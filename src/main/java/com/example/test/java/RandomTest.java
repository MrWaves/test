package com.example.test.java;

import java.util.Random;

/**
 * @Author: bo.wang
 * @Date: 2017/12/21
 * @Project: test
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            test1();
        }
    }

    private static void test1() {
        Random random = new Random();
        int i = random.nextInt(1);
        System.out.println(i);
    }
}
