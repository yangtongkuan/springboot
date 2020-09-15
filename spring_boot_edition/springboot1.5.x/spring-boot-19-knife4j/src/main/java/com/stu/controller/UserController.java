package com.stu.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.stu.bean.UserInfo;
import com.stu.bean.VO.UserInfoVo;
import com.stu.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/28 11:57
 * @To change this template use File | Settings | File Templates.
 */

/**
 * @Api tags 标签
 * @ApiSort 接口文档排序  值越大 越在上面
 */
@RestController
@Api(tags = "用户管理模块")
@ApiSort(1)
public class UserController {

    @GetMapping("/user/get")
    @ApiOperation(value = "用户测试信息")
    public R<UserInfoVo> user(UserInfo userInfo) {
        UserInfoVo vo = new UserInfoVo();
        BeanUtils.copyProperties(userInfo, vo);
        return R.success(vo);
    }
}
