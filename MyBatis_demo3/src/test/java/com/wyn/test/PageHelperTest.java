package com.wyn.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyn.bean.Emp;
import com.wyn.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wei-ya-nan
 * @version 1.0
 * @date 2022/3/7
 */
public class PageHelperTest {
    /**
     * limit index , pageSize
     * index 当前页面的起始索引 从0 开始
     * pageSize 每页显示的条数
     * pageNum 当前页的页码
     * index = （pageNum -1） * pageSize
     */
    @Test
    public void testPage() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            //开启分页功能
            PageHelper.startPage(1, 3);
            List<Emp> emps = mapper.selectByExample(null);
            emps.forEach(emp -> System.out.println(emp));
            //分页之后查询相关的信息 ，就包括分页的导航栏信息
            PageInfo<Emp> pageInfo = new PageInfo<>(emps,5);
            System.out.println(pageInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
