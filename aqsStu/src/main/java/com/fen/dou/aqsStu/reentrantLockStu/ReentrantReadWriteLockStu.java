package com.fen.dou.aqsStu.reentrantLockStu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockStu {

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock eentrantLock = new ReentrantReadWriteLock(false);

        ReentrantReadWriteLock.ReadLock readLock = eentrantLock.readLock();
        readLock.lock();
        readLock.unlock();

        ReentrantReadWriteLock.WriteLock writeLock = eentrantLock.writeLock();
        writeLock.lock();
        writeLock.unlock();
    }
}
