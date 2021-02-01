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
    public TaskMonitorRunLogInfo saveInfoLog(String taskMonitorId, String message) throws Exception {

        TaskMonitorRunLogInfo taskRunLog = new TaskMonitorRunLogInfo(taskMonitorId, Level.INFO.toString(), message);
        taskMonitorRunLogInfoDao.save(taskRunLog);
//
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//
//        boolean flag = countDownLatch.await(  20 * 1000L, TimeUnit.MILLISECONDS);
//        Assert.isTrue(1==2,"我报错了");

        ResultVo resultVo = taskMonitorRunLogApi.runJob().queue().get();
        if(resultVo != null){
            System.out.println("------------resultVo------------"+ resultVo.getError());
        }
    //    readSj();
        return null;
    }

    @CacheResult
    public String requestcache(@CacheKey String uuid)  {
        return taskMonitorRunLogApi.findJob(uuid);
    }
    public void readSj() throws Exception {

        File file = new File("C:\\Users\\70765\\Desktop\\ssssss\\shuj.txt");

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int i = 0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                String mystr = br.readLine();
                System.out.println("mystr"+mystr);
                if(mystr != null){
                    String[]  str = mystr.split("\\|");
                    String taskName  = str[0];
                    String startTime = str[1];
                    String endTime   = str[2];
                    String cron    = str[3];
                    String processDefinitionId = str[4];
                    System.out.println("taskName"+taskName);
                    System.out.println("startTime"+startTime);
                    System.out.println("endTime"+endTime);
                    System.out.println("cron"+cron);
                    System.out.println("processDefinitionId"+processDefinitionId);

                    System.out.println("-------i----------"+ (++i));

                    Map<String, String> map = new HashMap<>();
                    map.put(cron, startTime);
                    testCronAlg(map,endTime,processDefinitionId,taskName);
                }
            }
            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public  void testCronAlg(Map<String, String> map,String endTimeStr,String processDefinitionId,String taskName) throws Exception {
        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(++count);
            System.out.println("cron = "+entry.getKey());
            System.out.println("date = "+entry.getValue());
            CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(entry.getKey());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(entry.getValue());
            Date endTime = sdf.parse(endTimeStr);
            String str2 = null;
            Date mydate = sdf.parse(str2 == null ?entry.getValue():str2);
            while(mydate.before(endTime)) {
                Date date2 = null;
                try {
                    date2 = cronSequenceGenerator.next(date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (date2 != null) {
                    str2 = sdf.format(date2);
                }
                date = date2;
                mydate = date2;
                String sssssss = "insert into  ods.szj_mrst_schedules(task_name,task_time,process_definition_id,update_flag)  value (`"+taskName+"`,`"+str2+"`,`"+processDefinitionId+"`,"+1+")";
                JobMonitorRunLogInfo  jobRunLog =  new JobMonitorRunLogInfo("myyc", Level.INFO.toString(), sssssss);
                jobMonitorRunLogInfoDao.save(jobRunLog);
            }
        }
    }
//    public TaskMonitorRunLogInfo saveLogwaite(String taskMonitorId, String message)  {
//        TaskMonitorRunLogInfo runLog = new TaskMonitorRunLogInfo(taskMonitorId, Level.INFO.toString(), message);
//        long startTime = System.currentTimeMillis();
//        TaskMonitorRunLogInfo taskMonitorRunLogInfo = taskMonitorRunLogInfoDao.save(runLog);
//        long endTime = System.currentTimeMillis();
//        System.out.println ("--------------插入消耗时间--------------"+ (endTime - startTime));
//
//        return taskMonitorRunLogInfo;
//    }
//    public List<TaskMonitorRunLogInfo> queryInfoLog(String taskMonitorId) {
//        TaskMonitorRunLogInfo taskMonitorRunLogInfo = new TaskMonitorRunLogInfo();
//        taskMonitorRunLogInfo.setTaskMonitorId(taskMonitorId);
//        Example<TaskMonitorRunLogInfo> example = Example.of(taskMonitorRunLogInfo);
//        long startTime = System.currentTimeMillis();
//        List<TaskMonitorRunLogInfo> taskMonitorRunLogInfoList = taskMonitorRunLogInfoDao.findAll(example);
//        long endTime = System.currentTimeMillis();
//        System.out.println ("--------------查询消耗时间--------------"+ (endTime - startTime));
//        return taskMonitorRunLogInfoList;
//    }
}
