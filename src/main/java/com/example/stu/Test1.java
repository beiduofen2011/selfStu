package com.example.stu;

import com.example.stu.dduothread.Foo;
import lombok.SneakyThrows;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread td = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while(true){
                    Thread.sleep(200000); //自身出让CPU资源
                    System.out.println("--td--");
                }
            }
        },"y1");
        td.start();

        Thread td1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while(true){
                    td.sleep(500000);  //这种写法，注意这里不会让td线程出让CPU资源，还是自己td1出让CPU资源
                    System.out.println("--td1--");
                }
            }
        },"y2");
        td1.start();
    }
}
