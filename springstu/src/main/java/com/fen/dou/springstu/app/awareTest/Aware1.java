package com.fen.dou.springstu.app.awareTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Aware1 implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
    //    System.out.println("-------setBeanName----------"+s);
    }
}
