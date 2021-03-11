package com.fen.dou.quartztest.app.entity;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Date;

@Data
public class ResourcePool implements java.io.Serializable {

    private static final long serialVersionUID = -2716383796475172000L;


    private Integer registryId;


    private String resourcePoolUuid;


    private ResourcePoolConfig resourcePoolConfig;


    private String resourcePoolName;


    private String resourcePoolDesc;


    private String appNo;


    private Integer status;


    private Integer poolPriority;


    private String createUser;


    private Date createTime;


    private Date updateTime;

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
}
