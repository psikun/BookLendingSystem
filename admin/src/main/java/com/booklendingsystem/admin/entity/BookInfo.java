package com.booklendingsystem.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author SiKun
 * @since 2021-10-19
 */
@TableName("books_book_info")
@ApiModel(value = "BookInfo对象", description = "书籍基本信息")
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

    @ApiModelProperty("书籍分类id")
    private Long categoryId;

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

    @ApiModelProperty("图书位置")
    private Long location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getBorrowingStatus() {
        return borrowingStatus;
    }

    public void setBorrowingStatus(Integer borrowingStatus) {
        this.borrowingStatus = borrowingStatus;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
            "id=" + id +
            ", name=" + name +
            ", author=" + author +
            ", press=" + press +
            ", isbn=" + isbn +
            ", categoryId=" + categoryId +
            ", borrowingStatus=" + borrowingStatus +
            ", description=" + description +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isDelete=" + isDelete +
            ", location=" + location +
        "}";
    }
}
