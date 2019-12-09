package com.example.test.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    static AtomicInteger i = new AtomicInteger(1);
    static Object lock=new Object();

    public static void main(String[] args) {
        test1();
    }

    //AtomicInteger 多线程有序自增
    private static void test1() {
        for (int j=0;j<4;j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k=0;k<25;k++) {
                        synchronized (lock) {
                            System.out.println(Thread.currentThread().getName()+" : "+i.getAndIncrement());
                        }
                    }

                }
            }).start();
        }
    }
}
