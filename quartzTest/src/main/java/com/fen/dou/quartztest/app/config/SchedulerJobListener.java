package com.fen.dou.quartztest.app.config;


import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 17:32 2019/5/18
 * @Modified By:
 */
@Slf4j
public class SchedulerJobListener implements JobListener {

    /**
     * 用于获取触发器的名称
     * @return
     */
    @Override
    public String getName() {
        return "data-factory-scheduler";
    }

    /**
     * Scheduler在JobDetail将要被执行时调用这个方法。
     * @param context
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {

        log.info("==============jobToBeExecuted execute job keys : " +"xx");
    }

    /**
     * Scheduler在JobDetail即将被执行，但又被TriggerListerner否决时会调用该方法
     * @param context
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {

        log.info("==============jobExecutionVetoed execute job keys : " +"xx");
    }

    /**
     * Scheduler在JobDetail被执行之后调用这个方法
     * @param context
     * @param jobException
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

        log.info("Scheduler在JobDetail被执行之后调用这个方法。{}","xxx");

    }
}
