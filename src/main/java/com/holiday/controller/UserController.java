package com.holiday.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
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
* @author Elvis
* @version 1.0.0
* @date 2020-01-19
* Copyright © Elvis.com
*/
@RestController
@RequestMapping("/user")
public class UserController extends BaseCrudMappingRestController<User, UserVO> {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /***
    * 加载更多数据
    * @return
    * @throws Exception
    */
    @GetMapping("/attachMore")
    public JsonResult attachMore(HttpServletRequest request, ModelMap modelMap) throws Exception{
        Wrapper wrapper = null;
        return new JsonResult(modelMap);
    }

}