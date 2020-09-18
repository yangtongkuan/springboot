package org.example.custom;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * 测试自定义的realm
 */
public class TestCustomRealmAuthenticator {

    public static void main(String[] args) {
        // 获取认证管理
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 设置认证器
        securityManager.setRealm(new CustomRealm());
        // 设置全局的认证器;
        SecurityUtils.setSecurityManager(securityManager);
        // 获取主题
        Subject subject = SecurityUtils.getSubject();
        // 创建用户的身份和凭证信息
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
        // 认证
        try {
            System.out.println("认证信息:" + subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证信息:" + subject.isAuthenticated());
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
