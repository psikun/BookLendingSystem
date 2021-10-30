package com.booklendingsystem.admin.service;

import com.booklendingsystem.admin.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiKun
 * @since 2021-10-20
 */
public interface CategoryService extends IService<Category> {
    /**
     * 根据分类等级查找分类
     * @param level 分类等级
     * @return 不同等级分类的集合
     */
    List<Category> getLevelCategories(int level);

    /**
     * 根据父类集合Id获取子类
     * @param parentId 父类集合
     * @return 子分类集合
     */
    List<Category> getSubCategories( Long parentId);

    /**
     * 根据分类Id获取分类
     * @param categoryId 分类Id
     * @return 书籍分类
     */
    Category geCategoryById(long categoryId);
}
