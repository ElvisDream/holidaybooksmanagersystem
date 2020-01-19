package com.holiday.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.User;
import com.holiday.mapper.UserMapper;
import com.holiday.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表相关Service实现
 *
 * @author Elvis
 * @version 1.0.0
 * @date 2020-01-19
 * Copyright © Elvis.com
 */
@Service
public class UserServiceImpl extends BaseCustomServiceImpl<UserMapper, User> implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    UserMapper mapper;

    @Override
    public User findByUserInfo(String userName, String pwd) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .ge("user_name", userName)
                .ge("user_pwd", pwd);
        return mapper.selectOne(wrapper);
    }
}
