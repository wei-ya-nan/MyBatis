package wyn.dao;

import org.apache.ibatis.annotations.Param;
import wyn.bean.Employee;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/18
 */
public interface EmployeeMapper2 {

    public Employee getEmpById(@Param("id") Integer id);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmp(Integer id);

}
