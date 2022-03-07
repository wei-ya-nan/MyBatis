package com.wyn.mapper;

import com.wyn.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/4
 */
public interface ParameterMapper {
    List<User> getAllUser();

    List<User> getUserByUserName(String userName);

    User getUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    Map<String, Object> getUserByIdToMap(Integer id);

    @MapKey("id")
    Map<Integer, User> getUserAllToMap();

    List<User> getUserBeLikeName(String userName);

    int deleteMore(@Param("ids") String ids);
    void addUser(User user);
}
