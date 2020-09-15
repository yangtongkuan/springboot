package com.stu.service;

import com.stu.dao.PersonMapper;
import com.stu.entity.Person;
import com.stu.entity.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
        return personMapper.searchByNameLike(name);
    }

    public Person getOne(Long id) {
        return personMapper.getOne(id);
    }

    public void addOne(Person p) {
        personMapper.insertOne(p);
    }

    public void updateOne(Person p) {
        personMapper.updateOne(p);
    }

    public void delete(Long id) {
        personMapper.deleteOne(id);
    }


}
