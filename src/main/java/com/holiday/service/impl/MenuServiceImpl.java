package com.holiday.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.Menu;
import com.holiday.mapper.MenuMapper;
import com.holiday.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* 目录表相关Service实现
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Service
public class MenuServiceImpl extends BaseCustomServiceImpl<MenuMapper, Menu> implements MenuService {
    private static final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

}
