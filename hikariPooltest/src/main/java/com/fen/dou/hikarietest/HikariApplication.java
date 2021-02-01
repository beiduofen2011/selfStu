package com.fen.dou.hikarietest;

import com.fen.dou.hikarietest.config.ServiceConfig;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@SpringBootApplication
//@ComponentScan(basePackages = "com.fen.dou")
//@EnableTransactionManagement
//@EnableEurekaClient
//@EnableFeignClients(basePackages = "com.fen.dou.hikarietest.api")
//@EnableJpaRepositories(basePackages ="com.fen.dou.hikarietest.dao")
//@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
//@EnableJpaRepositories(enableDefaultTransactions=false)

//@SpringBootApplication(exclude = TransactionAutoConfiguration.class)
//@EnableJpaRepositories(enableDefaultTransactions = false)
////业务方法上关闭事务
//@Transactional(propagation= Propagation.NOT_SUPPORTED)
@ServiceConfig
public class HikariApplication {
	@Bean
	public Object testBean(PlatformTransactionManager platformTransactionManager){
		System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
		return new Object();
	}
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
	public static void main(String[] args) {
		SpringApplication.run(HikariApplication.class, args);
	}
}
