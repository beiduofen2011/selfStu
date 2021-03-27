package com.fen.dou.springboot.stu.xunhuanyilai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserB {
    @Autowired
    private UserA userA;
    private String name = "我是B";
    public String getName(){
        return this.name;
    }
    public String getuserAName(){
        return userA.getName();
    }
}
