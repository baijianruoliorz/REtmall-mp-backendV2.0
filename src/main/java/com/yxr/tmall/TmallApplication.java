package com.yxr.tmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication


public class TmallApplication {

    public static void main(String[] args) {
       // sapplication.setBannerMode(Banner.Mode.OFF*);

        SpringApplication.run(TmallApplication.class, args);
    }

}
