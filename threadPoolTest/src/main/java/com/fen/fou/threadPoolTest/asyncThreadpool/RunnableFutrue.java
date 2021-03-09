package com.fen.fou.threadPoolTest.asyncThreadpool;

import java.util.concurrent.Callable;

public class RunnableFutrue implements Callable {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "dsdsdsdsds";
    }
}
