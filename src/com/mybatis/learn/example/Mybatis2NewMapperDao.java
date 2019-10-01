// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.example;

import com.mybatis.learn.dao.IUserDao;
import com.mybatis.learn.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 10/1/19 3:06 PM
 **/
public class Mybatis2NewMapperDao {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void findById() {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = userDao.findUserById(1);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getUsername(), "zhangsan");
    }

    @Test
    public void findByName() {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findUserByName("san");
        Assert.assertNotNull(users);
        Assert.assertEquals(users.size(), 2);
    }
}