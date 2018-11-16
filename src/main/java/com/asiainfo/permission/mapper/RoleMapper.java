package com.asiainfo.permission.mapper;

import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.domain.UserARole;
import com.asiainfo.permission.domain.UserVo;

import java.util.List;
import java.util.Map;


public interface RoleMapper {
    /**
     *
     * @param userId:用户id
     * @return 返回角色信息
     */
    List<Map<String,String>> getRoleByUserId(String userId);

    /**
     * 获取用户列表
     * @return user:用户信息
     */
    List<User> getUser();

    /**
     * 获取未选中的角色列表
     * @param userId:用户id
     * @return
     */
    List<Map<String,String>> getRoleByNotUserId(String userId);

    /**
     * 获取角色id
     * @param userId:用户id
     * @return
     */
    List<String> getRoleIdByUserId(String userId);

    /**
     * 删除用户所具有的角色
     */
    void deleteUserRole(String userId);
    /**
     * 增加用户角色
     */
    void insertRole(String userId, String RoleId);
}
