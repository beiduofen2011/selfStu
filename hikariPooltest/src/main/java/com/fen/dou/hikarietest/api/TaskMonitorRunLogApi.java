package com.fen.dou.hikarietest.api;


import com.fen.dou.hikarietest.entity.ResultVo;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "job-provider",contextId = "job-task-monitor-log")
public interface TaskMonitorRunLogApi {


    @RequestMapping(value = "/runJob",method = RequestMethod.GET)
    public HystrixCommand<ResultVo> runJob();
}
