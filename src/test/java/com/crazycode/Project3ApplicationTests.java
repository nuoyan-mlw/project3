package com.crazycode;

import com.crazycode.mapper.PermissionMapper;
import com.crazycode.mapper.RoleMapper;
import com.crazycode.mapper.UserMapper;
import com.crazycode.pojo.Users;
import com.crazycode.service.LoginRegisterService;
import com.crazycode.service.RoleService;
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
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleService roleService;

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

    @Test
    public void permissionQuery()throws Exception{
        //System.out.println(userMapper.queryUserByID("ab07416d-a153-11e9-b4b3-74d02bd4fd82"));
        System.out.println(roleMapper.queryRolePermission("ab07416d-a153-11e9-b4b3-74d02bd4fd82"));
       //System.out.println(permissionMapper.queryPermissionById("4b56a3e3-a152-11e9-b4b3-74d02bd4fd82"));
    }

    @Test
    public void queryRole()throws Exception{
        System.out.println(roleService.queryRole());
    }
}
