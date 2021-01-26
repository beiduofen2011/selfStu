package com.fen.dou.hikarietest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

/**
 * Created by 落叶 on 2019-05-17.
 */
public class BasicVo {

  @JsonIgnore
  public Set<String> groupSet = null;

  @JsonIgnore
  private Object handler = null;

  public Object getHandler() {
    return handler;
  }

  public void setHandler(Object handler) {
    this.handler = handler;
  }


  public Set<String> getGroupSet() {
    return groupSet;
  }

  public void setGroupSet(Set<String> groupSet) {
    this.groupSet = groupSet;
  }

}
