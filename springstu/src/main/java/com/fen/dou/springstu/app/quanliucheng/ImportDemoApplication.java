package com.fen.dou.springstu.app.quanliucheng;

import com.fen.dou.springstu.app.quanliucheng.factorybeanTest.MyFacotryBean;
import com.fen.dou.springstu.app.quanliucheng.factorybeanTest.MyFactoryBeanImpl;
import com.fen.dou.springstu.app.test1.EnableImportSelector;
import com.fen.dou.springstu.app.test1.House;
import com.fen.dou.springstu.app.test1.Student;
import com.fen.dou.springstu.app.test1.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;


public class ImportDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ImportTest.class);


//        context.getBean()
//        AnnotationTest a = (AnnotationTest)context.getBean("annotationTest");
//
//        MyFacotryBean myFacotryBean = (MyFactoryBeanImpl)context.getBean("myFactoryBeanTest");
//        System.out.println(myFacotryBean.getNean());
//        System.out.println(myFacotryBean.getNean());
    }

}
