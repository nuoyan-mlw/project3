package com.crazycode.config;

import com.crazycode.realm.UserRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * 在容器中创建一个UserRealm对象
     * @return
     * @throws Exception
     */
    @Bean
    public Realm userRealm(CredentialsMatcher hashedCredentialsMatcher) throws Exception{
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);//指定realm使用哪个密码匹配器
        return userRealm;
    }


    /**
     * 配置一个Shiro过滤器,用来拦截所有的URL进行验证
     */

   @Bean
   public ShiroFilterChainDefinition shiroFilterChainDefinition() throws Exception{
       DefaultShiroFilterChainDefinition shiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
       Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
       filterChainDefinitionMap.put("/login.do","anon");//匿名访问
       filterChainDefinitionMap.put("/register.jsp","anon");//匿名访问
       filterChainDefinitionMap.put("/user/register","anon");//匿名访问
       //filterChainDefinitionMap.put("/manager/product","authc");//此路径必须认证通过后才能访问,否则返回到LoginUrl所指定的页面中
       //filterChainDefinitionMap.put("/manager/order","authc");
       filterChainDefinitionMap.put("/logout.do","logout");
       filterChainDefinitionMap.put("/**","authc");
       shiroFilterChainDefinition.addPathDefinitions(filterChainDefinitionMap);
       return shiroFilterChainDefinition;
   }

    /**
     * 在容器中装配securityManager对象
     * @param userRealm
     * @return
     * @throws Exception
     */
    @Bean
    public SessionsSecurityManager securityManager(Realm userRealm) throws Exception{
        SessionsSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;

    }

    /**
     * 配置一个CredentialsMatcher类型的加密对象
     * 当调用自定义realm验证方法的时候,会把表单传过来的密码交给HashedCredentialsMatcher来进行加密,加密后
     * 会和数据库中的密码进行比对
     */
    @Bean
    public CredentialsMatcher hashedCredentialsMatcher() throws Exception{
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);// 设置加密算法类型
        credentialsMatcher.setHashIterations(1024);//设置加密次数
        return credentialsMatcher;
    }
}
