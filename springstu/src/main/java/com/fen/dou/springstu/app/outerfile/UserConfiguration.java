package com.fen.dou.springstu.app.outerfile;

import com.fen.dou.springstu.app.test1.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//https://blog.csdn.net/lldouble/article/details/80690446
@Configuration
public class UserConfiguration {
    @Bean(name="myTraceListener")
    User myTraceListener() {
        return new User();
    }
}
