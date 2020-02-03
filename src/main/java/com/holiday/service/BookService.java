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
    void minusBookNums(long bookId, int num);

    /**
     * 增加书籍库存
     * @param bookId
     * @param num
     */
    void addBookNums(long bookId, int num);

    /**
     * 根据条件查询书籍
     * @param bookName
     * @param bookCode
     * @param author
     * @return
     */
    List<Book> queryBooksByCondition(String bookName, String bookCode, String author);
}