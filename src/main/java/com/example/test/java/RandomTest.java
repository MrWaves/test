package com.example.test.java;

import java.util.Random;

/**
 * @Author: bo.wang
 * @Date: 2017/12/21
 * @Project:
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            test1();
        }
    }

    private static void test1() {
        Random random = new Random();
        // 0~9
        int i = random.nextInt(10);
        System.out.println(i);
    }
}
