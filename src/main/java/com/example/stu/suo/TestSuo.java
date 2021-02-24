package com.example.stu.suo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class TestSuo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        reentrantLock.lock();

        reentrantLock.unlock();


        CountDownLatch countDownLatch = new CountDownLatch(1);


        countDownLatch.await();

        countDownLatch.countDown();


        Semaphore semaphore = new  Semaphore(20);
        semaphore.acquire();


    }


}
