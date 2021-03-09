package com.fen.fou.threadPoolTest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
@EnableAsync
@ComponentScan("com.fen.fou.threadPoolTest.stu")
public class ThreadpooltestApplication {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(ThreadpooltestApplication.class, args);
	}
}
