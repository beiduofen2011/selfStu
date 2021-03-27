package com.fen.dou.springstu.app.quanliucheng;

import org.springframework.beans.factory.InitializingBean;

public class InitialBeanTest implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------InitialBeanTest----------------");
    }
}
