package com.matcha.dao;

import com.matcha.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserDAO {

    List<UserEntity> findAll();

    List<UserEntity> findById(String id);

    void deleteById(String id);

    void update(UserEntity user);

    void create(UserEntity userEntity);

}
