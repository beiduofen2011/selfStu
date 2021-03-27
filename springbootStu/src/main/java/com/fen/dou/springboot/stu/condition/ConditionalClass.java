package com.fen.dou.springboot.stu.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionalClass implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String str = System.getProperty("condition");
        if(str.equals("a")){
            return true;
        }
        return false;
    }
}
