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
 * 角色表 Entity定义
 * @author Elvis
 * @version 1.0.0
 * @date 2020-01-18
 * Copyright © Elvis.com
 */
public class Role extends BaseCustomEntity {

    private static final long serialVersionUID = -5440684959811996653L;

    // 角色名称
    @Length(max = 32, message = "角色名称长度应小于32")
    @TableField()
    private String roleName;

    public String getRoleName() {
        return (roleName);
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
