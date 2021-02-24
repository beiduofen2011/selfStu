package com.fen.dou.springstu.app.awareTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwareEntitiy {

    @Bean
    public  String say(){
        return "hello";
    }

}
