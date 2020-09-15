package com.stu.service;

import com.stu.dao.PersonMapper;
import com.stu.entity.Person;
import com.stu.entity.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/8 21:53
 * @To change this template use File | Settings | File Templates.
 */
@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public List<Person> queryAll() {
        return personMapper.queryAll();
    }

    /**
     * @param name
     * @return
     * @desc 通过名字模糊查询
     */
    public List<Person> searchByName(String name) {
        // 方式 1
        //        return personMapper.searchByNameLike(name);
        // 方式 2  使用mybatis provider 注解
        return personMapper.search(name, 10);
    }

    public Person getOne(Long id) {
        return personMapper.getOne(id);
    }

    public void addOne(Person p) {
//        personMapper.insertOne(p);
        System.out.println(personMapper.insert(p));
    }

    public void updateOne(Person p) {
        int result = personMapper.updateOne(p);
        System.out.println("更新条数--->" + result);
    }

    public void delete(Long id) {
        // 方式 1 注解
//        personMapper.deleteOne(id);
        // 方式 2 provider
        int result = personMapper.del(id);
        System.out.println("删除--->" + result);
    }

    @Transactional
    public void testTr(Long id) {
        personMapper.deleteOne(id);
        int i = 1 / 0;
        Person p = new Person();
        p.setAge(11).setLastName("test").setSex(Sex.WOMAN).setName("test");
        personMapper.insertOne(p);
    }
}
