package com.wyn.mapper;

import com.wyn.pojo.User;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/4
 */
public interface UserMapper {
    //添加用户信息
    public int addUser(User user);

    List<User> queryAll();
}
