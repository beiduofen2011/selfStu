package com.fen.dou.hikarietest.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.lang.annotation.*;

/**
 * Created by 落叶 on 2019-05-07.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.fen.dou")
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ComponentScan(basePackages = "com.fen.dou")
//@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableAspectJAutoProxy(exposeProxy=true)
@EnableScheduling
public @interface ServiceConfig {

}
