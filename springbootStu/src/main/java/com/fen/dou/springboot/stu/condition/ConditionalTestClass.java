package com.fen.dou.springboot.stu.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalTestClass {

     @Conditional(ConditionalClass.class)
     @Bean("student")
     public Student getStudent(){
         return new Student();
     }

     @Bean("user")
     @ConditionalOnMissingClass({"com.fen.dou.springboot.stu.condition.OnclassTest"})
     public User getUser(){
         return new User();
     }

    @Bean("user1")
    @ConditionalOnClass(name = {"com.fen.dou.springboot.stu.condition.OnclassTest"})
    public User getUser1(){
        return new User();
    }
}
