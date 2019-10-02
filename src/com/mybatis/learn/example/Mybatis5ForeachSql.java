// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.example;

import com.mybatis.learn.dao.IUserDao;
import com.mybatis.learn.po.User;
import com.mybatis.learn.po.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 10/2/19 12:29 PM
 **/
public class Mybatis5ForeachSql {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void findUserForeachIds() {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        UserQueryVO queryVO = new UserQueryVO();
        List<Integer> ids = new ArrayList<>();

        ids.add(1);
        //ids.add(2);
        //ids.add(4);

        queryVO.setIds(ids);

        //userQueryVo 分别设为null，name设为"" 查看sql语句中是否有相应where条件
        List<User> userBySexAndName = userDao.findUserForeachIds(queryVO);

        Assert.assertNotNull(userBySexAndName);
        Assert.assertEquals(2, userBySexAndName.size());

    }

}