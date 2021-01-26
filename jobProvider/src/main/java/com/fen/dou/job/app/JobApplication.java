package com.fen.dou.job.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableEurekaClient
//@EnableTransactionManagement
public class JobApplication {
//	@Bean
//	public Object testBean(PlatformTransactionManager platformTransactionManager){
//		System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
//		return new Object();
//	}
	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}
}
