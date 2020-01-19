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
* @date 2020-01-19
* Copyright © Elvis.com
*/
public class User extends BaseCustomEntity {
    private static final long serialVersionUID = 1031569552458161922L;


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

    // 住址
    @Length(max=255, message="住址长度应小于255")
    @TableField()
    private String address;

    // 性别
    @Length(max=10, message="性别长度应小于10")
    @TableField()
    private String gender;

    // 生日
    @TableField()
    private Date birthday;

    // 创建人
    @TableField()
    private Long createBy;

    // 更新时间
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;


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

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
