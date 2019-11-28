package com.crazycode.mapper;

import com.crazycode.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {

    //查询role
    public List<Role> queryRolePermission(String id)throws Exception;

    //查询单个role的权利
    public Role queryOneRolePermission(String id)throws Exception;

    //查询所有的role
    public List<Role> queryRole()throws Exception;

    //添加role
    public int addRole(Role role)throws Exception;

    //删除角色
    public int deleteRole(String rid)throws Exception;

    //给用户添加角色
    public void addUserRole(@Param("userId")String rId,@Param("roleId") String uId)throws Exception;
}
