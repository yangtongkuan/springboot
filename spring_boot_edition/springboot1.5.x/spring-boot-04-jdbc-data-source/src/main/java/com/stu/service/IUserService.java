package com.stu.service;

import com.stu.entity.UserInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 16:14
 * @Classname: IUserService
 * @To change this template use File | Settings | File Templates.
 */
public interface IUserService {

    int add(UserInfo userInfo);

    int update(UserInfo userInfo);

    int delete(Long id);

    UserInfo findById(Long id);

    List<UserInfo> findByName(String name);
}
