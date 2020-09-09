package com.yxr.tmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.config.MD5;
import com.yxr.tmall.entity.Review;
import com.yxr.tmall.entity.User;
import com.yxr.tmall.exceptionhandler.GuliException;
import com.yxr.tmall.mapper.UserMapper;
import com.yxr.tmall.service.ReviewService;
import com.yxr.tmall.service.UserService;
import com.yxr.tmall.utils.JwtUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
    public R login(@RequestBody User user, HttpServletRequest request, HttpSession httpSession, HttpServletResponse response) throws UnsupportedEncodingException {
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
//            前端复选框要remember-me并且默认值为0,勾选值为1
            String remember=request.getParameter("remember-me");
//            设置cookie,cookie的name是user也可以写成remember,需要解码
            Cookie cookie=new Cookie("user", URLEncoder.encode(user.getName()+"-"+user.getPassword(),"UTF-8"));
            int maxAge="1".equals(remember)?24*60*60:0;
//            一天
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);
//            之后取cookie就是前端的操作
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
        user.setPassword("QAQ这个可查不到哦");
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
//以下接口进行一些小实验
//    and接口的使用方法
    @GetMapping("test/getUser/{id}")
    public R getUser(@PathVariable String id){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.and(i->i.eq("name","liqiqi").eq("id",id));
        List<User> list = userService.list(wrapper);
        return R.ok().data("list",list);
    }
//    不同于and 如果使用多个sql eq的话效果是会把所有满足条件的全部查询出来

//or接口的使用方法\
    @GetMapping("test/orgetUser/{id}")
    public R orgetUser(@PathVariable String id) throws Exception{

        //显然这个between也是左边是闭区间,右边是开区间
//        不要使用尾行注释!!!这个注释规范也很重要呢
      List<User> list= userService.orgetList();
        return R.ok().data("list",list);

    }

//    groupBy接口
    @GetMapping("test/groupBy/{id}")
    public R groupGetUser(@PathVariable String id){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("id",id)
                .groupBy("avator");
        List<User> list = userService.list(wrapper);
        return R.ok().data("list",list);
    }


}


