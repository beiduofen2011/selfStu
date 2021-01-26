package com.fen.dou.hikarietest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ComponentScan(basePackages = "com.fen.dou")
@EnableTransactionManagement
@EnableEurekaClient
@EnableFeignClients
//@EnableJpaRepositories(basePackages ="com.fen.dou.hikarietest.dao")
//@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
//@EnableJpaRepositories(enableDefaultTransactions=false)

//@SpringBootApplication(exclude = TransactionAutoConfiguration.class)
//@EnableJpaRepositories(enableDefaultTransactions = false)
////业务方法上关闭事务
//@Transactional(propagation= Propagation.NOT_SUPPORTED)

public class HikariApplication {
	@Bean
	public Object testBean(PlatformTransactionManager platformTransactionManager){
		System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
		return new Object();
	}

	public static void main(String[] args) {
		SpringApplication.run(HikariApplication.class, args);
	}
}