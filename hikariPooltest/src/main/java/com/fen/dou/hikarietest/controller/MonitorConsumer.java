package com.fen.dou.hikarietest.controller;

import com.fen.dou.hikarietest.entity.TaskMonitorRunLogInfo;
import com.fen.dou.hikarietest.entity.TaskMonitorRunLogInfoVo;
import com.fen.dou.hikarietest.service.TaskMonitorRunLogService;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonitorConsumer {
    @Autowired
    private TaskMonitorRunLogService taskMonitorRunLogService;


    @PostMapping("/save")
    public TaskMonitorRunLogInfo saveLog(@RequestBody TaskMonitorRunLogInfoVo taskMonitorRunLogInfoVo) throws Exception {
        String taskManagerId = taskMonitorRunLogInfoVo.getTaskMonitorId();
        String message = taskMonitorRunLogInfoVo.getLogMessage();
        return taskMonitorRunLogService.saveInfoLog(taskManagerId,message);
    }

    @GetMapping("/requestcache")
    public String requestcache(String uuid) throws Exception {
        @Cleanup HystrixRequestContext context = HystrixRequestContext.initializeContext();
        taskMonitorRunLogService.requestcache(uuid);
        String sss = taskMonitorRunLogService.requestcache(uuid);
        return sss;
    }
//    @PostMapping("/save/waite")
//    public TaskMonitorRunLogInfo saveLogwaite(@RequestBody TaskMonitorRunLogInfoVo taskMonitorRunLogInfoVo){
//        String taskManagerId = taskMonitorRunLogInfoVo.getTaskMonitorId();
//        String message = taskMonitorRunLogInfoVo.getLogMessage();
//        return taskMonitorRunLogService.saveLogwaite(taskManagerId,message);
//    }
//    @RequestMapping("/queryList/{taskManagerId}")
//    public List<TaskMonitorRunLogInfo> query(@PathVariable("taskManagerId") String taskManagerId){
//        return taskMonitorRunLogService.queryInfoLog(taskManagerId);
//    }
}
