package com.fen.dou.hystrixDashboard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class hystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(hystrixApplication.class, args);
	}
}
