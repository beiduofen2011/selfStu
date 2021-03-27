package com.fen.dou.classLoadStu;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest1 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        new Thread(()->{
            lock.lock();
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("------------D---------");
            lock.unlock();
        },"D").start();

        new Thread(()->{
            lock.lock();
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------C----------");
            condition3.signalAll();
            lock.unlock();
        },"C").start();

        new Thread(()->{
            lock.lock();
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------B----------");
            condition2.signalAll();
            lock.unlock();
        },"B").start();
        new Thread(()->{
            lock.lock();
            System.out.println("------------A----------");
                condition1.signalAll();
            lock.unlock();
        },"A").start();
    }
}
