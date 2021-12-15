package com.booklendingsystem.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.booklendingsystem.admin.entity.User;
import com.booklendingsystem.admin.mapper.UserMapper;
import com.booklendingsystem.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author SiKun
 * @since 2021-11-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", name);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        } else {
            return user;
        }
    }
}
