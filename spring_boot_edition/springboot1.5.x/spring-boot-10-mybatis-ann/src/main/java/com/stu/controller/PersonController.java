package com.stu.controller;

import com.stu.entity.Person;
import com.stu.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/8 22:36
 * @To change this template use File | Settings | File Templates.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService userService;

    /**
     * 查询所有的人
     *
     * @return
     */
    @RequestMapping("/person/list")
    public Object get() {
        return userService.queryAll();
    }

    @RequestMapping("/person/list/by-name")
    public Object searchByName(String name) {
        return userService.searchByName(name);
    }

    @RequestMapping("/person/get")
    public Object getOne(Long id) {
        return userService.getOne(id);
    }

    @RequestMapping("/person/add")
    public Object addOne(Person person) {
        userService.addOne(person);
        return person;
    }

    @RequestMapping("/person/update")
    public Object updateOne(Person person) {
        userService.updateOne(person);
        return userService.getOne(person.getId());
    }

    @RequestMapping("/person/del")
    public Object deleteOne(Long id) {
        userService.delete(id);
        return userService.queryAll();
    }

    @RequestMapping("/person/tran/test")
    public Object testTr(Long id) {
        try {
            userService.testTr(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userService.queryAll();
    }
}
