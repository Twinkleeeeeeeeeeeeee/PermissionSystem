package com.asiainfo.permission.service;

import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.domain.UserVo;

/**
 * @ClassName LoginService
 * @Description TODO 用户登录service
 * @Author LIUYH
 * @DateTime 2018/11/4 16:25
 **/
public interface LoginService {

    String login(String data)throws Exception;
    /**
     * 获取用户登录信息
     * @return
     */
    UserVo loginUserInfo();

    /**
     * 登录成功跳转的页面
     * @return
     */
    String urlPage(User user);
}
