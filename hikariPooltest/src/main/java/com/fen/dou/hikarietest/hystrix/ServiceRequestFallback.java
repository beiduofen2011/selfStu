package com.fen.dou.hikarietest.hystrix;

import com.fen.dou.hikarietest.api.TaskMonitorRunLogApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by 落叶 on 2019/10/13.hog]79fxcvghjiop[
 */
@Slf4j
@Component
public class ServiceRequestFallback implements TaskMonitorRunLogApi {

    @Override
    public void runJob() {
        log.info(Thread.currentThread().getName()+"----------------------------我是runJob的fallback方法");
    }

    @Override
    public String findJob(String uuid) {
        log.info(Thread.currentThread().getName()+"----------------------------我是findJob的fallback方法");
        return "findJob执行降级了";
    }

    @Override
    public String timeout(long timel) {
        log.info(Thread.currentThread().getName()+"----------------------------我是timeout的fallback方法");
        return "timeout执行降级了";
    }

    @Override
    public String exception() {
        log.info(Thread.currentThread().getName()+"----------------------------我是exception的fallback方法");
        return "exception执行降级了";
    }

    @Override
    public String maxRequestNum() {
        log.info(Thread.currentThread().getName()+"----------------------------我是maxRequestNum的fallback方法");
        return "maxRequestNum执行降级了";
    }

    @Override
    public String testCircuit() {
        log.info(Thread.currentThread().getName()+"----------------------------我是testCircuit的fallback方法");
        return "testCircuit执行降级了";
    }
}