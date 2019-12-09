package com.example.test.java;

/**
  *@Author: Mr.Waves
  *@Date: 2019/12/9 10:24
  *@Package: com.example.test.java
  *@Description: 泛型
  **/
public class GenericityTest {
    public static void main(String[] args) {
//        test1(new B());

        Box<B> bBox = new Box<>();
        bBox.test2(new Box<A>());
    }

    static class A {
    }

    static class B extends A{

    }

    static class C extends B{
    }

    //<T extends A>表示T是A的子孙类
    private static <T extends A> void test1(T t) {
        System.out.println(t.getClass().getName());
    }

    static class Box<T> {
        //<? super A>表示?是A的父系类，?是通配符，指代t的实际类型
        public void test2(Box<? super T> t) {
            System.out.println(t.getClass().getName());
        }
    }
}
