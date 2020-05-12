package com.example.test.collection;


import com.example.test.java.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: bo.wang
 * @date: 2017/12/12
 * @project: test
 */
public class ListTest {
    public static void main(String[] args) {
        test1();
    }

    /*
     * remove() add()方法
     */
    private static void test1() {
        List<String> list = new ArrayList<>(Arrays.asList("a","b"));
        System.out.println(list.toString());  // [a, b]
        list.remove("a");
        System.out.println(list.toString());  // [b]
        list.add("a");
        System.out.println(list.toString());  // [b, a]
    }

    //测试
    private static void test2() {
        List<Double> list = new ArrayList();
        Double i=1.23;
        list.add(i);
        i = 2.34;
        System.out.println(list.toString());
        System.out.println(i);
    }

    //测试 通过引用修改集合元素
    private static void test3() {
        List<Student> list = new ArrayList();
        Student stu = new Student("zhangsan");
        list.add(stu);
        System.out.println(list.toString());
        stu.setName("lisi");
        System.out.println(list.toString());  //张三变李四
    }

    //测试 各种list集合
    private static void test4() {
        List list1=new ArrayList();
        List list2 = new LinkedList();
        List list3 = new Vector();
    }

    //asList()不能当作list操作
    private static void test5() {
        List<String> list = Arrays.asList("a", "b");
        list.remove("a");

    }

    //addAll(null) 会报空指针异常
    private static void test6() {
        List list = new ArrayList();
        list.addAll(null);
        System.out.println(list.size());
    }


    //list.remove()
    private static void test7(){
        List<String> list = Arrays.asList("天堂", "地狱","人间");
        list.remove("天堂");   //Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(list.toString());
    }

    //Arrays.stream(array).sorted().collect(Collectors.toList())   str.split()  String.join(" ",list)
    private static void test8() {
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

}
