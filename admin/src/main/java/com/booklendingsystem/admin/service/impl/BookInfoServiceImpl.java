package com.booklendingsystem.admin.service.impl;

import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.mapper.BookInfoMapper;
import com.booklendingsystem.admin.service.IBookInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SiKun
 * @since 2021-10-19
 */
@Service
public class BookInfoServiceImpl extends ServiceImpl<BookInfoMapper, BookInfo> implements IBookInfoService {

}
