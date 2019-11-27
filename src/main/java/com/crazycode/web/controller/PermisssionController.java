package com.crazycode.web.controller;

import com.crazycode.pojo.Permission;
import com.crazycode.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PermisssionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/permission/queryPermission.do")//查找所有的权限
    public ModelAndView queryPermission()throws Exception{
        ModelAndView mv = new ModelAndView("pages/permission-list");
        List<Permission> permissions = permissionService.queryAllPermission();
        mv.addObject("permission",permissions);
        return mv;
    }

    //添加权限
    @PostMapping("/permission/addPerission.do")
    public String addPerission(Permission permission)throws Exception{
        System.out.println(permission);
        int i = permissionService.addPermission(permission);
        if(i == 1){
            return "redirect:/permission/queryPermission.do";
        }else{
            return "pages/permission=add";
        }
    }

    //查询权限详情
    @GetMapping("/permission/queryPermission/{id}")
    public ModelAndView queryPermission(@PathVariable("id") String pId)throws Exception{
        ModelAndView mv = new ModelAndView("pages/permission-show");
        Permission permission = permissionService.queryPermission(pId);
        mv.addObject("permission",permission);
        return mv;
    }

    //删除权限
    @GetMapping("/permission/deletePermission/{id}")
    public String deletePermission(@PathVariable("id") String pId)throws Exception{
        int i = permissionService.deletePermission(pId);

        return "redirect:/permission/queryPermission.do";
    }
}
