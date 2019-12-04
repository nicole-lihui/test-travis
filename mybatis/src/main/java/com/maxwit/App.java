package com.maxwit;

import com.maxwit.dao.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        // User u1 = session.selectOne("com.maxwit.mybatis.BlogMapper.selectBlog", 0);
        // System.out.println("Id : " + u1.getId());
        // System.out.println("Name : " + u1.getName());

        UserMapper mapper = session.getMapper(UserMapper.class);
        User u2 = mapper.selectByPrimaryKey(1);

        System.out.println("Id : " + u2.getId());
        System.out.println("Name : " + u2.getName());

    }
}
