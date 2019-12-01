package com.crazycode.realm;

import com.crazycode.pojo.Users;
import com.crazycode.service.LoginRegisterService;
import com.crazycode.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private LoginRegisterService loginRegisterService;
    @Override
    /**
     * 对当前登录的用户进行授权
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权方法");
        return null;
    }

    /**
     * 登录用户进行验证的方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //System.out.println("执行了认证方法.....");
        /*UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)token;
        String username=usernamePasswordToken.getUsername();*/
        String username = (String) token.getPrincipal();
        //根据用户名查询数据库得到用户信息
        //以下数据模拟根据传过来的用户名找到的账号信息
        Users user = null;
        try {
            user = loginRegisterService.login(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(user==null){
            throw  new UnknownAccountException();
        }
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());// 得到佐料
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),salt,getName());
        return authenticationInfo;
    }
}
