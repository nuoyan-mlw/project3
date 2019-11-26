package com.crazycode.service;

import com.crazycode.pojo.Users;

public interface LoginRegisterService {
    //登陆用户
    public Users login(Users users)throws Exception;
}
