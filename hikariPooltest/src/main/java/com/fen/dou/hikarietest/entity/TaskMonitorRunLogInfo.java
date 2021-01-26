package com.fen.dou.hikarietest.entity;

import com.fen.dou.hikarietest.util.SystemUtils;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 15:09 2019/5/24
 * @Modified By:
 */
@Data
@Entity
@Table(name = "task_monitor_run_log_info",
        indexes = {@Index(name = "log_info_index_taskMonitorId", columnList="task_monitor_id")})
public class TaskMonitorRunLogInfo implements Serializable {

    private static final long serialVersionUID = -7585737576009373448L;

    public TaskMonitorRunLogInfo(){}
    public TaskMonitorRunLogInfo(String taskMonitorId, String logLevel, String logMessage){
        this.logUuid = SystemUtils.getUUID();
        this.taskMonitorId = taskMonitorId;
        this.logLevel = logLevel;
        this.logMessage = logMessage;
        Date date = new Timestamp(System.currentTimeMillis());
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
     * 日志创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 任务监控id
     */
    @Column(name = "task_monitor_id", length = 50)
    private String taskMonitorId;

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
