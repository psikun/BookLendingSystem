package com.booklendingsystem.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("books_book_info")
@ApiModel(value = "BookInfo对象", description = "")
public class BookInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("书籍ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("书籍名称")
    private String name;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("出版社")
    private String press;

    @ApiModelProperty("ISBN号码")
    private String isbn;

    @ApiModelProperty("书籍分类")
    private Category category;

    @ApiModelProperty("图书位置")
    private String locationNumber;

    @ApiModelProperty("借阅状态")
    private Integer borrowingStatus;

    @ApiModelProperty("书籍描述")
    private String description;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("软删除")
    private Integer isDelete;


}
