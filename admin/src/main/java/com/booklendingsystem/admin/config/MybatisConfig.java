package com.booklendingsystem.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置类
 *
 * @author SiKun
 * @date 2021/10/18/ 20:38
 */

@Configuration
@MapperScan("com.booklendingsystem.admin.mapper")
public class MybatisConfig {
}
