package com.example.test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: bo.wang
 * @Date: 2017/12/12
 * @Project: test
 */
public class StringTest {
    public static void main(String[] args) {
        test8();
    }

    //string.split()
    private static void test1(){
        String str = "a b c";
        String[] arr = str.split(" ");
        List<String> list = Arrays.asList(arr);
        System.out.println(list.toString());
    }

    //集String.join("",list)
    private static void test2(){
        List<String> list = Arrays.asList("a", "b", "c");
        String str = String.join(",", list);
        System.out.println(str);
    }

    //String.format()
    private static void test3() {
        // %d: int转换符    05:5位整数，不足位用0补齐
        String str1 = String.format("%05d", 39);
        // %f：float转换符    .2: 小数点后保留2位
        String str2 = String.format("%.2f", 561.456);
        // %x: 16进制转换符    #: f则保留小数点，x则添加0x，o则添加0
        String str3 = String.format("%#x", 100);
        //%t: 日期转换符    F: yyyy-MM-dd    T: HH:mm:ss    <: 使用上一个转换符的参数
        Date date = new Date();
        String str4 = String.format("%tF %<tT", date);
        List<String> strings = Arrays.asList(str1, str2,str3,str4);
        strings.forEach(str->{
            System.out.println(str);
        });
    }

    //String.join()方法
    private static void test4(){
        List<String> list=new ArrayList<>();
//        list.add("a");
//        list.add("b");
        String str = String.join("、", list);
        System.out.println(str.equals(""));

    }

    //list.remove()
    private static void test5(){
        List<String> list = Arrays.asList("天堂", "地狱","人间");
        list.remove("天堂");   //Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(list.toString());
    }

    //Arrays.stream(array).sorted().collect(Collectors.toList())   str.split()  String.join(" ",list)
    private static void test6() {
        String string="i am student";
        String[] arr = string.split(" ");
        List<String> collect = Arrays.stream(arr).sorted((a, b) -> {
            if (a.length()>b.length())
                return -1;
            if (a.length()<b.length())
                return 1;
            return 0;

        }).collect(Collectors.toList());
        System.out.println(String.join(" ",collect));

    }

    //string.intern()
    private static void test7() {
//        String str1=new StringBuilder("ja").append("va").toString();
//        System.out.println(str1.intern()==str1);  //false str1指向堆  str1.intern()指向方法区

        String str2=new StringBuilder("天").append("堂").toString();  //指向堆
//        System.out.println(str2.intern()==str2);  //true JDK1.7后 ，常量池中不需要再存储一份对象了，可以直接存储堆中的引用
        String str3="天堂";  //如果常量池已有（值或者引用），指向已有的；没有的话，新生成一个
        System.out.println(str2==str3);
        System.out.println(str2.intern()==str3);
    }

    //++i+""
    private static void test8() {
        int i=2;
        System.out.println(++i+"");
    }

}
