package com.crazycode.service.impl;

import com.crazycode.Util.MD5Util;
import com.crazycode.mapper.LoginRegisterMapper;
import com.crazycode.pojo.Users;
import com.crazycode.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Autowired
    private LoginRegisterMapper loginRegisterMapper;

    @Override
    @Transactional
    public Users login(String username) throws Exception {
        return loginRegisterMapper.login(username);
    }

    @Override
    public int save(Users user) throws Exception {
        //对初始密码进行加密
        user.setPassword(MD5Util.md5hash(user.getPassword(),user.getUsername()));
        System.out.println(user.getPassword());
        return loginRegisterMapper.save(user);
    }
}
