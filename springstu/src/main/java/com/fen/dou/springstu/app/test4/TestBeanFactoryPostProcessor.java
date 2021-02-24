package com.fen.dou.springstu.app.test4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("usernameFactoryBean");
        System.out.println("+++++++++++++"+configurableListableBeanFactory.getBean("usernameFactoryBean"));
        System.out.println("+++++++++++++"+beanDefinition.getBeanClassName());
        System.out.println("+++++++++++++"+beanDefinition.getClass().getName());
    }
}