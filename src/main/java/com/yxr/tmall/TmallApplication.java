package com.yxr.tmall;

import com.yxr.tmall.utils.PortUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.yxr.tmall.filter") //过滤器生效位置
public class TmallApplication {
//    static {
//        PortUtil.checkPort(6379,"Redis 服务端",true);
//    }

    public static void main(String[] args) {
       // sapplication.setBannerMode(Banner.Mode.OFF*);
        SpringApplication.run(TmallApplication.class, args);
    }

}
