package com.matcha.dao;

import com.matcha.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/9/23 23:50
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Mapper
public interface UserDAO {

    void save(User user);

    User findByUsername(String username);
}
