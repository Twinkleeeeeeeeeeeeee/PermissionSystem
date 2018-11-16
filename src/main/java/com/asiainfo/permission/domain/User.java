package com.asiainfo.permission.domain;

import lombok.Data;

@Data
public class User {
    /**
     * 主键
     */
    private String id;
    /**
     * 账号
     */
    private String usercode;
    /**
     * 姓名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
