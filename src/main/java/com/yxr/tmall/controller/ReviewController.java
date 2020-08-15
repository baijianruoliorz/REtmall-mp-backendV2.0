package com.yxr.tmall.controller;


import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Review;
import com.yxr.tmall.entity.User;
import com.yxr.tmall.exceptionhandler.GuliException;
import com.yxr.tmall.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/tmall/review")
public class ReviewController {
  @Autowired
  private ReviewService reviewService;

    @GetMapping("getView/{id}")
    public R getView(@PathVariable String id, HttpSession session){
        User user = (User)session.getAttribute("user");
        System.out.println("+++");
        System.out.println(user);

        Review review = reviewService.getById(id);
        if (user.getId().equals(review.getUid())==false){
            return R.error().message("不能查询他人的评论哦!");
        }
       // review.setUid(user.getId()); 增加评论的时候加入
        review.setUser(user);
        return R.ok().data("review",review);
    }

    @PostMapping("addReview")
    public R addReview(@RequestBody Review review, HttpServletRequest httpServletRequest)
    {
        review.setCreateDate(new Date());
        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");
        if (user==null){
            throw new GuliException(20001,"您当前未登录,请登录后发表评论!!!");
        }
        review.setUid(user.getId());
        reviewService.save(review);
        return  R.ok();
    }
    @DeleteMapping("/removeView/{id}")
    public R removeReview(@PathVariable String id){
        reviewService.removeById(id);
        return R.ok();
    }

//    回复一条评论
    @PostMapping("/reply/review")
    public R reply(@RequestParam Review review){
//     查询出父评论

        return R.ok();

    }


}

