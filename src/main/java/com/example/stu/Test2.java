package com.example.stu;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        executorService.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(2000);
                System.out.println("---------dd--------------");
            }
        });
        System.out.println("-----------------------");
    }
}
