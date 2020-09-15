package com.stu.service;

import com.stu.dao.IUserDao;
import com.stu.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 16:41
 * @Classname: UserServiceImpl
 * @To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int add(UserInfo userInfo) {
        if (userInfo != null) {
            return userDao.add(userInfo);
        }
        return 0;
    }

    @Override
    public int update(UserInfo userInfo) {
        if (userInfo != null) {
            return userDao.update(userInfo);
        }
        return 0;
    }

    @Override
    public int delete(Long id) {
        if (id != null && id > 0) {
            return userDao.delete(id);
        }
        return 0;
    }

    @Override
    public UserInfo findById(Long id) {
        if (id != null && id > 0) {
            return userDao.findById(id);
        }
        return null;
    }

    @Override
    public List<UserInfo> findByName(String name) {
        if (name == null) {
            name = "";
        }
        return userDao.findByName(name);
    }
}
