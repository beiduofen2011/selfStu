package com.fen.dou.hikarietest.hystrix;

import com.fen.dou.hikarietest.api.TaskMonitorRunLogApi;
import com.fen.dou.hikarietest.entity.ResultVo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandGroupKey;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 落叶 on 2019/10/13.
 */
@Component
public class ServiceRequestFallback implements FallbackFactory<TaskMonitorRunLogApi> {
    //对服务分组，方便统计一些数据
  private static final Setter hystrixCommandGroupKey =
      Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TaskMonitorRunLogApi"));

  @Override
  public TaskMonitorRunLogApi create(Throwable cause) {

    return new TaskMonitorRunLogApi() {
      @Override
      public HystrixCommand<ResultVo> runJob() {
        cause.printStackTrace();
        return new HystrixCommand<ResultVo>(hystrixCommandGroupKey){
          @Override
          protected ResultVo run() throws Exception {
            return new ResultVo(1,"服务调用失败");
          }
        };
      }
    };
  }
}
