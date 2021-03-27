package com.fen.dou.springboot.stu.xunhuanyilai;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("hello")
    public String getHello(){
        return "hello";
    }
}
