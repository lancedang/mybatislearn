// Copyright (C) 2019 Meituan
// All rights reserved
package com.mybatis.learn.po;

import lombok.Data;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 10/2/19 12:17 PM
 **/
@Data
public class UserCustomer {
    private String sex;
    private String username;

    public UserCustomer(String sex, String username) {
        this.sex = sex;
        this.username = username;
    }
}