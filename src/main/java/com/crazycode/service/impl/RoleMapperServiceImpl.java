package com.crazycode.service.impl;

import com.crazycode.mapper.PermissionMapper;
import com.crazycode.mapper.RoleMapper;
import com.crazycode.pojo.Role;
import com.crazycode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleMapperServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Role> queryRolePermission(String id) throws Exception {
        return roleMapper.queryRolePermission(id);
    }

    @Override
    public Role queryOneRolePermission(String id) throws Exception {
        return roleMapper.queryOneRolePermission(id);
    }

    @Override
    public List<Role> queryRole() throws Exception {
        return roleMapper.queryRole();
    }

    @Override
    @Transactional
    public int addRole(Role role) throws Exception {
        return roleMapper.addRole(role);
    }

    @Override
    @Transactional
    public void deleteRoleAndPermission(String rId) throws Exception {
       //删除角色
        roleMapper.deleteRole(rId);
        //删除权限
        permissionMapper.deleteRolePermission(rId);
    }

    @Override
    public void addUserRole(String[] rId, String uId) throws Exception {
        for (int i = 0;i < rId.length;i++){
            roleMapper.addUserRole(rId[i],uId);
        }
    }
}
