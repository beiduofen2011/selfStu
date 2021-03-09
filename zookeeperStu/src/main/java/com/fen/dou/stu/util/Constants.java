package com.fen.dou.stu.util;

/**
 * Created by 落叶 on 2018/1/29.
 * 常量类
 */
public class Constants {

    /**
     * zookeeper根路径
     */
    public static final String ZOOKEEPER_ROOT = "/dfrun";
    /**
     * 任务节点
     */
    public static final String ZOOKEEPER_SCHEDULER = "/tasks";
    /**
     * 临时节点
     */
    public static final String ZOOKEEPER_TEMP = "/nodes";

    /**
     * 环境变量节点
     */
    public static final String ZOOKEEPER_ENV = "/env";

    /**
     * FTP的IP、端口参数节点
     */
    public static final String ZOOKEEPER_FTP = "/ftp";

    /**
     * 默认运行节点信息
     */
    public static final String EXECUTOR_CLUSTER_DEFAULT = "default";

    /**
     * 默认编码
     */
    public static final String DEFAULT_CHARSET = "utf-8";


    /**
     * 任务运行的PID
     */
    public static final String TASK_PID = "PID";
    public static final String RETURN_CODE = "RETURN_CODE";


    /**
     * 任务下次执行标记
     */
    public static final String TASK_NEXT_STEP_START = "start";
    public static final String TASK_NEXT_STEP_DELETE = "delete";
    public static final String TASK_NEXT_STEP_FINISH = "finish";
    public static final String TASK_NEXT_STEP_KILL = "kill";

    public static final String ZK_PATH = "zkPath";

}
