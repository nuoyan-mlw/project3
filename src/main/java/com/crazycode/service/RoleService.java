package com.crazycode.service;

import com.crazycode.pojo.Role;

import java.util.List;

public interface RoleService {

    //查询role以及permission
    public List<Role> queryRolePermission(String id)throws Exception;

    //查询单个role的权利
    public Role queryOneRolePermission(String id)throws Exception;

    //查询所有的role
    public List<Role> queryRole()throws Exception;

    //添加role
    public int addRole(Role role)throws Exception;

    //删除角色以及角色的权限
    public void deleteRoleAndPermission(String rId)throws Exception;
}
