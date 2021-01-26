package com.fen.dou.hikarietest.dao;


import com.fen.dou.hikarietest.basic.BasicRepository;
import com.fen.dou.hikarietest.entity.JobMonitorRunLogInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 20:39 2020/2/13
 * @Modified By:
 */
public interface JobMonitorRunLogInfoDao extends BasicRepository<JobMonitorRunLogInfo, String> {

    /**
     * 根据监控id删除监控
     * @param monitorIds
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteByMonitorIdIn(List<String> monitorIds);

}
