package com.booklendingsystem.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.dto.BookInfoParamDTO;
import com.booklendingsystem.admin.entity.BookInfo;
import com.booklendingsystem.admin.service.BookInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SiKun
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/bookinfo")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;

    @ApiOperation("通过Id获取书籍信息")
    @GetMapping("/{id}")
    public Result<BookInfo> getBookById(@PathVariable("id") Long id) {
        return Result.success(bookInfoService.getBookById(id));
    }


    @ApiOperation("分页获取书籍信息")
    @GetMapping
    public Result<List<BookInfo>> getBookInfo(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(bookInfoService.getBooks(new Page<>(pageNum, pageSize)));
    }


    @ApiOperation("删除书籍")
    @DeleteMapping("/{id}")
    public Result<?> deleteBook(@PathVariable("id") Long id) {
        int count = bookInfoService.deleteBook(id);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }


    @ApiOperation("添加书籍")
    @PostMapping("/add")
    public Result<?> addBook(@RequestBody BookInfoParamDTO bookInfoParamDTO) {

        int count = bookInfoService.addBook(bookInfoParamDTO);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }

    @ApiOperation("更新书籍")
    @PostMapping("/update")
    public Result<?> updateBook(@RequestBody BookInfoParamDTO bookInfoParamDTO) {

        int count = bookInfoService.updateBook(bookInfoParamDTO);
        if (count > 0) {
            return Result.success(count);
        }
        return Result.failed();
    }
}
