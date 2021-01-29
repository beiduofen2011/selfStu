package com.fen.dou.hikarietest.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 18:43 2019/6/3
 * @Modified By:
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class ServiceRequestVo extends BasicVo implements Serializable {


    private static final long serialVersionUID = -4496509542796256131L;

    /**
     * 唯一通信id
     */
    private String transId = "";

    /**
     * 结果topic信息
     */
    private String topic = "";

    /**
     * 执行命令
     */
    private String command = "";

    /**
     * 命令需要编译的参数变量
     */
    private Map<String, String> relationParams = new HashMap<>(16);

    /**
     * 超时时间
     */
    private Long timeout = 120000L;

    /**
     * 命令类型 0：普通命令 1：作业命令
     */
    private int commandType = 0;


}