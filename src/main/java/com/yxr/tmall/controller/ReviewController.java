package com.yxr.tmall.controller;


import com.yxr.tmall.commonUtils.R;
import com.yxr.tmall.entity.Review;
import com.yxr.tmall.entity.User;
import com.yxr.tmall.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        review.setUser(user);
        return R.ok().data("review",review);
    }

    @PostMapping("addReview")
    public R addReview(@RequestBody Review review)
    {
        review.setCreateDate(new Date());
        reviewService.save(review);
        return  R.ok();
    }
    @DeleteMapping("/removeView/{id}")
    public R removeReview(@PathVariable String id){
        reviewService.removeById(id);
        return R.ok();
    }


}

