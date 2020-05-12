package com.example.test.java8;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        test1();
    }

    /*
     * 列表重排序
     * collection.stream().sort().forEach()
     */
    private static void test1() {
        List<String> list = Arrays.asList("c","d","a", "b", "c");
        list.stream().sorted((a,b)->{
            return a.compareTo(b);
        }).forEach(System.out::println);
    }
}
