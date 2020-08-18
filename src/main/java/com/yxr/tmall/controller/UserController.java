package com.yxr.tmall.controller;


import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.config.MD5;
import com.yxr.tmall.entity.Review;
import com.yxr.tmall.entity.User;
import com.yxr.tmall.exceptionhandler.GuliException;
import com.yxr.tmall.mapper.UserMapper;
import com.yxr.tmall.service.ReviewService;
import com.yxr.tmall.service.UserService;
import com.yxr.tmall.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private ReviewService reviewService;
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
    public R login(@RequestBody User user, HttpServletRequest request,HttpSession httpSession){
        User user2 = userService.queryUserByname(user.getName());

        HttpSession session = request.getSession();

        System.out.println("+++++++");
        System.out.println(session.getId()==httpSession.getId());
        if (user2==null){
            return R.error().message("用户不存在,请创造一个新用户!!!");
        }
        if (user2.getToken()!=null){
            httpSession.setAttribute("user",user2);
            return R.error().message("该用户已经登录");
        }
        user.setToken(session.getId());
        user2.setToken(session.getId());
        httpSession.setAttribute("user",user2);
        userMapper.keepTokenById(user2.getId(),user.getToken());

        User user1 = userMapper.queryUserByname(user.getName());
        String password = user.getPassword();

        String s=password+user1.getSalt();
        s=MD5.encrypt(s);

        User userLogin = userMapper.getByNameAndPassword(user.getName(),s);
        if (userLogin==null){
            throw new GuliException(20001,"用户名或密码错误!!!");
        }else {

//            登陆成功,返回token
            String tokens = JwtUtils.createToken(userLogin);
            userLogin.setTokens(tokens);
            return R.ok().data("user",userLogin);

        }
    }
    @GetMapping("/logout/{id}")
    public R logout(@PathVariable String id,HttpSession session){
        User user = userService.getById(id);
        if (user.getToken()==null){
            return R.error().message("该用户未登录..无法退出");
        }
        else {
            user.setToken(null);
            session.setAttribute("user",null);
            userMapper.keepTokenByIds(id);
            return R.ok().message("登出成功!");
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
    @GetMapping(("/saveUserByToken"))
    public R saveUser(String token){
       User user= userService.getUserByToken(token);
       return R.ok().data("user",user);
    }

    @GetMapping("selectAllReview/{id}")
    public R selectAllReview(@PathVariable String id){
       List<Review> reviews=reviewService.selectAllReview(id);
       return R.ok().data("reviews",reviews);
    }





}


