package com.holiday.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import com.holiday.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 用户表Mapper
* @author Elvis
* @version 1.0.0
* @date 2020-02-01
 * Copyright © Elvis.com
*/
@Mapper
public interface UserMapper extends BaseCrudMapper<User> {

}

