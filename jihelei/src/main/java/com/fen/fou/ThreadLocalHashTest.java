package com.fen.fou;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalHashTest extends ThreadLocal{
    private static final int HASH_INCREMENT = 0x61c88647;
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i= 1 ; i<=20 ;i++){
            int index = atomicInteger.getAndAdd(HASH_INCREMENT) & (16-1);
            System.out.println(atomicInteger.get());

            int nextIndex = ((index + 1 < 16) ? index + 1 : 0);
            System.out.println(index+"-----"+nextIndex);
        }
    }
}
