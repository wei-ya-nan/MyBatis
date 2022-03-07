package com.wyn.mybatis03.dao;

import com.wyn.mybatis03.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/18
 */
public interface EmployeeMapper {

    //<editor-fold desc="Description">
    //    public Map<String, Employee> getEmpByIdReturnMap(Integer id);
//
//    @MapKey("id")
//    public Map<Integer, Employee> getEmpByLastNameByLikeReturnMap(String lastName);
//
//    public List<Employee> getEmpByIdAndLastNameLike(String lastName);
//
//    public Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);
//
//    public Employee getEmpById(@Param("id") Integer id);
//
//    public void addEmp(Employee employee);
//
//    public void updateEmp(Employee employee);
//
//    public void deleteEmp(Integer id);
//
//    public Employee getEmpByMap(Map<String, Object> map);
    //</editor-fold>

    public Employee getEmployeeById(Integer id);
}
