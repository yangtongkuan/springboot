package com.matcha.dao;

import com.matcha.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/26 22:12
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Mapper
public interface UserDao {

    List<User> findAll();

    void insert(User user);

}
