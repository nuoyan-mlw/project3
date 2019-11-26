package com.crazycode.mapper;

import com.crazycode.pojo.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {
    //查询权利
    public List<Permission> queryPermission(String id);
}
