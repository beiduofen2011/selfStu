package com.fen.dou.quartztest.app.config;


import com.fen.dou.quartztest.app.entity.ResourcePoolConfig;
import com.fen.dou.quartztest.app.entity.TaskManagerModel;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 17:37 2019/5/18
 * @Modified By:
 */
@Slf4j
public class QuartzManager {

    /**
     * 添加定时任务
     * @param quartzResourcePoolService
     * @param resourcePoolConfig
     * @param taskManagerModel
     */
    public static Trigger addJob(QuartzResourcePoolService quartzResourcePoolService, ResourcePoolConfig resourcePoolConfig,
                                 TaskManagerModel taskManagerModel){
        // 创建Trigger对象
        Trigger trigger = null;
        try {
            StdScheduler scheduler = quartzResourcePoolService.getSchedulerFactoryBean(resourcePoolConfig.getBeanName());
            TriggerKey triggerKey = TriggerKey.triggerKey(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
            if(scheduler.checkExists(triggerKey)){
                trigger = modifyJob(quartzResourcePoolService, resourcePoolConfig, taskManagerModel);
            } else {
                JobDataMap jobDataMap = new JobDataMap();
                jobDataMap.put("taskManagerId", taskManagerModel.getTaskManagerId());
                // 任务名，任务组，任务执行类
                JobDetail jobDetail= JobBuilder.newJob((Class<? extends Job>) Class.forName(taskManagerModel.getClassName()))
                        .withIdentity(taskManagerModel.getJobName(), taskManagerModel.getJobGroup()).setJobData(jobDataMap).build();
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
                // 设置优先级
                triggerBuilder.withPriority(taskManagerModel.getTaskPriority() != null ? taskManagerModel.getTaskPriority() : 0);
                triggerBuilder.startNow();
                // 触发器时间设定
                if(StringUtils.isEmpty(taskManagerModel.getCron())){
                    // 为设置cron值
                    triggerBuilder.startNow();
                    // 立刻执行
                    triggerBuilder.withSchedule(SimpleScheduleBuilder.simpleSchedule().
                            withMisfireHandlingInstructionFireNow());
                } else {
                    triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(taskManagerModel.getCron()));

                }
                trigger = triggerBuilder.build();

                // 调度容器设置JobDetail和Trigger
                scheduler.scheduleJob(jobDetail, trigger);
                GroupMatcher<JobKey> matcher = GroupMatcher.jobGroupStartsWith(taskManagerModel.getJobGroup());
                scheduler.getListenerManager().addJobListener(new SchedulerJobListener(), matcher);
                if(StringUtils.isEmpty(taskManagerModel.getCron())) {
                    scheduler.start();
                }
            }
        } catch (SchedulerException e) {
            throw new BasicException("add job scheduler error...", e);
        } catch (ClassNotFoundException e) {
            throw new BasicException("job class name not found error...", e);
        } catch (Exception e) {
            throw new BasicException("add job other error...", e);
        }
        return trigger;
    }

    /**
     * 重新运行任务
     * @param quartzResourcePoolService
     * @param resourcePoolConfig
     * @param taskManagerModel
     * @return
     */
    public static Trigger reRunJob(QuartzResourcePoolService quartzResourcePoolService, ResourcePoolConfig resourcePoolConfig,
                                   TaskManagerModel taskManagerModel, long delayDuration){
        return reRunJob(quartzResourcePoolService, resourcePoolConfig, taskManagerModel, delayDuration, null);
    }

