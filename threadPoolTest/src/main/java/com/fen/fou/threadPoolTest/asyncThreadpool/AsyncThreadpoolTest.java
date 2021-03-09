package com.fen.fou.threadPoolTest.asyncThreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncThreadpoolTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0 ; i<100 ;i++){
            executor.submit(new FutureTaskStu(new RunnableFutrue()));
        }
    }
}
