package com.booklendingsystem.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.dto.BookInfoParamDTO;
import com.booklendingsystem.admin.entity.BookInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiKun
 * @since 2021-10-20
 */
public interface BookInfoService extends IService<BookInfo> {
    /**
     * 获取书籍
     * @param page 页码数
     * @return 书籍列表
     */
    List<BookInfo> getBooks(Page<BookInfo> page);

    /**
     * 逻辑删除书籍
     * @param id 书籍Id
     * @return 是否成功
     */
    int deleteBook(Long id);

    /**
     * 添加书籍
     * @param bookInfoParam 要添加的书籍
     * @return 是否添加成功
     */
    int addBook(BookInfoParamDTO bookInfoParam);

    /**
     * 根据Id获取书籍
     * @param id 书籍Id
     * @return 书籍
     */
    BookInfo getBookById(Long id);

    /**
     * 更新书籍
     * @param bookInfoParam 要修改的书籍
     * @return 是否修改成功
     */
    int updateBook(BookInfoParamDTO bookInfoParam);
}
