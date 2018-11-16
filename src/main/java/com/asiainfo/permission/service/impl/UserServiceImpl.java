package com.asiainfo.permission.service.impl;

import com.asiainfo.permission.base.BaseServiceImpl;
import com.asiainfo.permission.domain.User;
import com.asiainfo.permission.mapper.UserMapper;
import com.asiainfo.permission.service.UserService;
import com.asiainfo.permission.util.MD5;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;


/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/7 16:27
 **/
@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void setBaseMapper() {
        super.setBaseMapper(userMapper);
    }

    @Override
    public User getByUserCode(String usercode) {
        return userMapper.getByUserCode(usercode);
    }

    @Override
    public int updateUser(User user) {
        MD5 m = new MD5();
        user.setPassword(m.getMD5ofStr(user.getPassword()));
        return userMapper.update(user);
    }

    @Override
    public int insertUser(User user) {
        MD5 m = new MD5();
        user.setId(UUID.randomUUID().toString());
        user.setPassword(m.getMD5ofStr(user.getPassword()));
        userMapper.insert(user);
        return 1;
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }
}
