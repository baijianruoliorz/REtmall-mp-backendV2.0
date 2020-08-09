package com.yxr.tmall;

import com.github.dreamyoung.mprelation.AutoMapper;
import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Product;
import com.yxr.tmall.mapper.ProductMapper;
import com.yxr.tmall.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
@MapperScan("com.yxr.tmall.mapper")
class TmallApplicationTests {


    @Autowired
    private ProductService productService;
    @Test
    void Product(){
        Product product = productService.getById(1);
        System.out.println(R.ok().data("product", product));
    }

    @Test
    void contextLoads() {

    }
    }


