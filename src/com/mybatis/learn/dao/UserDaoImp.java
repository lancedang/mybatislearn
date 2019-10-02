// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.dao;

import com.mybatis.learn.po.User;
import com.mybatis.learn.po.UserQueryVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 10/1/19 2:54 PM
 * 该类用于解释：原始实现Dao的方式，需要自行编写DaoImpl类，并耦合具体SqlSession相关语句
 * 本质和MybatisFirst相同，只是由Junit转为Dao
 * 对比Mapper方式实现Dao层：
 **/
public class UserDaoImp implements IUserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImp(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserByName");
        sqlSession.close();
        return users;
    }

    @Override
    public List<User> findUserBySexAndName(UserQueryVO userQueryVO) {
        //原始dao方式
        return null;
    }

    @Override
    public List<User> findUserBySexAndNameOpt(UserQueryVO userQueryVO) {
        //原始dao方式
        return null;
    }

    @Override
    public int findUserCountBySexAndName(UserQueryVO userQueryVO) {
        return 0;
    }

    @Override
    public List<User> findUserForeachIds(UserQueryVO userQueryVO) {
        return null;
    }
}