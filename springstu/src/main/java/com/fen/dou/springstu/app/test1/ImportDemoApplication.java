package com.fen.dou.springstu.app.test1;

import com.fen.dou.springstu.app.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableImportSelector(value = "xxx")
public class ImportDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ImportDemoApplication.class);
        User user =  context.getBean(User.class);
        user.run();

        Student student =  context.getBean(Student.class);
        student.run();

        House house =  context.getBean(House.class);
        house.run();

    }

}
