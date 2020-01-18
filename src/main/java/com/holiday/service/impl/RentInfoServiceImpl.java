package com.holiday.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.RentInfo;
import com.holiday.mapper.RentInfoMapper;
import com.holiday.service.RentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* 租借表相关Service实现
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Service
public class RentInfoServiceImpl extends BaseCustomServiceImpl<RentInfoMapper, RentInfo> implements RentInfoService {
    private static final Logger log = LoggerFactory.getLogger(RentInfoServiceImpl.class);

}
