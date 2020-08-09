package com.yxr.tmall.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.yxr.tmall.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface CategoryMapper extends BaseMapper<Category> {


}
