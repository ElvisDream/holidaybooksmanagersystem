package com.holiday.vo;

import com.diboot.core.binding.annotation.*;
import com.holiday.entity.RentInfo;
import com.holiday.entity.User;
import com.holiday.entity.Book;
import java.util.List;

/**
 * 租借表 VO定义
 * @author Elvis
 * @version 1.0.0
 * @date 2020-01-18
 * Copyright © Elvis.com
 */
public class RentInfoVO extends RentInfo {

    private static final long serialVersionUID = -4277569026017529781L;

    // 字段关联：this.user_id=id
    @BindEntity(entity = User.class, condition = "this.user_id=id")
    private User user;

    // 字段关联：this.book_id=id
    @BindEntity(entity = Book.class, condition = "this.book_id=id")
    private Book book;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
