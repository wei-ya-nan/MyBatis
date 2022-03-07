package com.wyn.mapper;

import com.wyn.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/6
 */
public interface DynamicSQLMapper {
    //根据多条件查询
    List<Emp> getEmpByCondition(Emp emp);

    List<Emp> geEmpByChoose(Emp emp);

    int deleteMoreByArray(@Param("eids") Integer[] eids);

    int addEmpByList(@Param("emps") List<Emp> emps);
}
