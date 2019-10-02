package com.mybatis.learn.dao;

import com.mybatis.learn.po.User;
import com.mybatis.learn.po.UserQueryVO;

import java.util.List;

public interface IUserDao {
    User findUserById(int id);

    List<User> findUserByName(String name);

    List<User> findUserBySexAndName(UserQueryVO userQueryVO);

    //demo4: 用于SQL语句优化，xml 用if判断sex, name为空情况
    List<User> findUserBySexAndNameOpt(UserQueryVO userQueryVO);

    //demo4: sql 抽取
    int findUserCountBySexAndName(UserQueryVO userQueryVO);

    //demo5: in、or SQL语句的使用
    List<User> findUserForeachIds(UserQueryVO userQueryVO);
}
