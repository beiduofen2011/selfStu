package com.fen.dou.quartztest.app;

import com.fen.dou.quartztest.app.config.QuartzResourcePoolService;
import com.fen.dou.quartztest.app.config.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fen.dou.quartztest.app")
public class QuartztestApplication {
    public static void main(String[] args) {
         ApplicationContext applicationContext =  SpringApplication.run(QuartztestApplication.class);
       // System.out.println("-----------1----------"+applicationContext.getBean("job_beanScheduler"));
        SpringContextHolder.getApplicationContext().getBean(QuartzResourcePoolService.class)
                .automaticSystemRegisterSchedulerFactoryBeans();

        System.out.println("-----------2----------"+applicationContext.getBean("job_beanScheduler"));
    }
}
