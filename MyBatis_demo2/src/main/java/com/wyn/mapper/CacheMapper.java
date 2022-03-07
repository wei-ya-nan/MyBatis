package com.wyn.mapper;

import com.wyn.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/6
 */
public interface CacheMapper {
    Emp getEmpById(@Param("eid") Integer id);

    void addEmp(Emp emp);
}
