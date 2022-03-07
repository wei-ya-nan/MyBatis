package com.wyn.mybatis03.test;

import com.wyn.mybatis03.bean.Employee;
import com.wyn.mybatis03.dao.DynamicSQL;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/2/21
 */
public class testMapper {
    @Test
    public void test() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DynamicSQL mapper = sqlSession.getMapper(DynamicSQL.class);
            Employee employee = new Employee(null, "jedfry4",null, "1");



            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }
}
