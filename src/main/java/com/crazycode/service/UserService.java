package com.crazycode.service;

import com.crazycode.pojo.Users;

import java.util.List;

public interface UserService {
    //添加user
    public int addUser(Users users)throws Exception;

    //查询user
    public List<Users> queryUser()throws Exception;

    //查询用户根据ID
    public Users queryUserByID(String id)throws Exception;


}
