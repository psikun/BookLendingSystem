package com.booklendingsystem.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.booklendingsystem.admin.entity.BookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author SiKun
 * @since 2021-10-20
 */
@Mapper
public interface BookInfoMapper extends BaseMapper<BookInfo> {
    List<BookInfo> getBooks();
}
