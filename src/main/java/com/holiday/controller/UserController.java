package com.holiday.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
import com.holiday.util.RestResult;
import com.holiday.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.holiday.entity.User;
import com.holiday.service.UserService;
import com.holiday.vo.UserVO;

import com.holiday.entity.Role;
import com.holiday.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户表 相关Controller
 *
 * @author Elvis
 * @version 1.0.0
 * @date 2020-02-01
 * Copyright © Elvis.com
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseCrudMappingRestController<User, UserVO> {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ResultGenerator resultGenerator;

    /***
     * 加载更多数据
     * @return
     */
    @GetMapping("/findUserByInfo")
    public List<User> attachMore(String userName, String email, long pageNumber, long pageSize) {

        return userService.queryUserByCondition(userName, email, pageNumber, pageSize);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @PutMapping("/updateUserInfo")
    public RestResult updateUserInfo(User user) {
        return resultGenerator.getSuccessResult(userService.updateEntity(user));
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @DeleteMapping("/delUser")
    public RestResult delUser(User user) {
        return resultGenerator.getSuccessResult(userService.deleteEntity(user));
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public RestResult addUser(User user) {
        return resultGenerator.getSuccessResult(userService.createEntity(user));
    }

}