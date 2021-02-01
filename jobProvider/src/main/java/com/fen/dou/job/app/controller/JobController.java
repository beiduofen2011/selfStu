package com.fen.dou.job.app.controller;

import com.fen.dou.job.app.vo.ResultVo;
import com.netflix.hystrix.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JobController {

    @GetMapping("runJob")
    public void runJob(){
        try {
            Thread.sleep(2000);
            log.info("------------runJob--------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("findJob")
    public String findJob(String uuid){
        log.info("-------------uuid----------------"+uuid);
        return "sssssssssssssss";
    }
}
