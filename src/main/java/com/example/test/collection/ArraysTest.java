package com.example.test.collection;

import org.json.JSONArray;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: bo.wang
 * @Date: 2018/1/5
 * @Project: test
 */
public class ArraysTest {
    public static void main(String[] args) {
        test2();
    }

    //list.toArray()
    private static void test1() {
        List<String> list = Arrays.asList("a", "b", "c");
        String[] arr = (String[])list.toArray();

        System.out.println(arr[0]);  //b
    }

    //数组元素是值传递
    private static void test2() {
      Long[] array={0l,1l,2l};
        Long s = array[1];
        array[1]=3l;
        System.out.println(s);  //1  数组发生变化，s没有感知
        System.out.println(array[1]);  //3

    }

}
