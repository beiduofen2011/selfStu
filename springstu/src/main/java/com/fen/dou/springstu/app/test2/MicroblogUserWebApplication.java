package com.fen.dou.springstu.app.test2;

import com.fen.dou.springstu.app.test1.ImportDemoApplication;
import com.fen.dou.springstu.app.test1.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@Import(User.class)
public class MicroblogUserWebApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ImportDemoApplication.class);
        User user =  context.getBean(User.class);
        user.run();
    }

}
