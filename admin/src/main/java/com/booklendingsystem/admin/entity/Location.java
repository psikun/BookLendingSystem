package com.booklendingsystem.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-10-21
 */
@Getter
@Setter
@TableName("books_location")
@ApiModel(value = "Location对象", description = "")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "location_id", type = IdType.AUTO)
    private Integer locationId;

    @ApiModelProperty("书架分类")
    private Category category;

    @ApiModelProperty("书架位置")
    private String bookshelf;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;


}
