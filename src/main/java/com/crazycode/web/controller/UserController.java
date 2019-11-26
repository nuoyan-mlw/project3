package com.crazycode.web.controller;

import com.crazycode.pojo.Users;
import com.crazycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/save.do")
    public String addUser(Users users)throws Exception{
        int i = userService.addUser(users);
        if(i == 1){
            return "redirect:/user/query.do";
        }else{
            return "pages/user-add";
        }

    }

    @GetMapping("/user/query.do")
    private ModelAndView queryUser()throws Exception{
        ModelAndView mv = new ModelAndView("pages/user-list");
        List<Users> users = userService.queryUser();
        mv.addObject("users",users);
        return mv;
    }
}
