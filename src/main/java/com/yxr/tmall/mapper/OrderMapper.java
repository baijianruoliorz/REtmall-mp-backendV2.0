package com.yxr.tmall.mapper;

import com.yxr.tmall.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
//可以直接用basemapper
//    basemapper会自动继承你写的
@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {

}
