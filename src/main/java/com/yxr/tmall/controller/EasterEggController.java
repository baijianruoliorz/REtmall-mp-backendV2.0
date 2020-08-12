package com.yxr.tmall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiqi_tql
 * @date 2020/8/12 -9:30
 */
@RestController
public class EasterEggController {

    @GetMapping("/")
    public String EasterEgg(){
        return "Thank you for visit my project," +
                " but this one isn't has a frontend now," +
                " you can visit my github and pull it to develop by yourself," +
                " yours sincerely:" +
                " liqiqiorz." +
                " twitter:@roz97101 ";
    }
}
