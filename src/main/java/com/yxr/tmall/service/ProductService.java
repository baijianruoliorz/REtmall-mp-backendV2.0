package com.yxr.tmall.service;

import com.yxr.tmall.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
public interface ProductService extends IService<Product> {
//   删除商品
    void removeProduct(String productId);

    List<Product> searchProduct(String productName);
}
