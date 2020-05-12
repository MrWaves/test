package com.example.test.concurrency;

import lombok.SneakyThrows;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    /*
     * thread.join()
     */
    private static void test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" start.");
        Thread thread = new Thread(new Runnable() {

            @Override
            @SneakyThrows
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start.");
                for (int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().getName() + " loop "+i);
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + " end.");
            }
        });
        thread.start();
        thread.join();
        System.out.println(Thread.currentThread().getName()+" end.");
    }

    /*
     * thread.yield()
     */
    private static void test2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" start.");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end.");
            }
        });



        thread.start();
        thread.yield();

        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " loop "+i);
            Thread.sleep(1000);
        }

        System.out.println(Thread.currentThread().getName()+" end.");
    }


    private static void test3(){
        ThreadLocal<String> stringThreadLocal=new ThreadLocal<>();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
               stringThreadLocal.set(Thread.currentThread().getName()); 
            }
        });


    }
}
