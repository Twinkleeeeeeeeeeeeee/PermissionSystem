package com.asiainfo.permission.service.impl;

import com.asiainfo.permission.controller.exceptionresolver.CustomException;
import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.domain.UserVo;
import com.asiainfo.permission.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/4 16:26
 **/
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String data)throws Exception{
        if(data!=null) {
            if(UnknownAccountException.class.getName().equals(data)) {
                throw new CustomException("账号不存在");
            }else if(IncorrectCredentialsException.class.getName().equals(data)) {
                throw new CustomException("账号/密码错误");
            }else {
                //最终在异常处理器生成未知错误
                throw new Exception();
            }
        }
        return "login";
    }
    @Override
    public UserVo loginUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        return (UserVo) subject.getPrincipal();
    }

    @Override
    public String urlPage(User user) {
        return "first";
    }
}
