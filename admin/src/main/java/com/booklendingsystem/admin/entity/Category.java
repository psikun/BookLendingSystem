package com.booklendingsystem.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @since 2021-10-20
 */
@Getter
@Setter
@TableName("books_category")
@ApiModel(value = "Category对象", description = "")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类ID")
    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;

    @ApiModelProperty("上级分类编号，0为一级分类")
    private Long parentId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("分类级别")
    private Integer level;

    @ApiModelProperty("关键字")
    private String keywords;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("软删除")
    private Integer isDelete;


}
