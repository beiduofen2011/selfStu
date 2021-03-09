package com.fen.fou.threadPoolTest.javaThreadpool;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class ThreadpoolTest {
    static int k = 0;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();

        ExecutorService executor5 =new ThreadPoolExecutor(2, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        Runnable runnable1 = new Runnable() {
             @SneakyThrows
             @Override
             public void run() {
                  Thread.sleep(100000);
                 k++;
                 System.out.println("-----"+Thread.currentThread().getName()+"-------------:"+k);
             }
         };
        Runnable runnable2 = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(200000);
                k++;
                System.out.println("-----"+Thread.currentThread().getName()+"-------------:"+k);
            }
        };
        Runnable runnable3 = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(200000);
                k++;
                System.out.println("-----"+Thread.currentThread().getName()+"-------------:"+k);
            }
        };
        Runnable runnable4 = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(20000);
                k++;
                System.out.println("-----"+Thread.currentThread().getName()+"-------------:"+k);
            }
        };
        Runnable runnable5 = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(20000);
                k++;
                System.out.println("-----"+Thread.currentThread().getName()+"-------------:"+k);
            }
        };
        Runnable runnable6 = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(20000);
                k++;
                System.out.println("-----"+Thread.currentThread().getName()+"-------------:"+k);
            }
        };
        executor5.execute(runnable1);
        executor5.execute(runnable2);
        executor5.execute(runnable3);
        executor5.execute(runnable4);
        executor5.execute(runnable5);
        executor5.execute(runnable6);

     



    }
}
