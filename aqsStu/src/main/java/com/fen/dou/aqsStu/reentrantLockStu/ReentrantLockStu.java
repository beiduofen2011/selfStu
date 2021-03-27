package com.fen.dou.aqsStu.reentrantLockStu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockStu {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        Condition condition = reentrantLock.newCondition();

        for(int i = 0; i<5 ; i++){
            new Thread(()->{
                reentrantLock.lock();

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----------------------"+Thread.currentThread().getName());
                reentrantLock.unlock();
            },"yc"+i).start();
        }

        new Thread(()->{
            reentrantLock.lock();
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"------------停留了2s-----------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signal();

            reentrantLock.unlock();
        },"yc5").start();
    }
}
