package com.crazycode.service;

import com.crazycode.pojo.Users;

public interface LoginRegisterService {
    //登陆用户
    public Users login(String username)throws Exception;

    //注册
    public int save(Users user) throws Exception;
}
