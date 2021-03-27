package com.fen.dou.springstu.app.quanliucheng.factorybeanTest;

import com.fen.dou.springstu.app.quanliucheng.AnnotationTest;
import com.fen.dou.springstu.app.quanliucheng.BeanTest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class MyFactoryBeanImpl implements MyFacotryBean {

    @Override
    public Object getNean() {
        return "kkkkkk";
    }
}
