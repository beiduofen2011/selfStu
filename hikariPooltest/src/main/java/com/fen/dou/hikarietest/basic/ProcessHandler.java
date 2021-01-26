package com.fen.dou.hikarietest.basic;

import com.fen.dou.hikarietest.exception.BasicException;

/**
 * Created by 落叶 on 2019-05-22.
 */
public interface ProcessHandler<S,T> {

  ThreadLocal<Object> data = new ThreadLocal<>();

  T fillEntity(T t);

  void checkFail(S s) throws BasicException;


  default void putData(T t) {
    data.set(t);
  }

  default T getData() {
    return (T) data.get();
  }
}
