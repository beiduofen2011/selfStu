package com.fen.dou.springstu.app.awareTest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class Aware4 implements MessageSourceAware {

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
