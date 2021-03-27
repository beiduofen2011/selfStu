package com.fen.dou.springstu.app.quanliucheng;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorTest implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--------BeanPostProcessor------postProcessBeforeInitialization-------------"+beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("------BeanPostProcessor--------postProcessAfterInitialization-------------"+beanName);
        return null;
    }
}
