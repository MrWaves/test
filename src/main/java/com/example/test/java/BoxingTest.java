package com.example.test.java;
/**
  *@Author: Mr.Waves
  *@Date: 2019/12/9 10:25
  *@Package: com.example.test.java
  *@Description: 自动装箱开箱
  **/
public class BoxingTest {
    public static void main(String[] args) {
        test3();
    }

    //封装对象和原始数据进行比较，
    private static void test1(){
        int a=11;
        Integer b=11;  //autoboxing
        System.out.println(a==b);  //unboxing后比较大小  true
    }

    //-128~127会被提前缓存到IntegerCache的cache[]中
    private static void test2(){
        Integer a=11,b=11;  //autoboxing，a b指向同一对象
        System.out.println(a==b);  //true
    }

    private static void test3(){
        Integer a=1111,b=1111;  //autoboxing, a b指向不同对象
        System.out.println(a==b);  //false
    }
}
