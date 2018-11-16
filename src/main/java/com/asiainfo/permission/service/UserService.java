package com.asiainfo.permission.service;

import com.asiainfo.permission.base.BaseService;
import com.asiainfo.permission.domain.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/7 16:27
 **/
public interface UserService extends BaseService<User> {

    User getByUserCode(String usercode);
    int updateUser(User user);
    int insertUser(User user);
    User getUserById(String id);
}
