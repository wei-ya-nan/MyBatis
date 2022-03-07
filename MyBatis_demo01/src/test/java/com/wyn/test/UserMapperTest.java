package com.wyn.test;

import com.wyn.mapper.ParameterMapper;
import com.wyn.mapper.UserMapper;
import com.wyn.pojo.User;
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
 * @date 2022/3/4
 */

public class UserMapperTest {
    @Test
    public void testParameterUser() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

            User user = new User(null, "tom", "123", 18, '男', "123@qq.com");
            mapper.addUser(user);
            System.out.println(user);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUser() {
        try {
            //加载核心的配置文件
            InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
            //SqlSessionFactoryBuilder的获取,提供sqlsession
            SqlSessionFactoryBuilder sqlSession = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = sqlSession.build(resource);
            SqlSession openSession = factory.openSession(true);
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            User user = new User(null, "jack", "123", 12, '男', "123@qq.com");
            List<User> users = mapper.queryAll();
//            System.out.println(Arrays.asList(users)
            users.forEach(list -> {
                System.out.println(list);
            });


            //最后切记提交事务
//            openSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
