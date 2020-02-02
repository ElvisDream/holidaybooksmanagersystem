package com.holiday.service;

import com.holiday.entity.Book;

import java.util.List;

/**
* 书籍表相关Service
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
 * Copyright © Elvis.com
*/
public interface BookService extends BaseCustomService<Book> {

    /**
     * 查询所有可用书籍
     * @return
     */
    List<Book> queryAllBooks();

    /**
     * 减去书籍库存
     *
     * @param num
     */
    void updateBookNums(long bookId, int num);

}