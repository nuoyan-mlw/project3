package com.crazycode.service;

import com.crazycode.pojo.Permission;

import java.util.List;

public interface PermissionService {
    //查询权利
    public List<Permission> queryPermission(String id);
}
