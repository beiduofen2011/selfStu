package com.fen.dou.springstu.app.test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportAutoconfiguration {

    @Bean
    public Student student(){
        return new Student();
    }
}

