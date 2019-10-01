// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.po;

import lombok.Data;

import java.util.Date;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 9/30/19 11:06 AM
 **/
@Data
public class User {
    private Integer id;

    private String username;
    private Date birthday;
    private String sex;
    private String address;

}