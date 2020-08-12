package com.yxr.tmall.controller;


import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.config.MD5;
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
import org.springframework.data.convert.EntityWriter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        String s = String.valueOf(System.currentTimeMillis());
        user.setSalt(s);
        String name = user.getName();
        String password = user.getPassword();
        user.setPassword(MD5.encrypt(password+s));
        userService.isExist(name);
        userService.save(user);
       return R.ok();
    }

    @PostMapping("/login")
    public R login(@RequestBody User user){
        User user1 = userMapper.queryUserByname(user.getName());
        String password = user.getPassword();
        String s=password+user1.getSalt();
        s=MD5.encrypt(s);

        User userLogin = userMapper.getByNameAndPassword(user.getName(),s);
        if (userLogin==null){
            throw new GuliException(20001,"用户名或密码错误!!!");
        }else {
            return R.ok().data("user",userLogin);
        }
    }

//    模糊查询
    @PostMapping("/search")
    public R searchUserInfo(@RequestParam("name") String name){
        List<User> users = userService.searchByName(name);
        return R.ok().data("userList",users);
    }

    @GetMapping("whoami/{id}")
    public R whoAmI(@PathVariable String id){
        User user = userService.getById(id);
        return R.ok().data("You are...:",user);
    }

}


