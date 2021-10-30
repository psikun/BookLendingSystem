package com.booklendingsystem.admin.controller;


import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.entity.Category;
import com.booklendingsystem.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/{categoryId}")
    public Result<Category> geCategoryById(@PathVariable("categoryId") long categoryId) {
        return Result.success(categoryService.geCategoryById(categoryId));
    }

    /**
     * 按照等级获取分类
     *
     * @param level 等级分类
     * @return 分类集合
     */
    @GetMapping("/level/{level}")
    public Result<List<Category>> getLevelCategories(@PathVariable("level") int level) {
        return Result.success(categoryService.getLevelCategories(level));
    }

    /**
     * 获取子分类
     *
     * @param parentId 父分类Id
     * @return 子分类集合
     */
    @GetMapping("/parent/{parentId}")
    public Result<List<Category>> getParentCategory(@PathVariable("parentId") Long parentId) {
        return Result.success(categoryService.getSubCategories(parentId));
    }

}
