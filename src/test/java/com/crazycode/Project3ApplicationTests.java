package com.crazycode;

import com.crazycode.pojo.Users;
import com.crazycode.service.LoginRegisterService;
import com.crazycode.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Project3ApplicationTests {

    @Autowired
    private LoginRegisterService loginRegisterService;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void login()throws Exception{
        Users users = new Users();
        users.setUsername("chenhao");
        users.setPassword("123456");
        System.out.println(loginRegisterService.login(users));
    }

    @Test
    public void register()throws Exception{
        Users users = new Users();
        users.setUsername("111111");
        users.setPassword("111111");
        users.setEmail("111111");
        users.setPhoneNum("11111");
        users.setStatus(1L);
        int i = userService.addUser(users);
        System.out.println(i);
    }
}
