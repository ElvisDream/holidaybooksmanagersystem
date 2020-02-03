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
    void minusBookNums(Map<String,Object> params);

    /**
     * 增加库存
     * @param params
     */
    void addBookNums(Map<String, Object> params);

}

