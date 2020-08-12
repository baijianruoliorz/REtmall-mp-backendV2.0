package com.yxr.tmall.controller;


import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Productimage;
import com.yxr.tmall.service.ProductimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/tmall/productimage")
public class ProductimageController {

    @Autowired
    private ProductimageService productimageService;
    @GetMapping("/getImages/{id}")
    public R getImages(@PathVariable String id)
    {
        Productimage productimage = productimageService.getById(id);
        return R.ok().data("productImages",productimage);
    }

}

