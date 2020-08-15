package com.yxr.tmall.service;

import com.yxr.tmall.entity.Review;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
public interface ReviewService extends IService<Review> {

    List<Review> selectAllReview(String id);

//   查询评论列表
    List<Review> listReview();
//    保存评论
    int saveReview(Review review);
}
