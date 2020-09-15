package com.stu.controller;

import com.stu.bean.StaffInfo;
import com.stu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/18 11:53
 * @To change this template use File | Settings | File Templates.
 */
@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/staff/test")
    public Object get() {
        return redisTemplate.opsForValue().get("staff.staff:1");
    }

    // 查询
    @GetMapping("/staff/{id}")
    public Object getStaff(@PathVariable("id") Long id) {
        return staffService.getStaff(id);
    }

    @PostMapping("/staff/update")
    //@RequestBody 当传入的是json数据时  使用@RequestBody
    public Object updateStaff(StaffInfo info) {
        System.out.println(info.toString());
        return staffService.updateStaff(info);
    }

    // del
    @PostMapping("/staff/del")
    public Object delStaff(@RequestParam Long id) {
        staffService.delStaff(id);
        return "success";
    }

    @PostMapping("/staff/search/last_name")
    public Object searchLastName(@RequestParam String lastName) {
        return staffService.searchLastName(lastName);
    }


}
