package com.yxr.tmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("orderCode")
    private String orderCode;

    private String address;

    private String post;

    private String receiver;

    private String mobile;

    @TableField("userMessage")
    private String userMessage;

    @TableField("createDate")
    private Date createDate;

    @TableField("payDate")
    private Date payDate;

    @TableField("deliveryDate")
    private Date deliveryDate;

    @TableField("confirmDate")
    private Date confirmDate;

    private Integer uid;

    private String status;


}
