package com.example.stu.dduothread;


import lombok.SneakyThrows;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
               Thread.sleep(50000);
               new Foo().first();
            }
        },"y1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------currentThreadName---thread2----"+Thread.currentThread().getName());
                new Foo().second();
            }
        },"y2");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------currentThreadName---thread3----"+Thread.currentThread().getName());
                new Foo().third();
            }
        },"y3");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }
}
