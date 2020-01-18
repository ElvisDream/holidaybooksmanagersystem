package com.holiday.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import com.holiday.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
* 关联中间表Mapper
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Mapper
public interface UserRoleMapper extends BaseCrudMapper<UserRole> {

}

