package com.wyn.test;

import com.wyn.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/18
 */

public class test {
    //根据xml文件创建了一个SqlSessionFactory对象，然后
    @Test
    public void testMy() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession实力，执行已经的映射的sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //获取接口的实体类对象
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        mapper.getEmpById(1);
        //1、sql唯一的标识 2、执行sql的语句
        try {
            Employee one = sqlSession.selectOne("com.wyn.bean.Employee.getEmpById", "1");
            System.out.println(one);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test03() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        try {
            Employee mapper = sqlSession.getMapper(Employee.class);


            //手动提交
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }
}
