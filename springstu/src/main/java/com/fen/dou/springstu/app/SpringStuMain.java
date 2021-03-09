package com.fen.dou.springstu.app;

import lombok.Builder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStuMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String ss = (String) applicationContext.getBean("entitlement");
        System.out.println(ss);

    }
}
