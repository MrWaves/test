package com.example.test.classInitialize;

/**
 * @Author: bo.wang
 * @Date: 2018/1/8
 * @Project: test
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass static block.");
    }

    SubClass(){
        System.out.println("SubClass constructor.");
    }

    {
        System.out.println("SubClass block");
    }
}
