package com.fen.dou.springboot.stu.condition;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@Import(value={ConditionalTestClass.class})
public class ConditionalStu {
    public static void main(String[] args) {
        System.setProperty("condition","a");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalStu.class);
        Student student = (Student) applicationContext.getBean("student");
        System.out.println("---------student-----------"+student);

//        User user = (User) applicationContext.getBean("user");
//        System.out.println("---------user-----------"+user);

        User user1 = (User) applicationContext.getBean("user1");
        System.out.println("---------user1-----------"+user1);
    }
}
