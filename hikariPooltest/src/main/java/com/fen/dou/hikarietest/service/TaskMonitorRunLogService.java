package com.fen.dou.hikarietest.service;


import com.fen.dou.hikarietest.api.TaskMonitorRunLogApi;
import com.fen.dou.hikarietest.dao.JobMonitorRunLogInfoDao;
import com.fen.dou.hikarietest.dao.TaskMonitorRunLogInfoDao;
import com.fen.dou.hikarietest.entity.JobMonitorRunLogInfo;
import com.fen.dou.hikarietest.entity.ResultVo;
import com.fen.dou.hikarietest.entity.TaskMonitorRunLogInfo;
import com.google.gson.JsonParser;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 16:59 2019/9/25
 * @Modified By:
 */
@Service
@Slf4j
public class TaskMonitorRunLogService {

    @Autowired
    private TaskMonitorRunLogInfoDao taskMonitorRunLogInfoDao;

    @Autowired
    private JobMonitorRunLogInfoDao jobMonitorRunLogInfoDao;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    private TaskMonitorRunLogApi taskMonitorRunLogApi;

//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public String saveInfoLog(String taskMonitorId, String message) throws Exception {
        TaskMonitorRunLogInfo taskRunLog = new TaskMonitorRunLogInfo(taskMonitorId, Level.INFO.toString(), message);
        taskMonitorRunLogInfoDao.save(taskRunLog);
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        boolean flag = countDownLatch.await(  20 * 1000L, TimeUnit.MILLISECONDS);
//        Assert.isTrue(1==2,"我报错了");
        taskMonitorRunLogApi.runJob();
        return "success";
    }
    @CacheResult
    public String requestcache(@CacheKey String uuid)  {
        return taskMonitorRunLogApi.findJob(uuid);
    }
    public String timeout(long timel)  {
        return taskMonitorRunLogApi.timeout(timel);
    }
    public String exception()  {
        return taskMonitorRunLogApi.exception();
    }
    public String maxRequestNum()  {
        return taskMonitorRunLogApi.maxRequestNum();
    }
    public String testCircuit()  {
        return taskMonitorRunLogApi.testCircuit();
    }
}
