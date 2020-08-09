package com.yxr.tmall.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
  author:liqiqiorz
* */
//必须带这个config 不然扫描不到mapper
@Configuration
@MapperScan("com.yxr.tmall.mapper")
public class EduConfig {
//也可以不写任何东西！


    /**
     * 逻辑删除插件
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {


        return new PaginationInterceptor();
    }


}
