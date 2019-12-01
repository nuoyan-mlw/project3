package com.crazycode.mapper;

import com.crazycode.pojo.Users;
import org.springframework.stereotype.Component;

@Component
public interface LoginRegisterMapper {
    //登陆用户
    public Users login(String username)throws Exception;

    //注册
    public int save(Users user) throws Exception;
}
