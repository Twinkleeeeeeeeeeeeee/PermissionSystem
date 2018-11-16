package com.asiainfo.permission.controller;

import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/9 11:29
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("query")
    @RequiresPermissions("user:query")
    public String query(Model model){
        List<User> list = userService.selectAll();
        model.addAttribute("userList",list);
        return "userList";
    }

    @RequestMapping("delete")
    @RequiresPermissions("user:delete")
    public String delete(String id){
        userService.delete(id);
        return "redirect:query.action";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @RequiresPermissions("user:update")
    public String update(User user){
        userService.updateUser(user);
        System.out.println(user);
        return "redirect:query.action";
    }

    @RequestMapping("insert")
    @RequiresPermissions("user:create")
    public String insert(User user){
        userService.insertUser(user);
        return "redirect:query.action";
    }

    @RequestMapping("goUpdate")
    public String goUpdate(String id){
        request.setAttribute("user",userService.getById(id));
        return "goUpdate";
    }

    @RequestMapping("goAdd")
    public String goAdd(){
        return "goAdd";
    }
}
