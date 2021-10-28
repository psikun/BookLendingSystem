package com.booklendingsystem.admin.controller;


import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.entity.Location;
import com.booklendingsystem.admin.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SiKun
 * @since 2021-10-21
 */
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    /**
     * 根据分类Id获取相关位置信息
     * @param categoryId 分类Id
     * @return 位置集合
     */
    @GetMapping("/getshelf/{categoryId}")
    public Result<List<Location>> getBookshelfByCategoryId(@PathVariable("categoryId") long categoryId){
        return Result.success(locationService.getBookshelfByCategoryId(categoryId));
    }

}
