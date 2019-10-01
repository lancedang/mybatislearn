package com.mybatis.learn.dao;

import com.mybatis.learn.po.User;

import java.util.List;

public interface IUserDao {
    User findUserById(int id);

    List<User> findUserByName(String name);
}
