package com.fen.dou.hikarietest.entity;

/**
 * Created by 落叶 on 2019-05-25.
 */
public class PageVo<S>{

  private int pageNo = 1;

  private int limit = 10;

  private S s;

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public S getS() {
    return s;
  }

  public void setS(S s) {
    this.s = s;
  }
}
