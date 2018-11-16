package com.asiainfo.permission.controller;

import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.domain.UserVo;
import com.asiainfo.permission.service.LoginService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/7 16:08
 **/
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/login")
    public String login() throws Exception {
        return loginService.login((String) request.getAttribute("shiroLoginFailure"));
    }

    @RequestMapping("/index")
    public String main(Model model){
        UserVo user = loginService.loginUserInfo();
        model.addAttribute("user",user);
        return loginService.urlPage(user);
    }


}
