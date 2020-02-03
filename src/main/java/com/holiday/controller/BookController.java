package com.holiday.controller;

import com.holiday.entity.Book;
import com.holiday.service.BookService;
import com.holiday.util.RestResult;
import com.holiday.util.ResultGenerator;
import com.holiday.vo.BookVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 书籍表 相关Controller
 *
 * @author Elvis
 * @version 1.0.0
 * @date 2020-01-18
 * Copyright © Elvis.com
 */
@RestController
@RequestMapping("/book")
public class BookController extends BaseCrudMappingRestController<Book, BookVO> {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private ResultGenerator resultGenerator;

    @GetMapping("/all")
    public RestResult allBooks() {
        return resultGenerator.getSuccessResult(bookService.queryAllBooks());
    }

    @DeleteMapping("/rent")
    public RestResult rentBook(long bookId, int num) {
        bookService.minusBookNums(bookId, num);
        return resultGenerator.getSuccessResult();
    }

    @PostMapping("/return")
    public RestResult returnBook(long bookId, int num) {
        bookService.addBookNums(bookId, num);
        return resultGenerator.getSuccessResult();
    }

    @GetMapping("queryBookByInfo")
    public RestResult queryBookByInfo(String bookName, String bookCode, String author) {
        return resultGenerator.getSuccessResult(bookService.queryBooksByCondition(bookName, bookCode, author));
    }
}