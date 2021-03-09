package com.fen.dou.springstu.app.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MyEvent extends ApplicationContextEvent {
    public MyEvent(ApplicationContext source) {
        super(source);
    }

    public void out(String name)
    {
        System.out.println("MyEvent 事件执行了 name :"+name);
    }
}
