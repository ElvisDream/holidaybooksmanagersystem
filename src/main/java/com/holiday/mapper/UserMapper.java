package com.holiday.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import com.holiday.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* 用户表Mapper
* @author Elvis
* @version 1.0.0
* @date 2020-01-19
 * Copyright © Elvis.com
*/
@Mapper
public interface UserMapper extends BaseCrudMapper<User> {

}

