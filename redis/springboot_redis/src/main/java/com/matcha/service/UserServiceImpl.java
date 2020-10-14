package com.matcha.service;

import com.matcha.dao.UserDAO;
import com.matcha.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<UserEntity> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
