package org.example.md5;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 测试 shiro 的md5
 */
public class TestShiroMD5 {

    public static void main(String[] args) {
        // md5
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex());

        // md5(pwd+salt)
        Md5Hash md5Hash1 = new Md5Hash("123", "qps");
        System.out.println(md5Hash1.toHex());

        // md5 + salt + hash 散列
        Md5Hash md5Hash2 = new Md5Hash("123", "qps", 1024);
        System.out.println(md5Hash2.toHex());
    }
}
