package com.yxr.tmall.mapper;

import com.yxr.tmall.entity.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@Mapper
@Repository
public interface ReviewMapper extends BaseMapper<Review> {
//添加一个评论
    int saveReview(Review review);

//    查询父级评论
    List<Review> findByVidIdNull(@Param("ParentId") Integer ParentId);

//    查询一级回复
    List<Review> findParentIdNotNull(@Param("id") Integer id);

//    查询二级以及其所有子集回复
    List<Review> findByReplayId(@Param("childId") Integer childId);
}
