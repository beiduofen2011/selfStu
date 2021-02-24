package com.fen.dou.springstu.app.awareTest;

import com.fen.dou.springstu.app.test4.TesMyyApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.fen.dou.springstu.app.awareTest")
@EnableAspectJAutoProxy
public class TestAware {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestAware.class);
      //  InternalAutoProxyCreator
//        for(String dstr : context.getBeanDefinitionNames()){
//            System.out.println("-------------"+dstr);
//        }
        MyTestAll aa = (MyTestAll) context.getBean("myTestAll");
        aa.say();
    }
}
