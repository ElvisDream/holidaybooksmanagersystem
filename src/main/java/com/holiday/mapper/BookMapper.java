package com.holiday.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import com.holiday.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 书籍表Mapper
 *
 * @author Elvis
 * @version 1.0.0
 * @date 2020-01-18
 * Copyright © Elvis.com
 */
@Mapper
public interface BookMapper extends BaseCrudMapper<Book> {

    /**
     * 减去书籍库存
     *
     * @param params
     */
    void updateBookNums(Map<String,Object> params);

}

