package com.fen.dou.springstu.app.quanliucheng;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@ComponentScan("com.fen.dou.springstu.app.quanliucheng")
@Import({AwreTest.class,InitialBeanTest.class,BeanFactoryPostProcessorTest.class
        ,BeanPostProcessorTest.class,DisposableBeanTest.class,
        MyFactoryBeanTest.class,ImportSelectorTest.class,InitialBeanTest.class,ImportSelectorTest.class,
        ImportBeanDefinitionRegistrarTest.class})
@Configuration
public class ImportTest{
     @Bean
     public  BeanTest getBeanTest(){
         return new BeanTest();
     }
}
