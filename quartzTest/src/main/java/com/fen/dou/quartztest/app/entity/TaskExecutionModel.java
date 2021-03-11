package com.fen.dou.quartztest.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class TaskExecutionModel implements Serializable {

    private static final long serialVersionUID = -5933663139152713256L;

    private String taskExecutionId;


    private String taskExecutionCommand;


    private String taskExecutionModelId;


    private Date updateTime;


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
}
