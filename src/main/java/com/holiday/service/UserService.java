package com.holiday.service;

import com.holiday.entity.User;

/**
* 用户表相关Service
* @author Elvis
* @version 1.0.0
* @date 2020-01-19
 * Copyright © Elvis.com
*/
public interface UserService extends BaseCustomService<User> {

    User findByUserInfo(String userName, String pwd);

    User findByUserName(String userName);

}