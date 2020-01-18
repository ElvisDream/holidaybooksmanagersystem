package com.holiday.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.holiday.entity.RoleMenu;
import com.holiday.service.RoleMenuService;
import com.holiday.vo.RoleMenuVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* 关联中间表 相关Controller
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController extends BaseCrudMappingRestController<RoleMenu, RoleMenuVO> {
    private static final Logger log = LoggerFactory.getLogger(RoleMenuController.class);

    @Autowired
    private RoleMenuService roleMenuService;


}