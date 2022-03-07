package com.wyn.test;

import com.wyn.bean.Emp;
import com.wyn.mapper.EmpMapper;
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
 * @date 2022/3/7
 */
public class TestMBGTest {
    @Test
    public void testMBG() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //奢华尊享版的查询语句 牛掰
//      List<Emp> emps = mapper.selectByExample(null);
//      emps.forEach(emp -> System.out.println(emp));
//      EmpExample empExample = new EmpExample();
//      empExample.createCriteria().andEmpNameEqualTo("jack").andAgeGreaterThanOrEqualTo(20);
//      empExample.or().andDidIsNotNull();
//      List<Emp> emps = mapper.selectByExample(empExample);
//      emps.forEach(emp -> System.out.println(emp));
          //选择性的修改 为空的话就不会修改 底层的原理就是动态的sql
          int i = mapper.updateByPrimaryKeySelective(new Emp(1, "jack", 21, null, null, 1));
          System.out.println(i);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
