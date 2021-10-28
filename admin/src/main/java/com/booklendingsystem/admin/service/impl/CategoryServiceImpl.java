package com.booklendingsystem.admin.service.impl;

import com.booklendingsystem.admin.entity.Category;
import com.booklendingsystem.admin.mapper.CategoryMapper;
import com.booklendingsystem.admin.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SiKun
 * @since 2021-10-20
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getLevelCategories(@PathVariable("level") int level) {
        return categoryMapper.getLevelCategories(level);
    }

    @Override
    public List<Category> getSubCategories(Long parentId) {
        return categoryMapper.getSubCategories(parentId);
    }
}
