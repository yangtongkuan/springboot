package com.stu.dao;

import com.stu.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
@Repository
public interface PersonMapper {

    List<Person> queryAll();

    List<Person> searchByNameLike(@Param("name") String name);

    Person getOne(Long id);

    void insertOne(Person p);

    void updateOne(Person p);

    void deleteOne(Long id);
}
