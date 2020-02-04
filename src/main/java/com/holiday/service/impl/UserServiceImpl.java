package com.holiday.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.User;
import com.holiday.mapper.UserMapper;
import com.holiday.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    private UserMapper mapper;

    @Override
    public User findByUserInfo(String userName, String pwd) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .eq("user_name", userName)
                .eq("user_pwd", pwd);
        return mapper.selectOne(wrapper);
    }

    @Override
    public User findByUserName(String userName) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        return mapper.selectOne(wrapper);
    }

    @Override
    public List<User> queryUserByCondition(String userName, String email, long currentPage, long pageSize) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("update_time");
        if (userName != null && !"".equals(userName)) {
            wrapper.like("user_name", userName);
        }
        if (email != null && !"".equals(email)) {
            wrapper.eq("email", email);
        }
        Page<User> page = new Page<>(currentPage, pageSize);
        IPage<User> iPage = mapper.selectPage(page, wrapper);
        return iPage.getRecords();
    }

}
