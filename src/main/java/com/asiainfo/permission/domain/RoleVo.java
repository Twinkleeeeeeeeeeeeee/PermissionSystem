package com.asiainfo.permission.domain;

import lombok.Data;

import java.util.List;

@Data
public class RoleVo  extends Role{

    private List<Permission> permissionList;
}
