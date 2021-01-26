package com.phoenix.data.scheduler.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 17:06 2019/5/19
 * @Modified By:
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {

//    @Primary
    @Bean(name = "dataSourceProperties")
    @Qualifier("dataSourceProperties")
    public HikariConfig dataSourceProperties() {
        HikariConfig hikariConfig = new HikariConfig();
        return hikariConfig;
    }

//    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return new HikariDataSource(dataSourceProperties());
    }

}
