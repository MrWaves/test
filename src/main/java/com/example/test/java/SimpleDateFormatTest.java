package com.example.test.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        test1();
    }


    //parse ""
    private static void test1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse("");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
