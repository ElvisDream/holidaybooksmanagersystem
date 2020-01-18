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
* 关联中间表 Entity定义
* @author Elvis
* @version 1.0.0
* @date 2020-01-18
* Copyright © Elvis.com
*/
public class UserRole extends BaseCustomEntity {
    private static final long serialVersionUID = -3561111454575136792L;


    // role_id
    @NotNull(message = "role_id不能为空")
    @TableField()
    private Long roleId;

    // user_id
    @NotNull(message = "user_id不能为空")
    @TableField()
    private Long userId;


    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
