package com.crazycode.mapper;

import com.crazycode.pojo.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {
    //查询权利
    public List<Permission> queryPermissionById(String id)throws Exception;

    //查询所有的权利
    public  List<Permission> queryAllPermission()throws Exception;

    //给角色添加权限
    public void addRolePermission(@Param("permissionId") String permissionId,@Param("roleId") String roleId)throws Exception;

    //删除角色权限
    public void deleteRolePermission(String roleId)throws Exception;

    //添加权限种类
    public int addPermission(Permission permission)throws Exception;

    //查询权限详情
    public Permission queryPermission(String pId)throws Exception;

    //删除权限
    public int deletePermission(String pId)throws Exception;

}
