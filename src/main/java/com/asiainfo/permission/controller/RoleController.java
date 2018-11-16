package com.asiainfo.permission.controller;

import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.domain.UserARole;
import com.asiainfo.permission.mapper.RoleMapper;
import com.asiainfo.permission.service.RoleService;
import com.asiainfo.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    public String rolePage(Model model) {
        List<UserARole> roleAUser = roleService.getRole();
        model.addAttribute("userRole", roleAUser);
        return "editItemsList";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updatePage(Model model, String id) {
        User user = userService.getUserById(id);
        List<Map<String,String>> roleByUserId = roleMapper.getRoleByUserId(id);
        List<Map<String,String>> notUserRoleList = roleMapper.getRoleByNotUserId(id);
        model.addAttribute("user",user);
        model.addAttribute("roleList", roleByUserId);
        model.addAttribute("notUserRoleList",notUserRoleList);
        return "editItem";
    }
    @RequestMapping(value = "roleuser",method = RequestMethod.GET)
    public String updateRole(HttpServletRequest request) {
            String userId = request.getParameter("userId");
            String[] roleList =  request.getParameterValues("roleList");
            roleService.updateUserRole(userId,roleList);
            return "200";
    }
}
