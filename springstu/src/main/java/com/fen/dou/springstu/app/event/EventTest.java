package com.fen.dou.springstu.app.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@Import(value = {MyEvent.class,MyListenerA.class,MyListenerB.class,MyPublisher.class})
public class EventTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EventTest.class);
        MyPublisher myPublisher = context.getBean(MyPublisher.class);
        MyEvent myEvent = context.getBean(MyEvent.class);
        myPublisher.publisherEvent(myEvent);
    }
}
