package com.stu.service;

import com.stu.entity.UserInfo;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 18:18
 * @Classname: IUserService
 * @To change this template use File | Settings | File Templates.
 */
public interface IUserService {
    UserInfo add(UserInfo user);

    UserInfo update(UserInfo userInfo) throws Exception;

    void del(Long id);

    UserInfo findById(Long id);

    List<UserInfo> fingByName(String name, int page, int size);

}
