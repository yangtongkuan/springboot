package com.matcha.service;

import com.matcha.dao.UserDao;
import com.matcha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/26 22:18
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveList(List<User> users) {
        users.forEach(item -> {
            item.setId(null);
            if (item.getPhoto() != null) {
                // 使用下面的切片方法解决windows下不能切片问题 File.separator 在windows表现为\\ 在linux下表现为\
                String fileName = item.getPhoto().substring(item.getPhoto().lastIndexOf(File.separator) + 1);
                item.setPhoto(fileName);
//                item.setPhoto(item.getPhoto().substring(item.getPhoto().lastIndexOf("/") + 1));
                userDao.insert(item);
            }
        });
    }
}
