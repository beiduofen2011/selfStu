package com.fen.dou.springstu.app.awareTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
InitialingBean是一个接口，提供了一个唯一的方法afterPropertiesSet()。
DisposableBean也是一个接口，提供了一个唯一的方法destory()。
这两个接口是一组的，功能类似，因此放在一起：前者顾名思义在Bean属性都设置完毕后调用afterPropertiesSet()方法做一些初始化的工作，后者在Bean生命周期结束前调用destory()方法做一些收尾工作。下面看一下例子，为了能明确地知道afterPropertiesSet()方法的调用时机，加上一个属性，给属性set方法，在set方法中打印一些内容：
 */


@Component
public class MyTestAll implements BeanNameAware, BeanFactoryPostProcessor, BeanPostProcessor, InitializingBean, DisposableBean , BeanDefinitionReader {

    public void say(){
        System.out.println("----------say hello-----------");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println(s+"BeanNameAware进行感知。。。");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        MyTestAll myTestAll = (MyTestAll)configurableListableBeanFactory.getBean("myTestAll");
        System.out.println("beanfactory后置处理器。。。");

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println(beanName+"----postProcessAfterInitialization。。。");
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println(beanName+"----postProcessBeforeInitialization。。。");

        return bean;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean destroy。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean afterPropertiesSet。。。");
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        System.out.println("getRegistry");
        return null;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        System.out.println("getResourceLoader");
        return null;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        System.out.println("getBeanClassLoader");
        return null;
    }

    @Override
    public BeanNameGenerator getBeanNameGenerator() {
        System.out.println("getBeanNameGenerator");
        return null;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        System.out.println("loadBeanDefinitions(Resource resource)");
        return 0;
    }

    @Override
    public int loadBeanDefinitions(Resource... resources) throws BeanDefinitionStoreException {
        System.out.println("loadBeanDefinitions(Resource... resources)");
        return 0;
    }

    @Override
    public int loadBeanDefinitions(String s) throws BeanDefinitionStoreException {
        System.out.println("loadBeanDefinitions(String s)");
        return 0;
    }

    @Override
    public int loadBeanDefinitions(String... strings) throws BeanDefinitionStoreException {
        System.out.println("loadBeanDefinitions(String... strings)");
        return 0;
    }
}
