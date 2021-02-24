package com.fen.dou.springstu.app.test3;


import com.fen.dou.springstu.app.test1.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =  SpringApplication.run(TestMain.class);
        for(String dstr : applicationContext.getBeanDefinitionNames()){
            System.out.println("-------------"+dstr);
        }
        User ss = (User) applicationContext.getBean("myTraceListener");
        ss.run();
        System.out.println(ss);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        User ss = (User) applicationContext.getBean("myTraceListener");
//        System.out.println(ss);
    }
}
