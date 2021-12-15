package com.booklendingsystem.admin.dto;

import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author SiKun
 * @date 2021/11/10/ 10:43
 */

@Data
public class UserBookRelationParamDTO {
    private Long id;

    @ApiModelProperty("借阅者id")
    private Long userId;

    @ApiModelProperty("用户类")
    private User user;

    @ApiModelProperty("图书id")
    private Long bookId;

    @ApiModelProperty("图书类")
    private BookInfo bookInfo;

    @ApiModelProperty("借书时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date borrowTime;

    @ApiModelProperty("应还时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date returnTime;

    @ApiModelProperty("超期时间(天)")
    private Integer beyondTime;

    @ApiModelProperty("超期费用")
    private Double beyondCost;

    @ApiModelProperty("可延期次数")
    private Integer canDelayTimes;
}
