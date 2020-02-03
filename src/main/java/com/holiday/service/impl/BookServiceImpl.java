package com.holiday.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.Book;
import com.holiday.mapper.BookMapper;
import com.holiday.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> queryAllBooks() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.gt("book_nums", "0");
        return bookMapper.selectList(wrapper);
    }

    @Override
    public void minusBookNums(long bookId, int num) {
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);
        param.put("num", num);
        bookMapper.minusBookNums(param);
    }

    @Override
    public void addBookNums(long bookId, int num) {
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);
        param.put("num", num);
        bookMapper.addBookNums(param);
    }

    @Override
    public List<Book> queryBooksByCondition(String bookName, String bookCode, String author) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.gt("book_nums", 0);
        if (bookName != null && !"".equals(bookName)) {
            wrapper.like("book_name", bookName);
        }
        if (bookCode != null && !"".equals(bookCode)) {
            wrapper.like("book_code", bookCode);
        }
        if (author != null && !"".equals(author)) {
            wrapper.like("author", author);
        }

        return bookMapper.selectList(wrapper);

    }

}
