package com.stu.dao;

import com.stu.entity.UserInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 16:15
 * @Classname: IUserDaoImpl
 * @To change this template use File | Settings | File Templates.
 */
@Repository
public class IUserDaoImpl implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(UserInfo userInfo) {
        return jdbcTemplate.update("insert into userinfo(name,age) value (?,?)", userInfo.getName(), userInfo.getAge());
    }

    @Override
    public int update(UserInfo userInfo) {
        return jdbcTemplate.update("update  userinfo set name=? ,age = ? where id =?", userInfo.getName(), userInfo.getAge(), userInfo.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from  userinfo where id =?", id);
    }

    @Override
    public UserInfo findById(Long id) {
        List<UserInfo> list = jdbcTemplate.query("select * from userInfo where id = ?", new Object[]{id}, new BeanPropertyRowMapper(UserInfo.class));
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<UserInfo> findByName(String name) {
        return jdbcTemplate.query("select * from userInfo where name like ? ", new Object[]{"%" + name + "%"}, new BeanPropertyRowMapper(UserInfo.class));
    }
}
