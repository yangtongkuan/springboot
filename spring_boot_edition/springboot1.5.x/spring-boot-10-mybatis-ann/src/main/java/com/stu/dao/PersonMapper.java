package com.stu.dao;

import com.stu.entity.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/8 21:53
 * @To change this template use File | Settings | File Templates.
 */
@Mapper
public interface PersonMapper {

    @Select("select * from t_person")
    @Results({
            @Result(column = "last_name", property = "lastName")
    })
    List<Person> queryAll();

    @Select("select * from t_person where name like  CONCAT('%',#{name},'%')")
    @Results({
            @Result(column = "last_name", property = "lastName")
    })
    List<Person> searchByNameLike(@Param("name") String name);

    @Select("select * from t_person where id = #{id}")
    Person getOne(Long id);

    @Insert("insert into t_person(name,age,sex,last_name) values (#{name},#{age},#{sex},#{lastName})")
    void insertOne(Person p);

    // 使用provider 动态构建 sql
    @UpdateProvider(type = PersonMapperProvider.class, method = "getUpdateOneSql")
    int updateOne(Person p);

    @Delete("delete from t_person where id = #{id}")
    void deleteOne(Long id);

    // ---------------- mybatis provider -----------------

    // 增加
    @InsertProvider(type = PersonMapperProvider.class, method = "getInsertSql")
    int insert(Person person);

    // 删除
    @DeleteProvider(type = PersonMapperProvider.class, method = "getDelSql")
    int del(Long id);

    //查询
    @SelectProvider(type = PersonMapperProvider.class, method = "getSelectSql")
    List<Person> search(@Param("name") String name, @Param("age") Integer age);


}
