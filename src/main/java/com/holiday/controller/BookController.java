package com.holiday.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.holiday.entity.Book;
import com.holiday.service.BookService;
import com.holiday.vo.BookVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* 书籍表 相关Controller
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
@RestController
@RequestMapping("/book")
public class BookController extends BaseCrudMappingRestController<Book, BookVO> {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;


}