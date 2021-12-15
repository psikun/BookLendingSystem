package com.booklendingsystem.admin.service.impl;

import com.booklendingsystem.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SiKun
 * @date 2021/12/15/ 13:45
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 查数据库用户名和密码实现登陆认证
        com.booklendingsystem.admin.entity.User loginUser = userService.getUserByName(s);
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        return new User(loginUser.getUsername(), new BCryptPasswordEncoder().encode(loginUser.getPassword()), auths);
    }
}
