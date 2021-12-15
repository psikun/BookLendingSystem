package com.booklendingsystem.admin.service;

import com.booklendingsystem.admin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiKun
 * @since 2021-11-09
 */
public interface UserService extends IService<User> {

    /**
     * 通过用户名获取用户
     * @param name 用户名
     * @return 用户
     */
    User getUserByName(String name);
}
