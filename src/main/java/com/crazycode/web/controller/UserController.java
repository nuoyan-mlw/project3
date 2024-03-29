package com.crazycode.web.controller;

import com.crazycode.pojo.Role;
import com.crazycode.pojo.Users;
import com.crazycode.service.RoleService;
import com.crazycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @PostMapping("/user/save.do")//添加用户
    public String addUser(Users users)throws Exception{
        int i = userService.addUser(users);
        if(i == 1){
            return "redirect:/user/query.do";
        }else{
            return "pages/user-add";
        }

    }

    @GetMapping("/user/query.do")//查询所有的用户
    public ModelAndView queryUser()throws Exception{
        ModelAndView mv = new ModelAndView("pages/user-list");
        List<Users> users = userService.queryUser();
        mv.addObject("users",users);
        return mv;
    }

    @GetMapping("/user/info/{id}")//查询用户的详情
    public ModelAndView queryUserMsg(@PathVariable("id") String id)throws Exception{
        ModelAndView mv = new ModelAndView("pages/user-show1");
        //查询用户信息
        Users user = userService.queryUserByID(id);
        //查询用户权利和职责
        List<Role> role = roleService.queryRolePermission(id);
        mv.addObject("user",user);
        mv.addObject("role",role);
        return mv;
    }

    //查询角色
    @GetMapping("/user/adduser/{id}")
    public ModelAndView queryRole(@PathVariable("id") String uid)throws Exception{
        ModelAndView mv = new ModelAndView("pages/user-role-add");
        List<Role> roles = roleService.queryRole();
        mv.addObject("userId",uid);
        mv.addObject("roles",roles);
        return mv;
    }

    //给用户添加角色
    @PostMapping("/role/addUserRole.do")
    public String addRolePermission(String [] ids,String userId)throws Exception{
        roleService.addUserRole(ids,userId);
        return "redirect:/user/info/"+userId;
    }

}
