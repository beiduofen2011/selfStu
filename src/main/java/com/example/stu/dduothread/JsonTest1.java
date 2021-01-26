package com.example.stu.dduothread;


import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class JsonTest1 {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException {
        Foo foo = new Foo();

        Thread thread1 = new Thread(new Myrun(foo, Foo.class.getMethod("first"),null), "thread1");
        Thread thread2 = new Thread(new Myrun(foo,Foo.class.getMethod("second"),thread1), "thread2");
        Thread thread3 = new Thread(new Myrun(foo,Foo.class.getMethod("third"),thread2), "thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Myrun implements Runnable{

        private  Foo foo;
        private Method method;
        private Thread thread;

        Myrun(Foo foo, Method method,Thread thread){
            this.foo = foo;
            this.method = method;
            this.thread = thread;
        }
        @SneakyThrows
        @Override
        public void run() {

            if(thread != null){
                thread.join();
            }

            method.invoke(foo); //统一输出

        }
    }
}
