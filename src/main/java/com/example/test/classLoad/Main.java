package com.example.test.classLoad;

/**
 * @Author: bo.wang
 * @Date: 2018/1/8
 * @Project: test
 */
public class Main {
    public static void main(String[] args) {
        /*
         * 父类静态代码块 -> 子类静态代码块 -> 父类代码块 -> 父类构造器 -> 子类代码块 -> 子类构造器
         * SuperClass static block.
         * SubClass static block.
         * SuperClass block.
         * SuperClass constructor.
         * SubClass block.
         * SubClass constructor.
         */
        SuperClass subClass=new SubClass();
    }
}
