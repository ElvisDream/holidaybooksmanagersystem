package com.holiday.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.RoleMenu;
import com.holiday.mapper.RoleMenuMapper;
import com.holiday.service.RoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* 关联中间表相关Service实现
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Service
public class RoleMenuServiceImpl extends BaseCustomServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    private static final Logger log = LoggerFactory.getLogger(RoleMenuServiceImpl.class);

}
