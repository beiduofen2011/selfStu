package com.fen.dou.hikarietest.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 15:09 2019/5/24
 * @Modified By:
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class TaskMonitorRunLogInfoVo extends BasicVo implements Serializable {

    private static final long serialVersionUID = -7585737576009373448L;

    private String logUuid;


    private String logLevel;


    private String logMessage;


    private Long logTime;


    private Date createTime;

    private String taskMonitorId;

}
