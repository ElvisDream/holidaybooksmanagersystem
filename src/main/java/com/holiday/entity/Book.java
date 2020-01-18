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
* 书籍表 Entity定义
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
public class Book extends BaseCustomEntity {
    private static final long serialVersionUID = 6394165379265402916L;


    // 书籍名称
    @Length(max=255, message="书籍名称长度应小于255")
    @TableField()
    private String bookName;

    // 作者
    @Length(max=255, message="作者长度应小于255")
    @TableField()
    private String author;

    // 出版社
    @Length(max=255, message="出版社长度应小于255")
    @TableField()
    private String publish;

    // 书籍编号
    @Length(max=255, message="书籍编号长度应小于255")
    @TableField()
    private String bookCode;

    // 书籍类别
    @Length(max=32, message="书籍类别长度应小于32")
    @TableField()
    private String bookClassId;

    // 语言
    @Length(max=32, message="语言长度应小于32")
    @TableField()
    private String bookLanguage;

    // 简介
    @Length(max=2000, message="简介长度应小于2000")
    @TableField()
    private String introduction;

    // 价格
    @TableField()
    private Double price;

    // 图标
    @Length(max=500, message="图标长度应小于500")
    @TableField()
    private String iconAddress;

    // 剩余数量
    @TableField()
    private Integer bookNums;

    // 创建人
    @TableField()
    private Long createBy;

    // 更新时间
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;


    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getBookCode() {
        return bookCode;
    }
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookClassId() {
        return bookClassId;
    }
    public void setBookClassId(String bookClassId) {
        this.bookClassId = bookClassId;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }
    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIconAddress() {
        return iconAddress;
    }
    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress;
    }

    public Integer getBookNums() {
        return bookNums;
    }
    public void setBookNums(Integer bookNums) {
        this.bookNums = bookNums;
    }

    public Long getCreateBy() {
        return createBy;
    }
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
