package com.asiainfo.permission.domain;

import lombok.Data;

@Data
public class Permission {
    /**
     * 主键
     */
    private String id;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源类型
     */
    private String type;
    /**
     * 访问url地址
     */
    private String url;
    /**
     * 父节点id
     */
    private String percode;
    /**
     * 父节点id列表串
     */
    private String parentid;
    /**
     * 父节点id列表串
     */
    private String parentids;
    /**
     * 排序号
     */
    private String sortstring;
    /**
     * 是否可用 1可用 0不可用
     *
     */
     private String avaliable;
}
