package com.fen.dou.quartztest.app.config;

import com.fen.dou.quartztest.app.config.job.ButtonTimerJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 17:42 2019/5/19
 * @Modified By:
 */
@Configuration
@AutoConfigureAfter({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@AutoConfigureBefore(QuartzAutoConfiguration.class)
@Slf4j
public class QuartzConfig {
    @Value("${file.path}")
    private String path;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;


    @Bean(name = "quartzProperties")
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new FileSystemResource(String.format("%s/quartz.properties",path)));
        //在application.yml中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean(name = "systemScanTaskJobService")
    SystemScanTaskJobService systemScanTaskJobService(){
        return new SystemScanTaskJobService();
    }

//    @Bean
//    public BeanInvokingJobDetailFactoryBean beanInvokingJobDetailFactoryBean(){
//        BeanInvokingJobDetailFactoryBean beanInvokingJobDetailFactoryBean = new BeanInvokingJobDetailFactoryBean();
//        beanInvokingJobDetailFactoryBean.setConcurrent(false);
//        beanInvokingJobDetailFactoryBean.setTargetBean("systemScanTaskJobService");
//        beanInvokingJobDetailFactoryBean.setTargetMethod("scanTaskManagerModel");
//        return beanInvokingJobDetailFactoryBean;
//    }

    @Bean
    public JobDetailFactoryBean buttonobDetail() {
        //集群模式下必须使用JobDetailFactoryBean，MethodInvokingJobDetailFactoryBean 类中的 methodInvoking 方法，是不支持序列化的
        JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
        jobDetail.setDurability(true);
        jobDetail.setRequestsRecovery(true);
        jobDetail.setJobClass(ButtonTimerJob.class);
        return jobDetail;
    }

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

    @Bean("cronTriggerFactoryBean")
    public CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(buttonobDetail().getObject());
        cronTriggerFactoryBean.setCronExpression("0/1 * * * * ? ");
        cronTriggerFactoryBean.setPriority(Integer.MAX_VALUE);
        return cronTriggerFactoryBean;
    }
    protected CronTrigger[] getCronTriggers(){
        List<CronTrigger> cronTriggers = new ArrayList<>();
        // 添加定时任务
        cronTriggers.add(cronTriggerFactoryBean().getObject());
        return cronTriggers.toArray(new CronTrigger[cronTriggers.size()]);
    }

}
