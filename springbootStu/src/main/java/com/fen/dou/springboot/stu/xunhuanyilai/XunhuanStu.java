package com.fen.dou.springboot.stu.xunhuanyilai;

import com.fen.dou.springboot.stu.condition.ConditionalTestClass;
import com.fen.dou.springboot.stu.condition.Student;
import com.fen.dou.springboot.stu.condition.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan("com.fen.dou.springboot.stu.xunhuanyilai")
public class XunhuanStu {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(XunhuanStu.class);

        UserA userA = (UserA)applicationContext.getBean("userA");
        System.out.println(userA.getuserBName());

    }
}
