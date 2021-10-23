package com.booklendingsystem.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.booklendingsystem.admin.entity.BookInfo;
import com.baomidou.mybatisplus.extension.service.IService;

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
    List<BookInfo> getBooks(Page<BookInfo> page);
}
