package com.fen.dou.springstu.app.quanliucheng;

import com.fen.dou.springstu.app.quanliucheng.factorybeanTest.MyFacotryBean;
import com.fen.dou.springstu.app.quanliucheng.factorybeanTest.MyFactoryBeanImpl;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBeanTest implements FactoryBean<MyFacotryBean> {

    @Override
    public MyFacotryBean getObject() throws Exception {
        System.out.println("--------------FactoryBean-------getObject------");
        return new MyFactoryBeanImpl();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("--------------FactoryBean-------getObjectType------");
        return MyFacotryBean.class;
    }
}
