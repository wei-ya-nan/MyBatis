package com.wyn.test;


import com.wyn.mapper.CacheMapper;
import com.wyn.mapper.DeptMapper;
import com.wyn.mapper.DynamicSQLMapper;
import com.wyn.mapper.EmpMapper;
import com.wyn.pojo.Dept;
import com.wyn.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/5
 */

public class EmpMapperTest {

    @Test
    public void queryAllEmp() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = factoryBuilder.build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            Dept deptAnaEmpByStepOne = deptMapper.getDeptAnaEmpByStepOne(1);
            System.out.println(deptAnaEmpByStepOne.getDeptName());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDynamic(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
            SqlSession sqlSession = build.openSession( true);
            DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

            Emp emp = new Emp(null, "nm", 12, "男", "qwe@qq.com",null);
            Emp emp2 = new Emp(null, "nm", 56, "男", "qwe@qq.com",null);
            List<Emp> list = new ArrayList<>();
            list.add(emp);
            list.add(emp2);
            int i = mapper.addEmpByList(list);
            System.out.println(i);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCache(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
