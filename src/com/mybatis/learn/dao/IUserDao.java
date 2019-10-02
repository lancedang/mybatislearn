package com.mybatis.learn.dao;

import com.mybatis.learn.po.User;
import com.mybatis.learn.po.UserQueryVO;

import java.util.List;

public interface IUserDao {
    User findUserById(int id);

    List<User> findUserByName(String name);

    List<User> findUserBySexAndName(UserQueryVO userQueryVO);
}
