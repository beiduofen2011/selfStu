package com.fen.dou.quartztest.app.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TaskManagerModel implements Serializable {

    private static final long serialVersionUID = 5624353752769800907L;

    private String taskManagerId;

    /**
     * 任务所属资源池
     */
    private String registryId;


    private String className;


    private String taskName;


    private String jobName;


    private String jobGroup;


    private String cron;

    private Date startTime;


    private Date endTime;


    private Short quartzStatus;


    private Short taskStatus;


    private Short lastRunStatus;


    private Short taskType;


    private Integer taskPriority;


    private Date createTime;


    private Date updateTime;

    private String taskExecutionId;


    private Date lastRunTime;


    private Date nextRunTime;


    private Long runCount;

    private Short importType;


    public Date getCreateTime() {
        if(this.createTime != null){
            return new Date(this.createTime.getTime());
        }
        return null;
    }

    public void setCreateTime(Date createTime) {
        if(createTime != null){
            this.createTime = (Date) createTime.clone();
        } else {
            this.createTime = null;
        }
    }

    public Date getUpdateTime() {
        if(this.updateTime != null){
            return new Date(this.updateTime.getTime());
        }
        return null;
    }

    public void setUpdateTime(Date updateTime) {
        if(updateTime != null){
            this.updateTime = (Date) updateTime.clone();
        } else {
            this.updateTime = null;
        }
    }

    public Date getStartTime() {
        if(this.startTime != null){
            return new Date(this.startTime.getTime());
        }
        return null;
    }

    public void setStartTime(Date startTime) {
        if(startTime != null){
            this.startTime = (Date) startTime.clone();
        } else {
            this.startTime = null;
        }
    }

    public Date getEndTime() {
        if(this.endTime != null){
            return new Date(this.endTime.getTime());
        }
        return null;
    }

    public void setEndTime(Date endTime) {
        if(endTime != null){
            this.endTime = (Date) endTime.clone();
        } else {
            this.endTime = null;
        }
    }

    public Date getLastRunTime() {
        if(this.lastRunTime != null){
            return new Date(this.lastRunTime.getTime());
        }
        return null;
    }

    public void setLastRunTime(Date lastRunTime) {
        if(lastRunTime != null){
            this.lastRunTime = (Date) lastRunTime.clone();
        } else {
            this.lastRunTime = null;
        }
    }

    public Date getNextRunTime() {
        if(this.nextRunTime != null){
            return new Date(this.nextRunTime.getTime());
        }
        return null;
    }

    public void setNextRunTime(Date nextRunTime) {
        if(nextRunTime != null){
            this.nextRunTime = (Date) nextRunTime.clone();
        } else {
            this.nextRunTime = null;
        }
    }
}
