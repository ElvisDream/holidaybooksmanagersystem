package com.holiday.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.User;
import com.holiday.mapper.UserMapper;
import com.holiday.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* 用户表相关Service实现
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Service
public class UserServiceImpl extends BaseCustomServiceImpl<UserMapper, User> implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

}
