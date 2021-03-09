package com.fen.dou.springstu.app.interceptor;

import com.fen.dou.springstu.app.event.MyEvent;
import com.fen.dou.springstu.app.event.MyListenerA;
import com.fen.dou.springstu.app.event.MyListenerB;
import com.fen.dou.springstu.app.event.MyPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan("com.fen.dou.springstu.app.interceptor")
@SpringBootApplication
public class InterceptorTest {
    public static void main(String[] args) {
  //      AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(InterceptorTest.class);
        ApplicationContext applicationContext = SpringApplication.run(InterceptorTest.class);
//        ControllerOne controllerOne = (ControllerOne)applicationContext.getBean("controllerOne");
//        System.out.println("---controllerOne---"+controllerOne);
    }
}
