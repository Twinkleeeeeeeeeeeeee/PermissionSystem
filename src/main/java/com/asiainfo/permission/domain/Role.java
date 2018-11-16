package com.asiainfo.permission.domain;

import lombok.Data;

@Data
public class Role {
    /**
     * 角色ID
     */
    private String id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 是否可用
     */
    private String avaliable;


}
