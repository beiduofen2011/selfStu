package com.fen.dou.hikarietest.entity;
import java.util.List;

/**
 * Created by 落叶 on 2018/6/26.
 */
public class PageMsg<T> implements java.io.Serializable{

  private static final long serialVersionUID = 5433110424045317237L;

  public PageMsg() {
  }

  public PageMsg(int pageNo, int rows, List<?> data, long totalRows, int totalPages) {
    this.pageNo = pageNo;
    this.rows = rows;
    this.data = data;
    this.totalRows = totalRows;
    this.totalPages = totalPages;
  }

  private int pageNo;

  private int rows;

  private List<?> data;

  private long totalRows;

  private int totalPages;

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public List<?> getData() {
    return data;
  }

  public void setData(List<?> data) {
    this.data = data;
  }

  public long getTotalRows() {
    return totalRows;
  }

  public void setTotalRows(long totalRows) {
    this.totalRows = totalRows;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }
}
