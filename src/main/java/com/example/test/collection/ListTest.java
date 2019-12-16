package com.example.test.collection;

import com.example.test.jdbc.StuDTO;

import java.util.*;

/**
 * @Author: bo.wang
 * @Date: 2017/12/12
 * @Project: test
 */
public class ListTest {
    public static void main(String[] args) {
        test3();
    }

    //测试 remove() add()方法
    private static void test1() {
        List<String> list = new ArrayList<>(Arrays.asList("a","b"));
        System.out.println(list.toString());
        list.remove("a");
        System.out.println(list.toString());
        list.add("a");
        System.out.println(list.toString());
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
        List<StuDTO> list = new ArrayList();
        StuDTO stu = new StuDTO("zhangsan");
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

}
