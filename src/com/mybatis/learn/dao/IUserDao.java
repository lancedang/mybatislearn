package com.mybatis.learn.dao;

import com.mybatis.learn.po.User;

import java.util.List;

public interface IUserDao {
    User findOneById(int id);

    List<User> findUsersByName(String name);
}
