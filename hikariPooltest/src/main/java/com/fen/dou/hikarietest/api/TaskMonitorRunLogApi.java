package com.fen.dou.hikarietest.api;


import com.fen.dou.hikarietest.hystrix.ServiceRequestFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "job-provider",contextId = "job-task-monitor-log" ,fallback = ServiceRequestFallback.class)
public interface TaskMonitorRunLogApi {
    @RequestMapping(value = "/runJob",method = RequestMethod.GET)
    public void runJob();

    @RequestMapping(value = "/findJob",method = RequestMethod.GET)
    public String findJob(String uuid);

    @RequestMapping(value = "/timeout/{timel}",method = RequestMethod.GET)
    public String timeout(@PathVariable long timel);

    @RequestMapping(value = "/exception",method = RequestMethod.GET)
    public String exception();

    @RequestMapping(value = "/maxRequestNum",method = RequestMethod.GET)
    public String maxRequestNum() ;

    @RequestMapping(value = "/testCircuit",method = RequestMethod.GET)
    public String testCircuit() ;

}
