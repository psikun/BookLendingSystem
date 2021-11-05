package com.booklendingsystem.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.dto.BookInfoParamDTO;
import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.service.BookInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author SiKun
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/bookinfo")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;

    @GetMapping("/{id}")
    public Result<BookInfo> getBookById(@PathVariable("id") Long id){
        return Result.success(bookInfoService.getBookById(id));
    }

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

    /**
     * 添加书籍
     * @param bookInfoParamDTO 书籍传递参数
     */
    @PostMapping("/add")
    public Result<?> addBook(@RequestBody BookInfoParamDTO bookInfoParamDTO){

        return Result.success(bookInfoService.addBook(bookInfoParamDTO));
    }
    /**
     * 修改书籍
     * @param bookInfoParamDTO 书籍传递参数
     */
    @PostMapping("/update")
    public Result<?> updateBook(@RequestBody BookInfoParamDTO bookInfoParamDTO){

        return Result.success(bookInfoService.updateBook(bookInfoParamDTO));
    }
}
