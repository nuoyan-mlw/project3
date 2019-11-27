package com.crazycode.service.impl;

import com.crazycode.mapper.PermissionMapper;
import com.crazycode.pojo.Permission;
import com.crazycode.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionMapperServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> queryPermissionById(String id)throws Exception {
        return permissionMapper.queryPermissionById(id);
    }

    @Override
    public List<Permission> queryAllPermission()throws Exception {
        return permissionMapper.queryAllPermission();
    }

    @Override
    public void addRolePermission(String [] pId,String rId)throws Exception {
        for (int i = 0;i < pId.length;i++){
            permissionMapper.addRolePermission(pId[i],rId);
        }
    }
}
