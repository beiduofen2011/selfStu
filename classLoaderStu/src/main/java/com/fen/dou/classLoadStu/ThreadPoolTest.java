package com.fen.dou.classLoadStu;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {
    private static volatile AtomicInteger atomicInteger = new AtomicInteger();
    private static volatile Object object = new Object();
    public static void main(String[] args) {

        new Thread(()->{
            synchronized (object) {
                while (atomicInteger.get() != 3){
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
                    while (atomicInteger.get() != 2){
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
                while (atomicInteger.get() != 1){
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
                while (atomicInteger.get() != 0){
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
