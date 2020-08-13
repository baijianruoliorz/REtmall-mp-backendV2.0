package com.yxr.tmall.mapper;

import com.yxr.tmall.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    User queryUserByname(@Param("name") String name);
//    两个参数必须要加@param,一个参数可以省略
    User getByNameAndPassword(@Param("name") String name, @Param("password") String password);

    User getUserByToken(String token);

    void keepTokenById(@Param("id") Integer id, @Param("token") String token);

    void keepTokenByIds(@Param("id") String id);
}
