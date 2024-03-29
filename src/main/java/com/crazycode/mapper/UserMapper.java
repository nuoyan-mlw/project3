package com.crazycode.mapper;

import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;
import com.crazycode.pojo.Users;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    //添加user
    public int addUser(Users users)throws Exception;

    //查询user
    public List<Users> queryUser()throws Exception;

    //查询用户根据ID
    public Users queryUserByID(String id)throws Exception;

}
