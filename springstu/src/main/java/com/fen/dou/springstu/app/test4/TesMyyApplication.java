package com.fen.dou.springstu.app.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.fen.dou.springstu.app.test4")
public class TesMyyApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TesMyyApplication.class);
     //   Username user = (Username) context.getBean("location1");
//        UserName user = context.getBean(UserName.class);
//        user.print();
        for(String dstr : context.getBeanDefinitionNames()){
            System.out.println("-------------"+dstr);
        }


//        YcUserName user1 = (YcUserName) context.getBean("usernameFactoryBean");
 //       user1.print();


    }

}
