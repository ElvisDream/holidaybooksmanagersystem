package com.holiday.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import com.holiday.entity.RentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
* 租借表Mapper
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Mapper
public interface RentInfoMapper extends BaseCrudMapper<RentInfo> {

    /**
     * 记录用户借书信息
     *
     * @param params
     */
    void addOrUpdateRentInfo(Map<String, Object> params);
}

