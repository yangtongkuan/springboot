package com.matcha.service;

import com.matcha.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    List<UserEntity> findById(Long id);

    void deleteById(Long id);
}
