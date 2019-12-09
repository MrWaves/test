package com.example.test.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: bo.wang
 * @Date: 2017/12/12
 * @Project: test
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.forEach(element->{
            System.out.println(element);
        });

    }
}
