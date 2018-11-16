package com.asiainfo.permission.service;

import com.asiainfo.permission.domain.UserARole;

import java.util.List;


public interface RoleService {
    /**
     * 根据用户ID获取角色
     *
     * @return
     */
    List<UserARole> getRole();

    /**
     * 修改用户角色
     */
    void updateUserRole(String userId, String[] roleList);
}
