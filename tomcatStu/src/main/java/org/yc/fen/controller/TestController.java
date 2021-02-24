package org.yc.fen.controller;

import com.sun.deploy.net.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("say")
    public String sayhallo(){
        return "hallo";
    }
}
