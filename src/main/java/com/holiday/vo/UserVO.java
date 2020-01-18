package com.holiday.vo;

import com.diboot.core.binding.annotation.*;
import com.holiday.entity.User;
import com.holiday.entity.Role;
import java.util.List;

/**
 * 用户表 VO定义
 * @author Elvis
 * @version 1.0.0
 * @date 2020-01-18
 * Copyright © Elvis.com
 */
public class UserVO extends User {

    private static final long serialVersionUID = -7853898229784733397L;

    // 通过中间表的多-多Entity实体关联
    @BindEntityList(entity = Role.class, condition = "this.id=user_role.user_id AND user_role.role_id=id AND user_role.is_deleted=0")
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
