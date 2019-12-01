package com.crazycode.web.controller;

import com.crazycode.pojo.Users;
import com.crazycode.service.LoginRegisterService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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
    public ModelAndView login(Users users)throws Exception{
        ModelAndView mv = new ModelAndView();
        String info = null;
        //获取登录的主体对象
        Subject currentUser = SecurityUtils.getSubject();
        //判断当前用户是否验证通过(是否登录成功)
        if (!currentUser.isAuthenticated()) {
            //把用户名和密码封装成UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword());
            try {
                currentUser.login(token);//当前用户进行登陆 参数类型:AuthenticationToken
            } catch (UnknownAccountException uae) {
                info = "用户名不正确";
            } catch (IncorrectCredentialsException ice) {
                info = "密码不正确";
            } catch (LockedAccountException lae) {
                info = "账号被锁定";
            } catch (AuthenticationException ae) {
                info = "联系管理员";
            }
        }

        if (info == null) {
            mv.setViewName("pages/main");
        } else {
            mv.addObject("info", info);
            mv.setViewName("login");
        }
        return mv;
    }

    @PostMapping("/user/register")
    public ModelAndView register(Users user) throws Exception {
        ModelAndView mv = new ModelAndView();
        int res = loginRegisterService.save(user);
        if (res > 0) {
            mv.addObject("info", "注册成功!");
            mv.setViewName("register");
            return mv;
        }
        return null;
    }

}
