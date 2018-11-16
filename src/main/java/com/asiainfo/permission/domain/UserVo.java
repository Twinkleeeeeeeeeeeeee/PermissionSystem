package com.asiainfo.permission.domain;

import lombok.Data;

import java.util.List;

/**
 * @ClassName UserVo
 * @Description TODO
 * @Author LIUYH
 * @DateTime 2018/11/8 10:47
 **/
@Data
public class UserVo extends User{
    /**
     * 菜单列表
     */
    private List<Permission> menuList;

    private List<String> permissionPerCode;
}
