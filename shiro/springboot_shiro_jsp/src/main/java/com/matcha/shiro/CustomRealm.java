package com.matcha.shiro;

import com.matcha.entity.User;
import com.matcha.service.UserService;
import com.matcha.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;


public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        System.out.println("===============================");

        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        User user_db = userService.findByUsername(principal);
        if (user_db != null) {
            return new SimpleAuthenticationInfo(user_db.getUsername(), user_db.getPassword(), ByteSource.Util.bytes(user_db.getSalt()), this.getName());
        }
//        if ("xiaochen".equals(principal)) {
//            return new SimpleAuthenticationInfo(principal, "123", this.getName());
//        }
        return null;
    }
}
