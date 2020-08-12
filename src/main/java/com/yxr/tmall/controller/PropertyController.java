package com.yxr.tmall.controller;


import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Property;
import com.yxr.tmall.service.PropertyService;
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
@RequestMapping("/tmall/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    @GetMapping("/getProperty/{id}")
    public R getProperty(@PathVariable String id){
        Property property = propertyService.getById(id);
        return R.ok().data("property",property);
    }

}

