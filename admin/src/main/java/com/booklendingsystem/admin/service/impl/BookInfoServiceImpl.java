package com.booklendingsystem.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.booklendingsystem.admin.dto.BookInfoParamDTO;
import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.entity.Category;
import com.booklendingsystem.admin.entity.Location;
import com.booklendingsystem.admin.mapper.BookInfoMapper;
import com.booklendingsystem.admin.service.BookInfoService;
import com.booklendingsystem.admin.service.CategoryService;
import com.booklendingsystem.admin.service.LocationService;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    CategoryService categoryService;
    @Autowired
    LocationService locationService;

    @Override
    public List<BookInfo> getBooks(Page<BookInfo> page) {

        bookInfoMapper.getBooks(page);
        return page.getRecords();
    }

    @Override
    public int deleteBook(@PathVariable("id") Long id){
        return bookInfoMapper.deleteById(id);
    }

    @Override
    public int addBook(BookInfoParamDTO bookInfoParam) {
        BookInfo bookInfo = new BookInfo();
        // 复制属性
        BeanUtils.copyProperties(bookInfoParam, bookInfo);
        // 调用categoryService获取集合对象
        Category category = categoryService.geCategoryById(bookInfoParam.getCategoryId()[1]);
        bookInfo.setCategory(category);
        // 调用categoryService获取书架信息
        Location location = locationService.getLocationById(bookInfoParam.getLocationId());
        bookInfo.setLocation(location);
        return bookInfoMapper.insertBook(bookInfo);
    }
}
