package com.yxr.tmall.service.impl;

import com.yxr.tmall.entity.User;
import com.yxr.tmall.exceptionhandler.GuliException;
import com.yxr.tmall.mapper.UserMapper;
import com.yxr.tmall.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserByname(String name) {
        return baseMapper.queryUserByname(name);
    }
//判断用户民是否被使用
    @Override
    public void isExist(String name) {
        User user = userMapper.queryUserByname(name);
        if (user!=null){
            throw new GuliException(20001,"用户名已存在");
        }
    }
}
