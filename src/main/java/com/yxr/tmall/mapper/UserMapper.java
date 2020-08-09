package com.yxr.tmall.mapper;

import com.yxr.tmall.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.Null;
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
public interface UserMapper extends BaseMapper<User> {

    public User queryUserByname(String name);
    User getByNameAndPassword(String name, String password);



}
