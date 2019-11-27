package com.crazycode.service;

import com.crazycode.pojo.Permission;

import java.util.List;

public interface PermissionService {
    //查询一个人权利
    public List<Permission> queryPermissionById(String id)throws Exception;

    //查询所有的权利
    public List<Permission> queryAllPermission()throws Exception;

    //给角色添加权限
    public void addRolePermission(String [] pId,String rId)throws Exception;



}
