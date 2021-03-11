package com.fen.dou.quartztest.app.entity;

import lombok.Data;

@Data
public class ResourcePoolConfig implements java.io.Serializable {

    private static final long serialVersionUID = -2716383796475172001L;

    private Integer id;

    private String beanName;

    private String threadNamePrefix;

    private Integer corePoolSize;

    private Integer maxPoolSize;

    private Integer queueCapacity;

    private Integer keepAliveSeconds;

}
