package com.fen.dou.springstu.app.quanliucheng;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class AwreTest implements BeanNameAware, ApplicationContextAware, BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("--------------BeanFactoryAware-------------");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("--------------BeanNameAware-------------");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("--------------ApplicationContextAware-------------");
    }
}
