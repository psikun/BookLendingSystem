package com.booklendingsystem.admin.dto;

import com.booklendingsystem.admin.entity.Category;
import com.booklendingsystem.admin.entity.Location;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author SiKun
 * @date 2021/10/30/ 16:38
 */
@Data
public class BookInfoParamDTO {
    private Long id;
    private String name;
    private String author;
    private String press;
    private String isbn;
    private Double price;
    private Long locationId;
    private Integer[] categoryId;
    private String callNumber;
    private Integer borrowingStatus;
    private String description;
    private Integer isDelete;

}
