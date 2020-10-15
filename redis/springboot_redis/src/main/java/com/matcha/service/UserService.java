package com.matcha.service;

import com.matcha.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    List<UserEntity> findById(String id);

    void deleteById(String id);

    void update(UserEntity userEntity);

    void create(UserEntity userEntity);
}
