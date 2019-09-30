// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.po;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 9/30/19 11:25 AM
 **/
@Slf4j
public class MybatisFirst {

    public static SqlSession sqlSession;

    /**
     * init方法在每个@Test方法前只执行一次，用于初始化各个@test方法共享的一些数据
     *
     * @throws IOException
     */
    @BeforeClass
    public static void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 关闭sqlSession,同时将Connection归还到connection pool
     */
    @AfterClass
    public static void clear() {
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        User o = sqlSession.selectOne("test.findUserById", 1);
        Assert.assertEquals("zhangsan", o.getUsername());
    }

    @Test
    public void testSelectsByName() {
        List<User> users = sqlSession.selectList("test.findUserByName", "san");
        Assert.assertEquals(2, users.size());
    }


}