package org.example.md5;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义md5 用户认证
 */
public class CustomMd5Realm extends AuthorizingRealm {

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("身份信息:" + primaryPrincipal);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addRole("user");

        // 有创建用户的所有权限 以及商品的查询权限
        simpleAuthorizationInfo.addStringPermission("user:*:*");
        simpleAuthorizationInfo.addStringPermission("product:find:*");
        return simpleAuthorizationInfo;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        // 1. 设置md5 加密认证
        //        if ("zhangsan".equals(principal)) {
//            return new SimpleAccount(principal, "202cb962ac59075b964b07152d234b70", this.getName());
//        }
        // 2. md5(pwd+salt) 策略
//        if ("zhangsan".equals(principal)) {
//            return new SimpleAccount(principal, "cb135b10276179ac75c97ff4cd105a86", ByteSource.Util.bytes("qps"), this.getName());
//        }
        // 3. md5(pwd+salt) +hash 散列
        if ("zhangsan".equals(principal)) {
            return new SimpleAccount(principal, "23a63df199cf48069a99dab084621f70", ByteSource.Util.bytes("qps"), this.getName());
        }
        return null;
    }
}
