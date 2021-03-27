package com.fen.dou.classLoadStu;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest3 {
    private static volatile AtomicInteger atomicInteger = new AtomicInteger();
    private static volatile Object object = new Object();
    public static void main(String[] args) {
        for(int i=0 ; i<4;i++){
            new Thread(()->{
                synchronized (object) {
                    while (atomicInteger.get() % 4 != 3){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("------------D----------");
                    object.notifyAll();
                    atomicInteger.incrementAndGet();
                }
            },"D").start();

            new Thread(()->{
                synchronized (object) {
                    synchronized (object) {
                        while (atomicInteger.get() % 4  != 2){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("------------C----------");
                        object.notifyAll();
                        atomicInteger.incrementAndGet();
                    }
                }
            },"C").start();

            new Thread(()->{
                synchronized (object) {
                    while (atomicInteger.get() % 4  != 1){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("------------B----------");
                    object.notifyAll();
                    atomicInteger.incrementAndGet();
                }
            },"B").start();
            new Thread(()->{
                synchronized (object) {
                    while (atomicInteger.get() % 4  != 0){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("------------A----------");
                    object.notifyAll();
                    atomicInteger.incrementAndGet();
                }
            },"A").start();
        }
    }
}
