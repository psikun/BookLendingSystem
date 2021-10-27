package com.booklendingsystem.admin.controller;


import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.entity.Category;
import com.booklendingsystem.admin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
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

    /**
     * 按照等级获取分类
     * @param level 等级分类
     * @return 分类集合
     */
    @GetMapping("/level/{level}")
    public Result<List<Category>>getLevelCategories(@PathVariable("level") int level){
        return Result.success(categoryService.getLevelCategories(level));
    }

    @GetMapping("/parent/{parentId}")
    public Result<List<Category>> getParentCategory(@PathVariable("parentId") Long parentId){
        return Result.success(categoryService.getSubCategories(parentId));
    }

}
