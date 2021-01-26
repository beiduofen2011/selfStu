package com.example.stu.dduothread;


import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class SychObjectTest {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException {
        Foo foo = new Foo();

        new Thread(new Myrun(foo, Foo.class.getMethod("third"),2), "thread3").start();
        new Thread(new Myrun(foo,Foo.class.getMethod("second"),1), "thread2").start();
        new Thread(new Myrun(foo,Foo.class.getMethod("first"),0), "thread1").start();
    }

    static class Myrun implements Runnable{

        private  Foo foo;

        private Method method;

        int i ;
        static  int k  = 0;

        Myrun(Foo foo, Method method,int i){
            this.foo = foo;
            this.method = method;
            this.i = i;
        }
        @SneakyThrows
        @Override
        public void run() {
            synchronized (foo){
                    if(i % 3 == k){   //顺序逻辑判断
                        Thread.sleep(100000);
                        method.invoke(foo); //统一输出
                        k++;
                        foo.notifyAll();
                    }else{
                        foo.wait();//获取锁之后，在这里据悉执行
                        run();
                    }
            }
        }
    }
}
