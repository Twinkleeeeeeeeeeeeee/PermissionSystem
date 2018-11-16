package com.asiainfo.permission.service.impl;

import com.asiainfo.permission.domain.Role;
import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.domain.UserARole;
import com.asiainfo.permission.mapper.RoleMapper;
import com.asiainfo.permission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<UserARole> getRole() {
        List<User> users = roleMapper.getUser();

        List<UserARole> userARoleList = new ArrayList<>();
        for (User  user : users) {
            UserARole usa = new UserARole();
            String userName = user.getUsername();
            String userId = user.getId();
            List<Map<String,String>> role = roleMapper.getRoleByUserId(userId);
            usa.setId(userId);
            usa.setName(role);
            usa.setUsername(userName);
            userARoleList.add(usa);
        }
        return userARoleList;
    }

    @Override
    public void updateUserRole(String userId,String[] roleList) {
        roleMapper.deleteUserRole(userId);
        for(String roId:roleList){
            roleMapper.insertRole(userId,roId);
        }
    }

}
