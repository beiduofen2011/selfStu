package com.fen.dou.springstu.app.quanliucheng;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNanes = beanFactory.getBeanDefinitionNames();
        Arrays.asList(beanNanes).forEach(x->{
            System.out.println(x);
        });
        System.out.println("--------------BeanFactoryPostProcessor-------------");
    }
}
