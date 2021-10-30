package com.booklendingsystem.admin.service;

import com.booklendingsystem.admin.entity.Location;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiKun
 * @since 2021-10-21
 */
public interface LocationService extends IService<Location> {

    /**
     * 根据分类Id获取相关位置信息
     * @param categoryId 分类Id
     * @return 位置集合
     */
    List<Location> getBookshelfByCategoryId(long categoryId);

    /**
     * 根据id获取位置
     * @param locationId 位置Id
     * @return 书籍位置
     */
    Location getLocationById(long locationId);
}
