package com.booklendingsystem.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author SiKun
 * @date 2021/12/15/ 13:29
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        // 设置数据源
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义登录界面
        http.formLogin()
                // 登陆成功后的跳转路径
                .defaultSuccessUrl("/bookinfo/test").permitAll()
                // 定义接口保护
                .and().authorizeRequests()
                // 设置不需要认证的接口
                .antMatchers("/bookinfo/test").hasAuthority("admin")
                // 所有请求都可以访问
                .anyRequest().authenticated()
                // 设置记住我
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                // 设置有效时长，秒
                .tokenValiditySeconds(60)
                .userDetailsService(userDetailsService)
                .and().logout()
                // 注销接口
                .logoutSuccessUrl("/logout")
                // 退出后跳转的位置
                .logoutSuccessUrl("/bookinfo").permitAll()
                // 关闭csrf
                .and().csrf().disable();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
