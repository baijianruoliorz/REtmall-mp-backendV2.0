package com.yxr.tmall.service.impl;

import com.yxr.tmall.entity.Product;
import com.yxr.tmall.exceptionhandler.GuliException;
import com.yxr.tmall.mapper.ProductMapper;
import com.yxr.tmall.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired ProductService productService;
    @Override
    public void removeProduct(String productId) {
        int i = baseMapper.deleteById(productId);
        if (i==0){
            throw new GuliException(20001,"删除失败");
        }
    }
}
