package com.matcha.service;

import com.matcha.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/26 22:17
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
public interface UserService {
    List<User> findAll();

    void saveList(List<User> users);
}
