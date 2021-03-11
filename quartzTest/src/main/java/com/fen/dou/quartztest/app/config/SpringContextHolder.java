package com.fen.dou.quartztest.app.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class SpringContextHolder  implements ApplicationContextAware {

    private  static ApplicationContext applicationContext = null;

    private  static SpringContextHolder springContextHolder = new SpringContextHolder();

    private SpringContextHolder(){};


    public static SpringContextHolder  getInstance(){
        return springContextHolder;
    }
    /**
     * 获取DefaultListableBeanFactory
     * @return
     */
    public DefaultListableBeanFactory getDefaultListableBeanFactory(){
        // 将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;

        // 获取bean工厂并转换为DefaultListableBeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();

        return defaultListableBeanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext  getApplicationContext(){
        return applicationContext;
    }

}


