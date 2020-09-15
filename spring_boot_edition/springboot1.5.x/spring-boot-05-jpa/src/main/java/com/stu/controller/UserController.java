package com.stu.controller;

import com.stu.entity.UserInfo;
import com.stu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.event.PrintJobAttributeEvent;
import java.security.PublicKey;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 18:17
 * @Classname: UserController
 * @To change this template use File | Settings | File Templates.
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user/add")
    public Object add(UserInfo userInfo) {
        userInfo.setId(null);
        return userService.add(userInfo);
    }

    @RequestMapping("/user/del")
    public Object del(@RequestParam(required = true, name = "user_id") Long id) {
        userService.del(id);
        return "ok";
    }

    @RequestMapping("/user/update")
    public Object update(UserInfo userInfo) {
        try {
            return userService.update(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/user/find")
    public Object find(@RequestParam(name = "user_id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping("/user/list")
    public Object listOfName(@RequestParam String name, Integer page, Integer size) {
        return userService.fingByName(name, page, size);
    }
}
