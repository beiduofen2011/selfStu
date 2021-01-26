package com.fen.dou.job.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JobController {

    @GetMapping("runJob")
    public void runJob(){
        log.info("------------runJob--------------");
    }
}
