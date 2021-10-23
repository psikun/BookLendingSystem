package com.booklendingsystem.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.mapper.BookInfoMapper;
import com.booklendingsystem.admin.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author SiKun
 * @since 2021-10-20
 */
@Service
public class BookInfoServiceImpl extends ServiceImpl<BookInfoMapper, BookInfo> implements BookInfoService {
    @Autowired
    BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> getBooks(Page<BookInfo> page) {

        bookInfoMapper.getBooks(page);
        return page.getRecords();
    }

    @Override
    public int deleteBook(@PathVariable("id") Long id){
        return bookInfoMapper.deleteById(id);
    }
}
