package com.booklendingsystem.admin.controller;


import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.service.IBookInfoService;
import com.booklendingsystem.admin.service.impl.BookInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author SiKun
 * @since 2021-10-19
 */
@RestController
@RequestMapping("/bookinfo")
public class BookInfoController {

    @Autowired
    private IBookInfoService bookInfoService;

    @GetMapping
    public Result<List<BookInfo>> getBookInfo() {
        return Result.success(bookInfoService.list());
    }
}
