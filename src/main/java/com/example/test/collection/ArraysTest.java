package com.example.test.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: bo.wang
 * @Date: 2018/1/5
 * @Project: test
 */
public class ArraysTest {
    public static void main(String[] args) {
        test3();
    }

    //list.toArray()
    private static void test1() {
        List<String> list = Arrays.asList("a", "b", "c");
        String[] arr = (String[])list.toArray();

        System.out.println(arr[0]);  //b
    }

    /*
     * 数组元素是值传递(复制)
     */
    private static void test2() {
        Long[] array={0L,1L,2L};
        Long s = array[1];
        array[1]=3L;
        System.out.println(s);  // 1: 数组发生变化，s没有感知
        System.out.println(array[1]);  // 3

    }

    /*
     * Arrays.sort()
     * Arrays.toString()
     */
    private static void test3() {
        String[] arr = new String[]{"abd", "ced", "234"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));  // [234, abd, ced]
    }

}
