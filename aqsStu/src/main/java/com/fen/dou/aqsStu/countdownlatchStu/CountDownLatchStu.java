package com.fen.dou.aqsStu.countdownlatchStu;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchStu {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for(int i = 0; i <20 ; i++){
            new Thread(()->{
                try {
                    countDownLatch.await();
                    System.out.println("-------------"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"yc"+i).start();
        }

        new Thread(()->{
            for(int i = 0 ; i <5 ; i++ ){
                countDownLatch.countDown();
                try {
                    System.out.println("----i等于------"+(i+1));
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
