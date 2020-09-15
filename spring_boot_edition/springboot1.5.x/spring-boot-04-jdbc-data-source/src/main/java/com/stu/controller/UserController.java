package com.stu.controller;

import com.stu.entity.UserInfo;
import com.stu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 16:46
 * @Classname: UserController
 * @To change this template use File | Settings | File Templates.
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    // 添加
    @RequestMapping("/add")
    public Object add(UserInfo userInfo) {
        int result = userService.add(userInfo);
        if (result > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @RequestMapping("del")
    @Transactional // 使用事务
    public Object del(@RequestParam(name = "user_id", required = true) Long id) {
        if (id <= 0) {
            return "删除失败";
        }
//        return userService.delete(id) > 0 ? "成功" : "失败";
        // 测试事务
        userService.delete(id);
        int a = 1 / 0;
        //
        return "成功";
    }

    @RequestMapping("update")
    public Object update(UserInfo user) {
        if (user.getId() == null || user.getId() <= 0) {
            return "更新失败";
        }
        return userService.update(user) > 0 ? "成功" : "失败";
    }

    @RequestMapping("find")
    public Object find(@RequestParam(name = "user_id", required = true) Long id) {
        if (id <= 0) {
            return "id不能为空";
        }
        return userService.findById(id);
    }

    @RequestMapping("find/name")
    public Object find_name(@RequestParam(name = "name", required = true) String name) {
        return userService.findByName(name);
    }
}
