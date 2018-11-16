package com.asiainfo.permission.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UserARole extends User {
    private List<Map<String,String>> name;
}
