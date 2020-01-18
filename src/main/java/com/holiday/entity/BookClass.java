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
* 书籍类别表 Entity定义
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
public class BookClass extends BaseCustomEntity {
    private static final long serialVersionUID = -4488760450453118987L;


    // 类别名称
    @Length(max=32, message="类别名称长度应小于32")
    @TableField()
    private String className;

    // 创建人
    @TableField()
    private Long createBy;

    // 更新时间
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;


    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
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
