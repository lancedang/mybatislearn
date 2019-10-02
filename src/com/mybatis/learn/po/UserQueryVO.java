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
public class UserQueryVO {
    private UserCustomer userCustomer;

    public UserQueryVO(UserCustomer userCustomer) {
        this.userCustomer = userCustomer;
    }
}