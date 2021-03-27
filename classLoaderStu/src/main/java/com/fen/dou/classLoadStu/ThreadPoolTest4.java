package com.fen.dou.classLoadStu;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest4 {
    private static volatile AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {
            new Thread(()->{
                for(;;) {
                    if(atomicInteger.get()  == 3){
                        System.out.println("------------D----------");
                        atomicInteger.incrementAndGet();
                        break;
                    }
                }
            },"D").start();

            new Thread(()->{
                for(;;) {
                    if(atomicInteger.get()  == 2){
                        System.out.println("------------C----------");
                        atomicInteger.incrementAndGet();
                        break;
                    }
                }
            },"C").start();

            new Thread(()->{
                for(;;) {
                    if(atomicInteger.get()  == 1){
                        System.out.println("------------B----------");
                        atomicInteger.incrementAndGet();
                        break;
                    }
                }
            },"B").start();
            new Thread(()->{
                for(;;) {
                    if(atomicInteger.get()  == 0){
                        System.out.println("------------A----------");
                        atomicInteger.incrementAndGet();
                        break;
                    }
                }
            },"A").start();
        }
}
