package com.asiainfo.permission.service;

import com.asiainfo.permission.domain.Permission;
import com.asiainfo.permission.domain.RoleVo;

import java.util.List;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/8 10:45
 **/
public interface PermissionService {

    List<Permission> getMenuList(String id);

    List<String> permissionPerCode(String id);

    List<RoleVo> findAll();

    RoleVo getPermissionById(String id);

    int permissionDel(String roleId,String permissionId);

    List<Permission> userNotPermission(String id);

    int insertPermission(String roleId,String permissionId);
}
