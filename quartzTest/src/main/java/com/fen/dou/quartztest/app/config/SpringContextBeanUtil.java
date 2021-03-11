package com.fen.dou.quartztest.app.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Map;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 21:17 2019/5/16
 * @Modified By:
 */
public class SpringContextBeanUtil {

    public static void registerSpringBean(Class<?> beanClass, String beanName, Map<String, Object> propertyMap){
        // 通过BeanDefinitionBuilder创建bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        // 设置bean属性值
        if(propertyMap != null){
            propertyMap.forEach((key, value) -> {
                if(value != null) {
                    beanDefinitionBuilder.addPropertyValue(key, value);
                }
            });
        }

        DefaultListableBeanFactory defaultListableBeanFactory = SpringContextHolder.getInstance().getDefaultListableBeanFactory();
        if(defaultListableBeanFactory.containsBeanDefinition(beanName)){
            defaultListableBeanFactory.setAllowBeanDefinitionOverriding(true);
        }
        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());
    }

    /**
     * 移除spring bean对象
     * @param beanName
     */
    public static void removeSpringBean(String beanName){
        DefaultListableBeanFactory defaultListableBeanFactory = SpringContextHolder.getInstance().getDefaultListableBeanFactory();
        if(defaultListableBeanFactory.containsBeanDefinition(beanName)) {
            // 删除bean.
            defaultListableBeanFactory.removeBeanDefinition(beanName);
        }
    }

    /**
     * 获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return SpringContextHolder.getInstance().getDefaultListableBeanFactory().getBean(beanName);
    }

}
