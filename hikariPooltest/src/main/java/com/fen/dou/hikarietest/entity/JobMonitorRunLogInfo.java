package com.fen.dou.hikarietest.entity;

import com.fen.dou.hikarietest.util.SystemUtils;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 20:21 2020/2/13
 * @Modified By:
 */
@Setter
@Getter
@Entity
@Table(name = "job_monitor_run_log_info",
        indexes = {@Index(name = "job_run_log_index_monitorId", columnList="monitor_id")})
public class JobMonitorRunLogInfo implements Serializable {

    private static final long serialVersionUID = -7585737576009373558L;

    public JobMonitorRunLogInfo(){}

    public JobMonitorRunLogInfo(String monitorId, String logLevel, String logMessage){
        this.logUuid = SystemUtils.getUUID();
        this.monitorId = monitorId;
        this.logLevel = logLevel;
        this.logMessage = logMessage;
        Date date = new Date();
        this.logTime = date.getTime();
        this.createTime = date;
    }

    /**
     * 节点id
     */
    @Id
    @Column(name = "log_uuid", length = 50)
    private String logUuid;

    /**
     * 任务监控id
     */
    @Column(name = "monitor_id", length = 50)
    private String monitorId;

    /**
     * 监控批次号
     */
    @Column(name = "log_level", length = 20)
    private String logLevel;

    /**
     * 监控信息
     */
    @Column(name = "log_message", columnDefinition="text")
    private String logMessage;

    /**
     * 任务运行时间
     */
    @Column(name = "log_time")
    private Long logTime;

    /**
     * 任务运行时间
     */
    @Column(name = "create_time")
    private Date createTime;

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

}
