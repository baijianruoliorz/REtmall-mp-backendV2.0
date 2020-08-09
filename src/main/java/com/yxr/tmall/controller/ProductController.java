package com.yxr.tmall.controller;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Product;
import com.yxr.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/tmall/product")
public class ProductController {
@Autowired
   private ProductService productService;
@GetMapping("/1")
   public R product(){
       Product product = productService.getById(1);
      return R.ok().data("product", product);
   }
}

