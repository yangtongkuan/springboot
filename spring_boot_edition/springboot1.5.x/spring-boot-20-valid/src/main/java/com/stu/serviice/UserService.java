package com.stu.serviice;

import com.stu.dao.UserDao;
import com.stu.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 */
@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public UserEntity save(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    public UserEntity update(UserEntity userEntity) {
        UserEntity entity = userDao.findOne(userEntity.getUserId());
        if (entity != null) {
            userDao.save(userEntity);
        }
        return userEntity;
    }

}
