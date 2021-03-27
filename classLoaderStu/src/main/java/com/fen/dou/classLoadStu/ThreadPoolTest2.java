package com.fen.dou.classLoadStu;

import java.util.concurrent.CountDownLatch;

public class ThreadPoolTest2 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        CountDownLatch countDownLatch3 = new CountDownLatch(1);

        new Thread(()->{

            try {
                countDownLatch3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------D---------");
        },"D").start();

        new Thread(()->{
            try {
                countDownLatch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------C----------");
            countDownLatch3.countDown();
        },"C").start();

        new Thread(()->{
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------B----------");
            countDownLatch2.countDown();
        },"B").start();
        new Thread(()->{
            System.out.println("------------A----------");
            countDownLatch1.countDown();
        },"A").start();
    }
}
