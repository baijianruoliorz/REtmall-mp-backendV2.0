package com.yxr.tmall.service;

import com.yxr.tmall.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
