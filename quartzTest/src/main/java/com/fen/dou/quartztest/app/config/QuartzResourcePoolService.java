package com.fen.dou.quartztest.app.config;


import com.fen.dou.quartztest.app.entity.ResourcePool;
import com.fen.dou.quartztest.app.entity.ResourcePoolConfig;
import lombok.extern.slf4j.Slf4j;
import org.quartz.impl.StdScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 21:35 2019/5/16
 * @Modified By:
 */
@Slf4j
@Service
public class QuartzResourcePoolService {

    private static String BEAN_NAME_SUFFIX = "Scheduler";

    @Autowired
    @Qualifier("quartzProperties")
    private Properties properties;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;



    public void automaticSystemRegisterSchedulerFactoryBeans(){
             ResourcePoolConfig  resourcePoolConfig = new ResourcePoolConfig();
             resourcePoolConfig.setBeanName("job_bean");
             resourcePoolConfig.setCorePoolSize(25);
             resourcePoolConfig.setMaxPoolSize(50);
             resourcePoolConfig.setKeepAliveSeconds(86400000);
             resourcePoolConfig.setQueueCapacity(20000);
             resourcePoolConfig.setThreadNamePrefix("job_prefix");
             resourcePoolConfig.setId(1);
            registerSchedulerFactoryBean(resourcePoolConfig);
            StdScheduler stdScheduler = getSchedulerFactoryBean(resourcePoolConfig.getBeanName());
                try {
                    stdScheduler.start();
                } catch (Exception e) {
                    throw new BasicException("data-scheduler-E00001");
                }

    }

    public void registerSchedulerFactoryBeans(List<ResourcePoolConfig> resourcePoolConfigList){
        resourcePoolConfigList.forEach(resourcePoolConfig -> {
            registerSchedulerFactoryBean(resourcePoolConfig);
        });
    }

    /**
     * 添加spring容器bean
     * @param resourcePoolConfig
     */
    public void registerSchedulerFactoryBean(ResourcePoolConfig resourcePoolConfig){
        Map<String, Object> propertyMap = new HashMap<>();
        propertyMap.put("dataSource", dataSource);
        propertyMap.put("quartzProperties", properties);
        propertyMap.put("schedulerName", resourcePoolConfig.getBeanName() + "_scheduler");
        propertyMap.put("taskExecutor", threadPoolTaskExecutor(resourcePoolConfig));
        // propertyMap.put("startupDelay", 30);
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        propertyMap.put("overwriteExistingJobs", true);
        if(log.isDebugEnabled()){
//            log.debug("porperty is : " + JsonUtils.toJsonStr(propertyMap));
        }
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        if(log.isDebugEnabled()){
            log.debug("beanName is " + schedulerFactoryBean.getClass());
        }
        SpringContextBeanUtil.registerSpringBean(schedulerFactoryBean.getClass(), resourcePoolConfig.getBeanName() + BEAN_NAME_SUFFIX, propertyMap);
    }

    /**
     * 资源池属性信息
     * @param resourcePoolConfig
     * @return
     */
    private ThreadPoolTaskExecutor threadPoolTaskExecutor(ResourcePoolConfig resourcePoolConfig){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.initialize();
        threadPoolTaskExecutor.setQueueCapacity(resourcePoolConfig.getQueueCapacity());
        threadPoolTaskExecutor.setKeepAliveSeconds(resourcePoolConfig.getKeepAliveSeconds());
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setThreadNamePrefix(resourcePoolConfig.getThreadNamePrefix());
        threadPoolTaskExecutor.setCorePoolSize(resourcePoolConfig.getCorePoolSize());
        threadPoolTaskExecutor.setMaxPoolSize(resourcePoolConfig.getMaxPoolSize());
        return threadPoolTaskExecutor;
    }

    /**
     * 移除spring容器bean
     * @param beanName
     */
    public void removeSchedulerFactoryBean(String beanName){
        SpringContextBeanUtil.removeSpringBean(beanName + BEAN_NAME_SUFFIX);
    }

    /**
     * 获取调度工厂
     * @param beanName
     * @return
     */
    public StdScheduler getSchedulerFactoryBean(String beanName){
        Object object = SpringContextBeanUtil.getBean(beanName + BEAN_NAME_SUFFIX);
        if(object == null){
            // spring容器没有该资源池bean
            throw new BasicException("resourcePool-bis-E00010");
        }
        StdScheduler stdScheduler = (StdScheduler) object;
        return stdScheduler;
    }

}
