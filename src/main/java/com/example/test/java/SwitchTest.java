package com.example.test.java;

import java.util.Arrays;
import java.util.List;

public class SwitchTest {
    public static void main(String[] args) {
        test1();
    }

    //test for switch break
    private static void test1(){
        for (int i=0;i<10;i++){
            switch (i){
                case 1:
                    System.out.println(i);
                    break;
                case 2:
                    System.out.println(i);
                    break;
                case 3:
                    System.out.println(i);
            }
        }
    }

    //Arrays.asList() 不能视作list
    private static void test2(){
        Integer i=1;
        List<String> missingFiles= Arrays.asList("撤场申请书","撤场程序表","售后承诺书","商户保证书","回访记录表");
        switch (i){
            case 1:
                missingFiles.remove("撤场申请书");
                break;
            case 2:
                missingFiles.remove("撤场程序表");
                break;
            case 3:
                missingFiles.remove("售后承诺书");
                break;
            case 4:
                missingFiles.remove("商户保证书");
                break;
            case 5:
                missingFiles.remove("回访记录表");
        }

    }

    //switch(string) 可行
    private static void test3() {
        switch ("1") {
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println(2);
                break;
        }

    }
}
