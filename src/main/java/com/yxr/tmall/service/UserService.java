package com.yxr.tmall.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.yxr.tmall.entity.User;
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
public interface UserService extends IService<User> {
    public User queryUserByname(String name);

    void isExist(String name);

//    模糊查询
    List<User> searchByName(String name);

}
