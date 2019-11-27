package com.crazycode.web.controller;

import com.crazycode.pojo.Permission;
import com.crazycode.pojo.Role;
import com.crazycode.service.PermissionService;
import com.crazycode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.management.MonitorInfo;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/role/queryRole.do")//查询所有的角色
    public ModelAndView queryRole()throws Exception{
        ModelAndView mv = new ModelAndView("pages/role-list");
        List<Role> role = roleService.queryRole();
        mv.addObject("role",role);
        return mv;
    }

    @PostMapping("/role/addRole.do")//添加角色
    public String addRole(Role role)throws Exception{
        int i = roleService.addRole(role);
        if(i == 1){
            return "redirect:/role/queryRole.do";
        }else {
            return "redirect:/pages/role-add.jsp";
        }
    }

    @GetMapping("/role/showRolePermission.do/{id}")
    public ModelAndView showRolePermission(@PathVariable("id") String id)throws Exception{
        ModelAndView mv = new ModelAndView("pages/role-permission-add");
        mv.addObject("roleId",id);
        //查询展示所有的权限
        List<Permission> permissions = permissionService.queryAllPermission();
        mv.addObject("permission",permissions);
        return mv;
    }

    //给角色添加权限
    @PostMapping("/role/addRolePermission.do")
    public String addRolePermission(String [] ids,String roleId)throws Exception{
        permissionService.addRolePermission(ids,roleId);
        return "redirect:/role/queryRolePermissionById.do/"+roleId;
    }

    //查询角色的权限通过ID
    @GetMapping("/role/queryRolePermissionById.do/{id}")
    public ModelAndView queryRolePermissionById(@PathVariable("id") String rid)throws Exception{
        ModelAndView mv = new ModelAndView("pages/role-show");
        Role role = roleService.queryOneRolePermission(rid);
        mv.addObject("role",role);
        return mv;
    }

    //删除角色
    @GetMapping("/role/deleteRole.do/{id}")
    public String deleteRole(@PathVariable("id") String rid)throws Exception{
        roleService.deleteRoleAndPermission(rid);
        return "forward:/role/queryRole.do";
    }
}
