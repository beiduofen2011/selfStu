package com.fen.dou.springstu.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="entitlement")
    public String entitlement() {
        return "ok";
    }
}