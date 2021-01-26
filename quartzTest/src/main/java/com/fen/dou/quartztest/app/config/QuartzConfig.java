//package com.fen.dou.quartztest.app.config;
//
//import com.phoenix.data.scheduler.bis.SystemScanTaskJobService;
//import com.phoenix.data.scheduler.config.BeanInvokingJobDetailFactoryBean;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.CronTrigger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.PropertiesFactoryBean;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * @Author: hejis
// * @Description:
// * @Date: Create in 17:42 2019/5/19
// * @Modified By:
// */
//@Configuration
//@AutoConfigureAfter({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@AutoConfigureBefore(QuartzAutoConfiguration.class)
//@Slf4j
//public class QuartzConfig {
//    @Value("${file.path}")
//    private String path;
//
//    @Autowired
//    @Qualifier("dataSource")
//    private DataSource dataSource;
//
//    @Bean(name = "systemScanTaskJobService", initMethod = "startSysJobs",destroyMethod = "shutdownSysJobs")
//    SystemScanTaskJobService systemScanTaskJobService(){
//        return new SystemScanTaskJobService();
//    }
//
//    @Bean(name = "quartzProperties")
//    public Properties quartzProperties() throws IOException {
//        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setLocation(new FileSystemResource(String.format("%s/quartz.properties",path)));
//        //在application.yml中的属性被读取并注入后再初始化对象
//        propertiesFactoryBean.afterPropertiesSet();
//        return propertiesFactoryBean.getObject();
//    }
//
//    @Bean
//    public BeanInvokingJobDetailFactoryBean beanInvokingJobDetailFactoryBean(){
//        BeanInvokingJobDetailFactoryBean beanInvokingJobDetailFactoryBean
//                = new BeanInvokingJobDetailFactoryBean();
//        beanInvokingJobDetailFactoryBean.setConcurrent(false);
//        beanInvokingJobDetailFactoryBean.setTargetBean("systemScanTaskJobService");
//        beanInvokingJobDetailFactoryBean.setTargetMethod("scanTaskManagerModel");
//        return beanInvokingJobDetailFactoryBean;
//    }
//
//    @Bean("cronTriggerFactoryBean")
//    public CronTriggerFactoryBean cronTriggerFactoryBean(){
//        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
//        BeanInvokingJobDetailFactoryBean beanInvokingJobDetailFactoryBean = beanInvokingJobDetailFactoryBean();
//        if(beanInvokingJobDetailFactoryBean != null){
//            cronTriggerFactoryBean.setJobDetail(beanInvokingJobDetailFactoryBean().getObject());
//        }
//        cronTriggerFactoryBean.setCronExpression("0/30 * * * * ? ");
//        cronTriggerFactoryBean.setPriority(Integer.MAX_VALUE);
//        return cronTriggerFactoryBean;
//    }
//
//    protected CronTrigger[] getCronTriggers(){
//        List<CronTrigger> cronTriggers = new ArrayList<>();
//        // 添加定时任务
//        cronTriggers.add(cronTriggerFactoryBean().getObject());
//        return cronTriggers.toArray(new CronTrigger[cronTriggers.size()]);
//    }
//
//    @Bean("timerTask_scheduler")
//    SchedulerFactoryBean schedulerFactoryBeanNifi(@Autowired @Qualifier("quartzProperties") Properties properties){
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setDataSource(dataSource);
//        schedulerFactoryBean.setQuartzProperties(properties);
//        schedulerFactoryBean.setTriggers(getCronTriggers());
//        schedulerFactoryBean.setSchedulerName("timerTask_scheduler");
//        schedulerFactoryBean.setTaskExecutor(threadPoolTimerTaskExecutor());
//        return schedulerFactoryBean;
//    }
//
//    ThreadPoolTaskExecutor threadPoolTimerTaskExecutor(){
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.initialize();
//        threadPoolTaskExecutor.setQueueCapacity(20000);
//        threadPoolTaskExecutor.setKeepAliveSeconds(3600 * 24);
//        threadPoolTaskExecutor.setThreadNamePrefix("timerTask-job~");
//        threadPoolTaskExecutor.setCorePoolSize(20);
//        threadPoolTaskExecutor.setMaxPoolSize(20);
//        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        return threadPoolTaskExecutor;
//    }
//}
