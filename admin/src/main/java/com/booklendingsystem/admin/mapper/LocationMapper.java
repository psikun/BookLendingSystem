package com.booklendingsystem.admin.mapper;

import com.booklendingsystem.admin.entity.Location;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.ManagedBean;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SiKun
 * @since 2021-10-21
 */
@Mapper
public interface LocationMapper extends BaseMapper<Location> {

    /**
     * 根据分类Id获取相关位置信息
     * @param categoryId 分类Id
     * @return 位置集合
     */
    List<Location> getBookshelfByCategoryId(@PathVariable("categoryId")long categoryId);
}
