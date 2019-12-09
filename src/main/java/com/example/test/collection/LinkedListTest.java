package com.example.test.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: bo.wang
 * @Date: 2017/12/14
 * @Project: test
 */
public class LinkedListTest {
    public static void main(String[] args) {
        test2();
    }

    //addLast() remove()
    private static void test1() {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.remove("a");
        list.addLast("a");
        System.out.println(list.toString());
    }

    //iterator
    private static void test2() {
        LinkedList<String> list = new LinkedList<>();
        list.addAll(Arrays.asList("a", "b", "c"));
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String next = itr.next();
            if ("a".equals(next)) {
                itr.remove();
//                itr.remove();  //java.lang.IllegalStateException
            }
        }
        System.out.println(list);
    }
}
