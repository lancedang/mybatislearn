// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.first;

import com.mybatis.learn.dao.IUserDao;
import com.mybatis.learn.dao.UserDaoImp;
import com.mybatis.learn.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 10/1/19 3:06 PM
 **/
public class Mybatis2OldDao {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findById() {
        IUserDao userDao = new UserDaoImp(sqlSessionFactory);
        User user = userDao.findOneById(1);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getUsername(), "zhangsan");
    }

    @Test
    public void findByName() {
        IUserDao userDao = new UserDaoImp(sqlSessionFactory);
        List<User> users = userDao.findUsersByName("san");
        Assert.assertNotNull(users);
        Assert.assertEquals(users.size(), 2);
    }
}