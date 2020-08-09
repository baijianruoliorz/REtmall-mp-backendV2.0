package com.yxr.tmall.controller;


import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.User;
import com.yxr.tmall.exceptionhandler.GuliException;
import com.yxr.tmall.mapper.UserMapper;
import com.yxr.tmall.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/tmall/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public R register(@RequestBody User user){
        String name = user.getName();
        String password = user.getPassword();
        userService.isExist(name);
        userService.save(user);
       return R.ok();
    }

    @PostMapping("/login")
    public R login(@RequestBody User user){
        User userLogin = userMapper.queryUserByname(user.getName());
        if (userLogin==null){
            throw new GuliException(20001,"用户名或密码错误!!!");
        }else {
            return R.ok().data("user",userLogin);
        }
    }

}


