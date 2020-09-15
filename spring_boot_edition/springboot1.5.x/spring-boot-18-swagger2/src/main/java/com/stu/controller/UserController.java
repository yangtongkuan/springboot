package com.stu.controller;

import com.stu.bean.UserInfo;
import com.stu.utils.EResultCode;
import com.stu.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/26 12:31
 * @To change this template use File | Settings | File Templates.
 */
@RestController
@Api(description = "用户操作控制类", tags = {"用户控制"})
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public String test() {
        return "ok222";
    }

    /**
     * 返回信息必须指明返回的是什么信息  否则注释不出来
     *
     * @return
     */
    @ApiOperation("获取用户信息")
    @PostMapping("/user")
    public R<UserInfo> userInfo(UserInfo user) {
        return R.success(user);
    }

    /**
     * @param name
     * @return
     * @ApiOperation 在方法上  说明该方法是干什么用的
     * @ApiParam("用户名") 作用在方法上  说明参数的意义
     */
    @ApiOperation("hello controller2")
    @GetMapping(value = "/hello")
    public String hello(@ApiParam("用户名") String name) {
        return "hello" + name;
    }

    @GetMapping("/user/test")
    public Object get(UserInfo userInfo) {
        return userInfo;
    }
}
