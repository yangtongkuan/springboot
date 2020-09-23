package com.matcha.config;

import com.matcha.shiro.CustomRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 1. 设置filter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/index.jsp", "authc");  // authc 标识资源既要做认证也要做授权
        factoryBean.setUnauthorizedUrl("/login.jsp"); // 默认没有登录跳转界面
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }

    // 2. 注入管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置认证授权
        securityManager.setRealm(realm);
        return securityManager;
    }

    // 3. 注入realm
    @Bean
    public Realm getRealm() {
        return new CustomRealm();
    }


}
