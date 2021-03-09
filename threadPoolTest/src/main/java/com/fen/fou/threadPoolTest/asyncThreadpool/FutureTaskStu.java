package com.fen.fou.threadPoolTest.asyncThreadpool;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskStu extends FutureTask<String> {
    public FutureTaskStu(Callable<String> callable) {
        super(callable);
    }

    @SneakyThrows
    @Override
    protected void done() {
        System.out.println("----"+Thread.currentThread().getName()+"执行完了"+super.get());
    }
}
