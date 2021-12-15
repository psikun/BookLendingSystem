package com.booklendingsystem.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.booklendingsystem.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author SiKun
 * @since 2021-11-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
