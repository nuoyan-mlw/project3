package com.crazycode.service.impl;

import com.crazycode.mapper.UserMapper;
import com.crazycode.pojo.Users;
import com.crazycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(Users users) throws Exception {
        return userMapper.addUser(users);
    }

    @Override
    public List<Users> queryUser() throws Exception {
        return userMapper.queryUser();
    }

    @Override
    public Users queryUserByID(String id) throws Exception {
        return userMapper.queryUserByID(id);
    }

}
