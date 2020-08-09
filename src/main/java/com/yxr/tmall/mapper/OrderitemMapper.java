package com.yxr.tmall.mapper;

import com.yxr.tmall.entity.Orderitem;
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
@Mapper
@Repository
public interface OrderitemMapper extends BaseMapper<Orderitem> {

}
