package com.yxr.tmall.config;

import com.yxr.tmall.entity.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liqiqi_tql
 * @date 2020/12/24 -11:21
 */
@Configuration
public class TestBean {
    @Bean
    @ConfigurationProperties(prefix = "test", ignoreUnknownFields = true)
    public Test test(){
        return new Test();
    }

}
