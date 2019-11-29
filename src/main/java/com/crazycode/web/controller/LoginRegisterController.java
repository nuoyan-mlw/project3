package com.crazycode.web.controller;

import com.crazycode.pojo.Users;
import com.crazycode.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginRegisterController {

    @Autowired
    private LoginRegisterService loginRegisterService;

    @PostMapping("/login.do")
    public ModelAndView login(Users users, HttpServletRequest req)throws Exception{
        Users user = loginRegisterService.login(users);
        ModelAndView mv = new ModelAndView();
        if(user != null){
            HttpSession session = req.getSession(true);
            session.setAttribute("user",user);
            mv.setViewName("pages/main");
        }else {
            mv.setViewName("login");
        }
        return mv;
    }

    @GetMapping("/logout.do")
    public ModelAndView logout(HttpServletRequest req){
        ModelAndView mv = new ModelAndView("login");
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return mv;
    }
}
