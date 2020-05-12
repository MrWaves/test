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

    /*
     * 封装对象和原始数据进行比较时，会自动开箱后再比较数值
     */
    private static void test1(){
        int a=11;
        // autoboxing
        Integer b=11;
        System.out.println(a==b);  // true
    }

    /*
     * 值为-128~127的Integer在容器启动时就被缓存到IntegerCache的缓存中了
     */
    private static void test2(){
        Integer a=11,b=11;
        System.out.println(a==b);  // true
    }

    private static void test3(){
        // autoboxing, a b指向不同对象
        Integer a=1111,b=1111;
        System.out.println(a==b);  // false
    }
}
