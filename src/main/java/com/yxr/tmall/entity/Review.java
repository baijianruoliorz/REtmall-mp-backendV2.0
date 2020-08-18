package com.yxr.tmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.ManyToOne;
import com.github.dreamyoung.mprelation.OneToMany;
import com.github.dreamyoung.mprelation.OneToOne;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liqiqiorz
 * @since 2020-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Review对象", description="")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String content;

    private Integer uid;

    private Integer pid;

    private Integer vid;

    @TableField("createDate")
    private Date createDate;

    @TableField(exist = false)
    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private User user;
//    评论回复
    @TableField(exist = false)
    private List<Review> reviewList;
//父评论
    @TableField(exist = false)
    private Review parentComment;
//评论的用户名
@TableField(exist = false)
    private String nickname;



}

