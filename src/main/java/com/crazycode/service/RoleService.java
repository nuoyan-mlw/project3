package com.crazycode.service;

import com.crazycode.pojo.Role;

import java.util.List;

public interface RoleService {

    //查询role以及permission
    public List<Role> queryRole(String id)throws Exception;
}
