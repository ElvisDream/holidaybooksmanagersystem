package com.holiday.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.Role;
import com.holiday.mapper.RoleMapper;
import com.holiday.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* 角色表相关Service实现
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Service
public class RoleServiceImpl extends BaseCustomServiceImpl<RoleMapper, Role> implements RoleService {
    private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

}
