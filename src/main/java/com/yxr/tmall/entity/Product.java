package com.yxr.tmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.github.dreamyoung.mprelation.AutoLazy;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.ManyToOne;
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
@AutoLazy
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Product对象", description="")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    private String name;
//要加相关依赖
    @ManyToOne
    @JoinColumn(name="id",referencedColumnName="id")
    @TableField(exist = false)  //字段可以不包含这个
    private Category category;


    @TableField("subTitle")
    private String subTitle;

    @TableField("originalPrice")
    private Float originalPrice;

    @TableField("promotePrice")
    private Float promotePrice;

    private Integer stock;

    private Integer id;

    @TableField("createDate")
    private Date createDate;


}
