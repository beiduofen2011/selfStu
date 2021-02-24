package com.fen.dou.springstu.app.test4;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UsernameFactoryBean implements FactoryBean<YcUserName> {
    @Override
    public YcUserName getObject() throws Exception {
        System.out.println("-----new YcUserName------");
        return new YcUserName();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("---FactoryBean--getObjectType------");
        return YcUserName.class;
    }
}
