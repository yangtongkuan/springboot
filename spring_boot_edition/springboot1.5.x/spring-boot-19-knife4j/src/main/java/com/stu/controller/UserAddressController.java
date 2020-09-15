package com.stu.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/28
 * @To change this template use File | Settings | File Templates.
 */
@Api(value = "用户地址管理",tags = "用户地址管理2")
@ApiSort(2)
@RestController
public class UserAddressController {

    @GetMapping("/user/address/get")
    @ApiOperation("获取用户地址详情")
    public String userAddressGet() {
        return "获取地址成功";
    }
}
