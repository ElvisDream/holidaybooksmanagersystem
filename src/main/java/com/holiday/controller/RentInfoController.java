package com.holiday.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.holiday.entity.RentInfo;
import com.holiday.service.RentInfoService;
import com.holiday.vo.RentInfoVO;
import com.holiday.entity.User;
import com.holiday.service.UserService;
import com.holiday.entity.Book;
import com.holiday.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 租借表 相关Controller
 * @author Elvis
 * @version 1.0.0
 * @date 2020-01-18
 * Copyright © Elvis.com
 */
@RestController
@RequestMapping("/rentInfo")
public class RentInfoController extends BaseCrudMappingRestController<RentInfo, RentInfoVO> {

    private static final Logger log = LoggerFactory.getLogger(RentInfoController.class);

    @Autowired
    private RentInfoService rentInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    /**
     * 加载更多数据
     * @return
     * @throws Exception
     */
    @GetMapping("/attachMore")
    public JsonResult attachMore(HttpServletRequest request, ModelMap modelMap) throws Exception {
        Wrapper wrapper = null;
        return new JsonResult(modelMap);
    }
}
