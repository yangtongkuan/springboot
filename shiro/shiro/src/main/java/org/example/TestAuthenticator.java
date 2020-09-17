package org.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/9/17 22:24
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */

import jdk.nashorn.internal.runtime.ECMAErrors;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * shiro认证器
 */
public class TestAuthenticator {

    public static void main(String[] args) {
        // 1. 首先创建默认的shiro管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 2. 设置认证器
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        // 3. 工具类设置全局默认的管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 4. 获取认证主题
        Subject subject = SecurityUtils.getSubject();
        // 5.封装 用户认证信息 principal(身份信息) 和 credential(凭证信息)
        UsernamePasswordToken passwordToken = new UsernamePasswordToken("zhangsan", "12");
        // 6. 认证
        try {
            System.out.println("认证信息：" + subject.isAuthenticated());
            subject.login(passwordToken);
            System.out.println("认证信息：" + subject.isAuthenticated());
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
