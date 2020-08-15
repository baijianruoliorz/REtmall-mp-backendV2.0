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
    @Override
    public List<Review> selectAllReview(String id) {
       return reviewMapper.selectList(new QueryWrapper<Review>().eq("uid",id));
    }
}
