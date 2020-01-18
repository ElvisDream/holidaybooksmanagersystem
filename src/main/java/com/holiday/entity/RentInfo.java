package com.holiday.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.diboot.core.entity.BaseEntity;
import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;

/**
* 租借表 Entity定义
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
public class RentInfo extends BaseCustomEntity {
    private static final long serialVersionUID = -1973924841731398137L;


    // 外键，租借人id
    @Length(max=100, message="外键，租借人id长度应小于100")
    @TableField()
    private String userId;

    // 外键，外借书籍编号
    @Length(max=100, message="外键，外借书籍编号长度应小于100")
    @TableField()
    private String bookId;


    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

}
