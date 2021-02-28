package com.fen.fou.aopStu.jdk;

import org.springframework.stereotype.Component;

@Component
public class SayImpl implements Say {
    @Override
    public void sayHello(String words) { System.out.println("我是"+words); }
}
