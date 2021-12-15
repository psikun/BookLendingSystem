package com.booklendingsystem.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author SiKun
 * @since 2021-11-09
 */
@Getter
@Setter
@TableName("borrow_user")
@ApiModel(value = "User对象", description = "借阅系统使用者，人员信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("借阅者Id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("违规次数")
    private Integer violationTimes;

    @ApiModelProperty("在借数量")
    private Integer borrowQuantity;

    @ApiModelProperty("最大借书数量")
    private Integer borrowMax;

    @ApiModelProperty("累计借书数量")
    private Integer borrowCount;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    @ApiModelProperty("软删除")
    private Integer isDelete;

    @ApiModelProperty("是否在黑名单")
    private Integer isBlacklist;

    @ApiModelProperty("用户状态(0->禁用，1->启用)")
    private Integer status;


}
