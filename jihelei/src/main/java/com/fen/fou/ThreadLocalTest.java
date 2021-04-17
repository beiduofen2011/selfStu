package com.fen.fou;

public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> threadLocal1 = new ThreadLocal<String>();
        ThreadLocal<String> threadLocal2 = new ThreadLocal<String>();
        ThreadLocal<String> threadLocal3 = new ThreadLocal<String>();
        threadLocal1.set("main");

        Thread a = new Thread(()->{
            threadLocal1.set("a1");
            threadLocal1.get();
            threadLocal1.set("a11");
            threadLocal1.get();
            threadLocal2.set("a1");
            threadLocal2.get();
            threadLocal3.set("a1");
            threadLocal3.get();

            threadLocal3.get();
            System.out.println(threadLocal1.get()+","+threadLocal2.get()+","+threadLocal3.get());
        },"A");

        a.start();
        a.join();
        Thread b = new Thread(()->{
            threadLocal1.set("b1");
            threadLocal1.get();
            threadLocal1.set("b11");
            threadLocal1.get();
            threadLocal2.set("b1");
            threadLocal2.get();
            threadLocal3.set("b1");
            threadLocal3.get();
            System.out.println(threadLocal1.get()+","+threadLocal2.get()+","+threadLocal3.get());
        },"B");

        b.start();

        System.out.println(threadLocal1.get());
    }
}
