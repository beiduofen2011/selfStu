package com.fen.dou.hikarietest.basic;

import com.fen.dou.hikarietest.entity.BasicVo;
import com.fen.dou.hikarietest.entity.PageMsg;
import com.fen.dou.hikarietest.entity.PageVo;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by 落叶 on 2019-05-15.
 */
public interface BasicServiceInter<S extends BasicVo,T> {

  /**
   * 新增or修改
   * @param s 封装类
   * @return
   */
  public S save(S s);

  /**
   * 批量新增
   * @param tList
   * @return
   */
  public void saveBatch(List<S> sList);

  /**
   * 批量修改
   * @param list
   */
  public void editBatch(List<S> list);

  /**
   * 根据主键删除
   * @param id 主键
   */
  public void delete(Serializable id);

  /**
   * 删除实体
   * @param s 封装类
   */
  public void deleteByEntity(S s);

  /**
   * 根据id查询
   * @param id
   * @return
   */
  public S findOne(Serializable id);


  public Optional<T> findEntity(Serializable id);

  /**
   * 根据实体删除
   * @param s 封装类
   * @return
   */
  public S findOneByEntity(S s);

  /**
   * 查询列表
   * @return
   */
  public List<S> findList();

  public List<S> findListSort(Sort sort);

  /**
   * 调件筛选查询
   * @param s
   * @return
   */
  public List<S> findSelective(S s);

  /**
   * 调件筛选排序
   * @param s
   * @return
   */
  public List<S> findSelectiveSort(S s, Sort sort);


  /**
   * 分页查询
   * @return
   */
  public PageMsg<S> findPage(PageVo<S> pageVo);

  /**
   * 分页查询
   * @return
   */
  public PageMsg<S> findPage(PageVo<S> pageVo, Sort sort);

}
