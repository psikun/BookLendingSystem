package com.booklendingsystem.admin.mapper;

import com.booklendingsystem.admin.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SiKun
 * @since 2021-10-20
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> getLevelCategories(@PathVariable("level") int level);

    List<Category> getSubCategories(@PathVariable("parentId") Long parentId);
}
