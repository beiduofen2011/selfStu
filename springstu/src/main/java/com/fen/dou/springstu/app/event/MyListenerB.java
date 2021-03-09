package com.fen.dou.springstu.app.event;

import org.springframework.context.ApplicationListener;

public class MyListenerB implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("MyListenerB 执行了");
        event.out("wangmingyuan not love");
    }
}
