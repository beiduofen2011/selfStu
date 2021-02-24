package com.fen.fou.aopStu;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public  String say(String name){
        System.out.println("---------say---------"+name);
        return "hello";
    }

    public  String weishe(){
//        UserService service = (UserService) AopContext.currentProxy();
//        return service.say();
        return say("wei");
    }
}
