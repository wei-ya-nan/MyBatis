package com.wyn.mapper;

import com.wyn.pojo.Dept;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/5
 */
public interface DeptMapper {
    //分步查询的第二步
    Dept getDeptByStepOne(Integer did);

    Dept getDeptAndEmp(Integer did);

    //分布查询
    Dept getDeptAnaEmpByStepOne(Integer did);
}
