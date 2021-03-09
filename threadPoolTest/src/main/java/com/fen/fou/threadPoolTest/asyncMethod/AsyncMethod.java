package com.fen.fou.threadPoolTest.asyncMethod;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncMethod {

   @Async("taskExecutor")
   public Future<String>  say(){
      Future<String> future;
      try {
         Thread.sleep(1000 * 10);
         future = new AsyncResult<String>("success:1" +1 );
      } catch (InterruptedException e) {
         future = new AsyncResult<String>("error");
      }
      return future;
   }

}
