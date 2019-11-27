package com.crazycode.service.impl;

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
    public Users login(Users users) throws Exception {
        return loginRegisterMapper.login(users);
    }
}
