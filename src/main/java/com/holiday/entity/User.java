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
 * 用户表 Entity定义
 * @author Elvis
 * @version 1.0.0
 * @date 2020-01-18
 * Copyright © Elvis.com
 */
public class User extends BaseCustomEntity {

    private static final long serialVersionUID = 1433548951438244396L;

    // 创建人
    @TableField()
    private Long createBy;

    // 更新时间
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

    // 性别
    @Length(max = 10, message = "性别长度应小于10")
    @TableField()
    private String gender;

    // 生日
    @TableField()
    private Date birthday;

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

    public String getGender() {
        return (gender);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return (birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
