package com.fen.dou.hikarietest.dao;

import com.fen.dou.hikarietest.basic.BasicRepository;
import com.fen.dou.hikarietest.entity.TaskMonitorRunLogInfo;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 16:59 2019/9/25
 * @Modified By:
 */
public interface TaskMonitorRunLogInfoDao extends BasicRepository<TaskMonitorRunLogInfo, String> {

    /**
     * 根据监控id删除监控
     * @param taskMonitorIds
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteByTaskMonitorIdIn(List<String> taskMonitorIds);

    @Modifying
//    @Transactional(rollbackFor = Exception.class,timeout=5)
    @Query(value = "insert  into task_monitor_run_log_info(`log_uuid`, `create_time`, `log_level`, `log_message`, `log_time`, `task_monitor_id`) values(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void insertIgnoreLog(String uuid, Date createTime, String logLevel, String logMessage, Long logTime, String taskMonitorId);

}
