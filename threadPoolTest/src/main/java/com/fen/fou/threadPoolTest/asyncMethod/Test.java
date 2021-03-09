package com.fen.fou.threadPoolTest.asyncMethod;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
@ComponentScan("com.fen.fou.threadPoolTest.asyncMethod")
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //SpringApplication.run(ThreadpooltestApplication.class, args);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Test.class);
        AsyncMethod asyncMethod = (AsyncMethod)applicationContext.getBean("asyncMethod");
        Future<String>  future = asyncMethod.say();
        System.out.println("----------------");
        Thread.sleep(5000);
        System.out.println("----------------");
        System.out.println(future.get());
    }
}
