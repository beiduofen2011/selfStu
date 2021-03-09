package com.fen.dou.springstu.app.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

public class MyPublisher implements ApplicationContextAware {
    public ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public void publisherEvent(ApplicationEvent event)
    {
        System.out.println("-----发送事件-----"+event);
        applicationContext.publishEvent(event);
    }
}