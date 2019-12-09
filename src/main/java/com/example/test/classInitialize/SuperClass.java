package com.example.test.classInitialize;

/**
 * @Author: bo.wang
 * @Date: 2018/1/8
 * @Project: test
 */
public class SuperClass {
    static {
        System.out.println("SuperClass static block.");
    }
    SuperClass(){
        System.out.println("SuperClass constructor.");
    }

    public static int value=111;

    {
        System.out.println("SuperClass block.");
    }
}
