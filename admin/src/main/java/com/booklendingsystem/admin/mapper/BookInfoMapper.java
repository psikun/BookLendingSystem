package com.booklendingsystem.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.booklendingsystem.admin.entity.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

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
    /**
     * 分页返回书籍
     * @param page 页码
     * @return 书籍页面
     */
    IPage<BookInfo> getBooks(Page<?> page);

    /**
     * 添加图书
     * @param bookInfo 图书实体
     * @return 是否成功
     */
    int insertBook(BookInfo bookInfo);

    /**
     * 根据Id获取书籍
     * @param id 书籍Id
     * @return 书籍
     */
    BookInfo getBookById(@PathVariable("id") Long id);

    int updateBook(BookInfo bookInfo);
}
