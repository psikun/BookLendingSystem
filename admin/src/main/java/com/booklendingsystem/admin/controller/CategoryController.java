package com.booklendingsystem.admin.controller;


import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.entity.Category;
import com.booklendingsystem.admin.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author SiKun
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @ApiOperation("通过分类Id获取分类")
    @GetMapping("/{categoryId}")
    public Result<Category> geCategoryById(@PathVariable("categoryId") long categoryId) {
        return Result.success(categoryService.geCategoryById(categoryId));
    }

    @ApiOperation("按照等级获取分类")
    @GetMapping("/level/{level}")
    public Result<List<Category>> getLevelCategories(@PathVariable("level") int level) {
        return Result.success(categoryService.getLevelCategories(level));
    }

    @ApiOperation("获取子分类")
    @GetMapping("/parent/{parentId}")
    public Result<List<Category>> getParentCategory(@PathVariable("parentId") Long parentId) {
        return Result.success(categoryService.getSubCategories(parentId));
    }

}
