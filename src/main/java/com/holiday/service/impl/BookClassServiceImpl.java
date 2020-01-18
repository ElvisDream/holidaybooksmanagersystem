package com.holiday.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.BookClass;
import com.holiday.mapper.BookClassMapper;
import com.holiday.service.BookClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* 书籍类别表相关Service实现
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Service
public class BookClassServiceImpl extends BaseCustomServiceImpl<BookClassMapper, BookClass> implements BookClassService {
    private static final Logger log = LoggerFactory.getLogger(BookClassServiceImpl.class);

}
