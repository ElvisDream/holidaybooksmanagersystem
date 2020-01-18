package com.holiday.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.holiday.entity.BookClass;
import com.holiday.service.BookClassService;
import com.holiday.vo.BookClassVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* 书籍类别表 相关Controller
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
@RestController
@RequestMapping("/bookClass")
public class BookClassController extends BaseCrudMappingRestController<BookClass, BookClassVO> {
    private static final Logger log = LoggerFactory.getLogger(BookClassController.class);

    @Autowired
    private BookClassService bookClassService;


}