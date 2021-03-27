package com.fen.dou.springboot.stu.xunhuanyilai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserA {
    @Autowired
    private UserB userB;

    private String name = "我是A";

    public String getName(){
        return this.name;
    }
    public String getuserBName(){
        return userB.getName();
    }
}
