package com.asiainfo.permission.mapper;

import com.asiainfo.permission.base.BaseMapper;
import com.asiainfo.permission.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/7 16:21
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名得到对应的用户信息
     * @param usercode
     * @return
     */
    User getByUserCode(String usercode);
    String getId();
    User getUserById(String id);
}
