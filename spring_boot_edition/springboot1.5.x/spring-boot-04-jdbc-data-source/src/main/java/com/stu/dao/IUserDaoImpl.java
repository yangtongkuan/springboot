package com.stu.dao;

import com.stu.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
    /**
     * 在这里没有时@Qualifier 注解表明是哪个数据源的jdbcTemplate 是因为 在主的template上使用了 @Primary 注解
     * 表明在当有多个实现时, 会自动优先匹配到带@Primary 注解的jdbcTemplate 若都没有标@Primary 注解 并且不使用@Qualifier注解会报错
     * Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
     */

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondlyJdbcTemplate")
    private JdbcTemplate secondlyJdbcTemplate;

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

    // 使用第二个jdbcTemplate 查询数据模拟
    @Override
    public UserInfo findById(Long id) {
        List<UserInfo> list = secondlyJdbcTemplate.query("select * from userInfo where id = ?", new Object[]{id}, new BeanPropertyRowMapper(UserInfo.class));
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
