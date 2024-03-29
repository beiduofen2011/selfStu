package com.fen.fou.aopStu;

import com.fen.fou.aopStu.jdk.Say;
import com.fen.fou.aopStu.jdk.SayImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.fen.fou.aopStu")
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy=true)
public class SpringAopStuApplication {
	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\70765\\Desktop\\cglib");
		ApplicationContext applicationContext = SpringApplication.run(SpringAopStuApplication.class, args);
		UserService userService = (UserService)applicationContext.getBean("userService");
		userService.weishe();
	//	userService.weishe();
		System.out.println("------userService------"+userService);

		Say sayImpl = (Say)applicationContext.getBean("sayImpl");

		System.out.println("------sayImpl------"+sayImpl);
	}
}
