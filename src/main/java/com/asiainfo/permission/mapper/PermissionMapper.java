package com.asiainfo.permission.mapper;

import com.asiainfo.permission.domain.Permission;
import com.asiainfo.permission.domain.RoleVo;

import java.util.List;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/8 10:22
 **/
public interface PermissionMapper {

    List<Permission> getMenuList(String id);

    /**
     * 用户所具有的的权限
     * @param id
     * @return
     */
    List<String> permissionPerCode(String id);

    List<RoleVo> selectAllRole(String id);

    RoleVo getRoleById(String id);

    int permissionDel(String roleId,String permissionId);

    List<Permission> userNotPermission(String id);

    int insertPermission(String roleId,String permissionId);

    List <Permission> findAll(String id);
}

