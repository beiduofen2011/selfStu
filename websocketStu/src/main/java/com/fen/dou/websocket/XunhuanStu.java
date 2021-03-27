package com.fen.dou.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fen.dou.websocket")
public class XunhuanStu {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(XunhuanStu.class);

    }
}
