package com.yxr.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxr.tmall.entity.Review;
import com.yxr.tmall.mapper.ReviewMapper;
import com.yxr.tmall.service.ReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private ReviewService reviewService;
    @Override
    public List<Review> selectAllReview(String id) {

       return reviewMapper.selectList(new QueryWrapper<Review>().eq("uid",id));
    }

    @Override
    public List<Review> selectByparentId(String id) {
       List<Review> reviews = reviewMapper.findParentId(id);
       return reviews;
    }
}
