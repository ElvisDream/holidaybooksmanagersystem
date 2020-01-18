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
public class RoleMenu extends BaseCustomEntity {
    private static final long serialVersionUID = 7160492986802616289L;


    // menu_id
    @NotNull(message = "menu_id不能为空")
    @TableField()
    private Long menuId;

    // role_id
    @NotNull(message = "role_id不能为空")
    @TableField()
    private Long roleId;


    public Long getMenuId() {
        return menuId;
    }
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
