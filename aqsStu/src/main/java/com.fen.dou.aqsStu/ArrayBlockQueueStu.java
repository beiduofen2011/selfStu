package com.fen.dou.aqsStu;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockQueueStu {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayBlockingQueue.add("aaaa");
        }).start();

        new Thread(()->{
            try {
                while (true){
                    String s = (String) arrayBlockingQueue.take();
                    System.out.println("---------------"+s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
