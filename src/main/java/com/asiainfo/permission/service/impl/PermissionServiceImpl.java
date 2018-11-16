package com.asiainfo.permission.service.impl;

import com.asiainfo.permission.domain.Permission;
import com.asiainfo.permission.domain.RoleVo;
import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.domain.UserVo;
import com.asiainfo.permission.mapper.PermissionMapper;
import com.asiainfo.permission.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/8 10:46
 **/
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getMenuList(String id) {
        return permissionMapper.getMenuList(id);
    }

    @Override
    public List<String> permissionPerCode(String id) {
        return permissionMapper.permissionPerCode(id);
    }

    @Override
    public  List<RoleVo> findAll(){
        Subject subject = SecurityUtils.getSubject();
        UserVo userVo = (UserVo)subject.getPrincipal();
        List<RoleVo> roleList = permissionMapper.selectAllRole(userVo.getId());
        List<RoleVo> roleVoList2 = new ArrayList<>();
        for (RoleVo roleVo :roleList) {
            List<Permission> permissionList = permissionMapper.findAll(roleVo.getId());
            roleVo.setPermissionList(permissionList);
            roleVoList2.add(roleVo);
        }
        return roleVoList2;
    }

    @Override
    public RoleVo getPermissionById(String id) {
        RoleVo roleVo = permissionMapper.getRoleById(id);
        List<Permission> permissionList = permissionMapper.findAll(roleVo.getId());
        roleVo.setPermissionList(permissionList);
        return roleVo;
    }

    @Override
    public int permissionDel(String roleId, String permissionId) {
        return permissionMapper.permissionDel(roleId,permissionId);
    }

    @Override
    public List<Permission> userNotPermission(String id) {
        return permissionMapper.userNotPermission(id);
    }

    @Override
    public int insertPermission(String roleId, String permissionId) {
        return permissionMapper.insertPermission(roleId,permissionId);
    }
}
