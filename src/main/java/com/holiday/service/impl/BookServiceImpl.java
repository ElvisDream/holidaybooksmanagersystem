package com.holiday.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.Book;
import com.holiday.mapper.BookMapper;
import com.holiday.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
* 书籍表相关Service实现
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
@Service
public class BookServiceImpl extends BaseCustomServiceImpl<BookMapper, Book> implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

}
