package com.fen.dou.hikarietest.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by 落叶 on 2019-05-17.
 */
@NoRepositoryBean
public interface BasicRepository<T,ID extends Serializable>
    extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {


}
