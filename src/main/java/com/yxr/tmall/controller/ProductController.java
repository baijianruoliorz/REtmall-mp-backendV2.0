package com.yxr.tmall.controller;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Product;
import com.yxr.tmall.exceptionhandler.GuliException;
import com.yxr.tmall.mapper.ProductMapper;
import com.yxr.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

@Autowired
private ProductMapper productMapper;
//defaulter
  @GetMapping("/1")
   public R product(){
       Product product = productService.getById(1);
       return R.ok().data("product", product);
   }
//   添加商品
    @PostMapping("addProductInfo")
    public R addProductInfo(@RequestBody Product product){
    productService.save(product);
    return R.ok();
    }
//    根据商品ID进行查询
    @GetMapping("getProductInfo/{productId}")
    public R getProductInfo(@PathVariable String productId){
        Product product = productService.getById(productId);

        return R.ok().data("product",product);
    }
// 删除商品,not default,有点奇怪的是这里ind必须是int 类型和数据库的保持一致(其他方法貌似不需要,,,
    @DeleteMapping  ("{productId}")
    public R deleteProduct(@PathVariable int productId){
        boolean b = productService.removeById(productId);
        if (!b){
            throw new GuliException(20001,"删除失败了,可能是空值~");
        }
        return R.ok();
    }

//    修改
    @PostMapping("updateProduct")
    public R updateProduct(@RequestBody Product product){
      productService.updateById(product);
      return R.ok();
    }



}

