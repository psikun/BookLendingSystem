package com.booklendingsystem.admin.controller;


import com.booklendingsystem.admin.common.Result;
import com.booklendingsystem.admin.entity.Location;
import com.booklendingsystem.admin.service.LocationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author SiKun
 * @since 2021-10-21
 */
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @ApiOperation("根据id获取位置")
    @GetMapping("/{locationId}")
    public Result<Location> getLocationById(@PathVariable("locationId") long locationId) {
        return Result.success(locationService.getLocationById(locationId));
    }


    @ApiOperation("根据分类Id获取相关位置信息")
    @GetMapping("/list/{categoryId}")
    public Result<List<Location>> getBookshelfByCategoryId(@PathVariable("categoryId") long categoryId) {
        return Result.success(locationService.getBookshelfByCategoryId(categoryId));
    }

}
