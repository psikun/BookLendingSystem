package com.booklendingsystem.admin.service.impl;

import com.booklendingsystem.admin.entity.Category;
import com.booklendingsystem.admin.mapper.CategoryMapper;
import com.booklendingsystem.admin.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
