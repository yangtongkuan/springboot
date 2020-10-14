package com.matcha.dao;

import com.matcha.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserDAO {

    List<UserEntity> findAll();

    List<UserEntity> findById(Long id);

    void deleteById(Long id);

}
