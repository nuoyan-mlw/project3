package com.crazycode.service.impl;

import com.crazycode.mapper.RoleMapper;
import com.crazycode.pojo.Role;
import com.crazycode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleMapperServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRole(String id) throws Exception {
        return roleMapper.queryRole(id);
    }
}
