// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.example;

import com.mybatis.learn.po.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 9/30/19 11:25 AM
 * SqlMapConfig.xml + User.xml + User实现最原始DB操作
 **/
@Slf4j
public class Mybatis1 {

    /**
     * sqlSession是现场不安全的，建议作为方法体局部变量来初始化，此处我们采用@before注解初始化
     */
    public static SqlSession sqlSession;

    /**
     * init方法在每个@Test方法前只执行一次，用于初始化各个@test方法共享的一些数据
     *
     * @throws IOException
     */
    //@BeforeClass
    public static void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        log.info("sqlSession hashcode = " + sqlSession.hashCode());
    }

    @Before
    public void init2() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        log.info("sqlSession hashcode = " + sqlSession.hashCode());
    }

    /**
     * 关闭多个Test共享的sqlSession,同时将Connection归还到connection pool
     */
    //@AfterClass
    public static void clear() {
        sqlSession.close();
    }

    /**
     * 每个Test方法执行完后，清理各自的SQLSession，而非清除多个Test共享的SQLSession
     */
    @After
    public void clear2() {
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