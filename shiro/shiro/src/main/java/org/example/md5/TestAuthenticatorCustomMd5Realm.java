package org.example.md5;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * 测试mds + salt 加盐认证
 */
public class TestAuthenticatorCustomMd5Realm {
    public static void main(String[] args) {

        // 创建shiro的默认管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 设置匹配器
        CustomMd5Realm realm = new CustomMd5Realm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5"); // 设置加密策略为md5
        // 3. md5 +salt +hash 散列
        credentialsMatcher.setHashIterations(1024); // 设置散列次数
        realm.setCredentialsMatcher(credentialsMatcher);
        // 设置认证器
        securityManager.setRealm(realm);
        // 设置全局管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 获取主题对象
        Subject subject = SecurityUtils.getSubject();
        // 认证
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
        try {
            System.out.println("认证信息--->" + subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证信息--->" + subject.isAuthenticated());
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("认证失败：为获取到用户信息");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("认证失败: 密码不正确");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
