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
* @date 2020-02-01
* Copyright © Elvis.com
*/
public class User extends BaseCustomEntity {
    private static final long serialVersionUID = 2452338415890891889L;


    // 用户名
    @Length(max=32, message="用户名长度应小于32")
    @TableField()
    private String userName;

    // 密码
    @Length(max=32, message="密码长度应小于32")
    @TableField()
    private String userPwd;

    // 电话
    @Length(max=32, message="电话长度应小于32")
    @TableField()
    private String phone;

    // 创建人
    @TableField()
    private Long createBy;

    // 更新时间
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

    // 邮箱
    @Length(max=100, message="邮箱长度应小于100")
    @TableField()
    private String email;


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
