package com.matcha.service;

import com.matcha.dao.UserDAO;
import com.matcha.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserEntity> findById(String id) {
        return userDAO.findById(id);
    }

    @Override
    public void deleteById(String id) {
        userDAO.deleteById(id);
    }

    @Override
    public void update(UserEntity userEntity) {
        userDAO.update(userEntity);
    }

    @Override
    public void create(UserEntity userEntity) {
        userEntity.setId(UUID.randomUUID().toString());
        userDAO.create(userEntity);
    }
}
