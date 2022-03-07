package com.wyn.mybatis03.dao;

import com.wyn.mybatis03.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/3
 */
public interface DynamicSQL {
    public List<Employee> getEmpByConditionIf(Employee employee);

    public void updateEmp(Employee employee);

    public void addEmo(@Param("emps") List<Employee> emp);

}
