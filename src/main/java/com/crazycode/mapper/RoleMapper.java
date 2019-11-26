package com.crazycode.mapper;

import com.crazycode.pojo.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {

    //查询role
    public List<Role> queryRole(String id)throws Exception;
}
