package com.holiday.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diboot.core.service.impl.BaseServiceImpl;
import com.holiday.entity.Book;
import com.holiday.mapper.BookMapper;
import com.holiday.mapper.RentInfoMapper;
import com.holiday.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

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
@Transactional(propagation= Propagation.NESTED, isolation = Isolation.DEFAULT)
public class BookServiceImpl extends BaseCustomServiceImpl<BookMapper, Book> implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Resource
    private BookMapper bookMapper;

    @Resource
    private RentInfoMapper rentInfoMapper;

    @Override
    public List<Book> queryAllBooks() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.gt("book_nums", "0");
        return bookMapper.selectList(wrapper);
    }

    /**
     * 借书
     * @param bookId
     * @param num
     * @param userId
     */
    @Override
    public void minusBookNums(long bookId, int num, long userId) {
//        减去借书数量
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);
        param.put("num", num);
        bookMapper.minusBookNums(param);
//        记录借书信息
        Map<String, Object> rentInfoParam = new HashMap<>();
        rentInfoParam.put("userId", userId);
        rentInfoParam.put("bookId", bookId);
        rentInfoParam.put("bookNums", num);
        rentInfoMapper.addOrUpdateRentInfo(rentInfoParam);
    }

    /**
     * 还书
     * @param bookId
     * @param num
     */
    @Override
    public String addBookNums(long bookId, int num, long userId) {
        Map<String, Object> rentInfoParam = new HashMap<>();
        rentInfoParam.put("userId", userId);
        rentInfoParam.put("bookId", bookId);
        rentInfoParam.put("bookNums", -num);
        //        查询同一用户还书数量是否大于借书数量
        Object rentNums = bookMapper.queryRentNums(rentInfoParam);
        if (rentNums == null) {
            return "暂未查询到借书记录";
        }
        if (Integer.parseInt(rentNums.toString()) < num) {
            return "还书数量错误";
        }
        //        记录借书信息
        rentInfoMapper.addOrUpdateRentInfo(rentInfoParam);
        //        增加书籍数量
        rentInfoParam.put("bookNums", num);
        bookMapper.addBookNums(rentInfoParam);
        return "";
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