    /**
     * 重新运行任务
     * @param quartzResourcePoolService
     * @param resourcePoolConfig
     * @param taskManagerModel
     * @return
     */
    public static Trigger reRunJob(QuartzResourcePoolService quartzResourcePoolService, ResourcePoolConfig resourcePoolConfig,
                                   TaskManagerModel taskManagerModel, long delayDuration, Map<String, String> paramsMap){
        // 创建Trigger对象
        Trigger trigger = null;
        try {
            StdScheduler scheduler = quartzResourcePoolService.getSchedulerFactoryBean(resourcePoolConfig.getBeanName());
            TriggerKey triggerKey = TriggerKey.triggerKey(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
            if (scheduler.checkExists(triggerKey)) {
                trigger = modifyJob(quartzResourcePoolService, resourcePoolConfig, taskManagerModel);
            } else {
                JobDataMap jobDataMap = new JobDataMap();
                jobDataMap.put("taskManagerId", taskManagerModel.getTaskManagerId());
                jobDataMap.put("isRerun", true);
                // 参数复制
                if(paramsMap != null){
                    jobDataMap.putAll(paramsMap);
                }
                // 任务名，任务组，任务执行类
                JobDetail jobDetail= JobBuilder.newJob((Class<? extends Job>) Class.forName(taskManagerModel.getClassName()))
                        .withIdentity(taskManagerModel.getJobName(), taskManagerModel.getJobGroup()).setJobData(jobDataMap).build();
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
                // 设置优先级
                triggerBuilder.withPriority(taskManagerModel.getTaskPriority() != null ? taskManagerModel.getTaskPriority() : 0);

                LocalDateTime currentTime = LocalDateTime.now();
                LocalDateTime startTime = currentTime.plusSeconds(delayDuration);
                LocalDateTime endTime = currentTime.plusSeconds(delayDuration + 60);
                triggerBuilder.startAt(Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant()));
                triggerBuilder.endAt(Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()));

                trigger = triggerBuilder.build();
                // 调度容器设置JobDetail和Trigger
                scheduler.scheduleJob(jobDetail, trigger);
                GroupMatcher<JobKey> matcher = GroupMatcher.jobGroupStartsWith(taskManagerModel.getJobGroup());
                scheduler.getListenerManager().addJobListener(new SchedulerJobListener(), matcher);
                if(StringUtils.isEmpty(taskManagerModel.getCron())) {
                    scheduler.start();
                }
            }
        } catch (SchedulerException e) {
            throw new BasicException("add job scheduler error...", e);
        } catch (ClassNotFoundException e) {
            throw new BasicException("job class name not found error...", e);
        } catch (Exception e) {
            throw new BasicException("add job other error...", e);
        }
        return trigger;
    }

    /**
     * 更新job信息
     * @param quartzResourcePoolService
     * @param resourcePoolConfig
     * @param taskManagerModel
     */
    public static Trigger modifyJob(QuartzResourcePoolService quartzResourcePoolService, ResourcePoolConfig resourcePoolConfig,
                                    TaskManagerModel taskManagerModel){
        // 创建Trigger对象
        Trigger trigger = null;
        try {
            StdScheduler scheduler = quartzResourcePoolService.getSchedulerFactoryBean(resourcePoolConfig.getBeanName());
            TriggerKey triggerKey = TriggerKey.triggerKey(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
            if(scheduler.checkExists(triggerKey)){
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
                // 设置优先级
                triggerBuilder.withPriority(taskManagerModel.getTaskPriority());
                triggerBuilder.startNow();
                // 触发器时间设定
                if(StringUtils.isEmpty(taskManagerModel.getCron())){
                    // 立刻执行
                    triggerBuilder.withSchedule(SimpleScheduleBuilder.simpleSchedule().
                            withMisfireHandlingInstructionFireNow());
                } else {
                    triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(taskManagerModel.getCron()));
                }

                trigger = triggerBuilder.build();
                scheduler.rescheduleJob(triggerKey, trigger);
                GroupMatcher<JobKey> matcher = GroupMatcher.jobGroupStartsWith(taskManagerModel.getJobGroup());
                scheduler.getListenerManager().addJobListener(new SchedulerJobListener(), matcher);
            } else {
                addJob(quartzResourcePoolService, resourcePoolConfig, taskManagerModel);
            }
        } catch (SchedulerException e) {
            throw new BasicException(e.getMessage());
        } catch (Exception e) {
            throw new BasicException("add job other error...", e);
        }
        return trigger;
    }

    /**
     * 删除定时任务
     * @param quartzResourcePoolService
     * @param beanName
     * @param taskManagerModel
     * @return
     */
    public static boolean deleteJob(QuartzResourcePoolService quartzResourcePoolService, String beanName, TaskManagerModel taskManagerModel){
        boolean result = false;
        try {
            StdScheduler scheduler = quartzResourcePoolService.getSchedulerFactoryBean(beanName);
            TriggerKey triggerKey = TriggerKey.triggerKey(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
            if(scheduler.checkExists(triggerKey)){
                // 获取trigger
                Trigger trigger = scheduler.getTrigger(triggerKey);
                // 停止触发器
                scheduler.pauseTrigger(triggerKey);
                // 删除任务
                if(trigger != null){
                    result = scheduler.deleteJob(trigger.getJobKey());
                }else{
                    // 移除触发器
                    scheduler.unscheduleJob(triggerKey);
                }
            }
        } catch (SchedulerException e) {
            throw new BasicException(e.getMessage());
        } catch (Exception e) {
            throw new BasicException("add job other error...", e);
        }
        return result;
    }

    /**
     * 停止任务
     * @param quartzResourcePoolService
     * @param beanName
     * @param taskManagerModel
     */
    public static void pauseJob(QuartzResourcePoolService quartzResourcePoolService, String beanName, TaskManagerModel taskManagerModel){
        try {
            StdScheduler scheduler = quartzResourcePoolService.getSchedulerFactoryBean(beanName);
            TriggerKey triggerKey = TriggerKey.triggerKey(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
            if(scheduler.checkExists(triggerKey)){
                scheduler.pauseTrigger(triggerKey);
            }
        } catch (SchedulerException e) {
            throw new BasicException(e.getMessage());
        } catch (Exception e) {
            throw new BasicException("add job other error...", e);
        }
    }

    /**
     * 再次启动Job
     * @param quartzResourcePoolService
     * @param beanName
     * @param taskManagerModel
     */
    public static void resumeJob(QuartzResourcePoolService quartzResourcePoolService, String beanName, TaskManagerModel taskManagerModel){
        try {
            StdScheduler scheduler = quartzResourcePoolService.getSchedulerFactoryBean(beanName);
            TriggerKey triggerKey = TriggerKey.triggerKey(taskManagerModel.getJobName(), taskManagerModel.getJobGroup());
            if(scheduler.checkExists(triggerKey)){
                scheduler.resumeTrigger(triggerKey);
            }
        } catch (SchedulerException e) {
            throw new BasicException(e.getMessage());
        } catch (Exception e) {
            throw new BasicException("add job other error...", e);
        }
    }

}
