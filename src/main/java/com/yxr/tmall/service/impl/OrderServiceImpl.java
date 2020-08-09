package com.yxr.tmall.service.impl;

import com.yxr.tmall.entity.Order;
import com.yxr.tmall.mapper.OrderMapper;
import com.yxr.tmall.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
