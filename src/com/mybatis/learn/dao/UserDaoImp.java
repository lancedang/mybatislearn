// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.dao;

import com.mybatis.learn.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 10/1/19 2:54 PM
 * 原始实现Dao的方式，需要自行编写DaoImpl类，并耦合具体SqlSession相关语句
 * 本质和MybatisFirst相同，只是由Junit转为Dao
 **/
public class UserDaoImp implements IUserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImp(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findOneById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUsersByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserByName");
        sqlSession.close();
        return users;
    }
}