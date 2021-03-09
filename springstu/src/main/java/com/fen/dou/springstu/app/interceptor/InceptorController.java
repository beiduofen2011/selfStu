package com.fen.dou.springstu.app.interceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InceptorController {

    @RequestMapping("/say")
    public String sayHello(){
        return "sssss";
    }
}
