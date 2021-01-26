package com.example.stu.dduothread;

import lombok.SneakyThrows;

public class SyncTest {
    public static void main(String[] args) {

        Foo foo = new Foo();

        new Thread(new SyncTest.Myrun(foo), "thread3").start();
        new Thread(new SyncTest.Myrun(foo), "thread2").start();
        new Thread(new SyncTest.Myrun(foo), "thread1").start();

    }
    static class Myrun implements Runnable {

        private Foo foo;

        Myrun(Foo foo) {
            this.foo = foo;
        }
        @SneakyThrows
        @Override
        public void run() {
            synchronized (foo) {
               Thread.sleep(100000);
            }
        }
    }
}
