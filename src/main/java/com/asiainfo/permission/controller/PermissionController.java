package com.asiainfo.permission.controller;


import com.asiainfo.permission.domain.RoleVo;
import com.asiainfo.permission.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("query")
    @RequiresPermissions("permission:query")
    public  String query(Model model){
        List<RoleVo> list = permissionService.findAll();
        model.addAttribute("permissionList",list);
        return "permissionList";
    }

    @RequestMapping("goPermissionUpdate")
    @RequiresPermissions("permission:query")
    public String goPermissionUpdate(String id){
        request.setAttribute("p",permissionService.getPermissionById(id));
        request.setAttribute("userNotPermission",permissionService.userNotPermission(id));
        return "PermissionUpdate";
    }

    @RequestMapping("deletePermission")
    @RequiresPermissions("permission:delete")
    public String deletePermission(String roleId,String permissionId){
        permissionService.permissionDel(roleId, permissionId);
        return this.goPermissionUpdate(roleId);
    }
    @RequestMapping("addPermission")
    @RequiresPermissions("permission:create")
    public String addPermission(String roleId,String permissionId){
        permissionService.insertPermission(roleId,permissionId);
        return this.goPermissionUpdate(roleId);
    }
}
