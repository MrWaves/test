package com.example.test.collection;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Stack<Integer> stack=new Stack<>();
        stack.push(5);
        stack.push(3);

        System.out.println(-(stack.pop()-stack.pop()));
    }
}
