package com.wyn.mapper;

import com.wyn.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/5
 */
public interface EmpMapper {
    //查询所有的emp的数据
    List<Emp> queryAllEmp();

    Emp getEmpAndDept(@Param("eid") Integer eid);

    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    List<Emp> getDeptAndEmpByStepTwo(Integer did);
}
