package com.yxr.tmall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liqiqi_tql
 * @date 2020/8/18 -13:14
 */
@Slf4j
@RestController
public class SecureController {
    /**
     * 查询 用户信息，登录后才能访问
     */
    @GetMapping("/secure/getUserInfo")
    public String five(HttpServletRequest request){
        Integer id = (Integer) request.getAttribute("id");
        String name = request.getAttribute("name").toString();
        return "this is a jwt demo!"+"当前用户信息id="+id+"  "+"name"+name ;
    }
}
