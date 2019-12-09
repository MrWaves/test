package com.example.test.java8;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: bo.wang
 * @Date: 2017/12/13
 * @Project: test
 */
public class ForEachTest {
    public static void main(String[] args) {
        test3();
    }

    private static void test1(){
        List<String> list = Arrays.asList("a", "b", "c");
        int i=0;
        while (i<3){
            for (String element:list) {
                System.out.println(element);
                if (element.equals("b")) {
                    break;
                }
            }
            i++;
        }
    }

    private static void test2(){
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("a", "b", "c");

        list1.forEach(i->{
            for (String j:list2){
                if (i.equals(j)){
                    break;
                }
                System.out.println(i+j);
            }

        });
    }

    private static void test3(){
        List<String> list = Arrays.asList("a", "b", "c");
        for (String str:list) {
            System.out.println(str);
        }
    }
}
