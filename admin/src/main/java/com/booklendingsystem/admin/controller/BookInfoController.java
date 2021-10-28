package com.booklendingsystem.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.service.BookInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author SiKun
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/bookinfo")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;

    /**
     *获取书籍信息
     */
    @GetMapping
    public Result<List<BookInfo>> getBookInfo(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(bookInfoService.getBooks(new Page<>(pageNum, pageSize)));
    }

    /**
     *删除书籍(逻辑删除)
     */
    @DeleteMapping("/{id}")
    public Result<?> deleteBook(@PathVariable("id") Long id) {
        return Result.success(bookInfoService.deleteBook(id));
    }
}
