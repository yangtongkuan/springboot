package com.stu.controller;

import com.stu.serviice.UserService;
import com.stu.entity.UserEntity;
import com.stu.utils.EResultCode;
import com.stu.utils.R;
import com.stu.valid.AddGroup;
import com.stu.valid.ModifyGroup;
import com.stu.valid.ModifyStatusGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
@Slf4j
@Api(tags = "用户管理模块")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 创建用户
     * F1. 用户账号密码等信息需要程序自己验证 程序可读性查 代码冗余严重
     *
     * @param userEntity
     * @return
     */
    @ApiOperation(value = "创建用户-程序内验证")
    @PostMapping("/save")
    public R<UserEntity> user_auth1(@RequestBody UserEntity userEntity) {
        if (StringUtils.isEmpty(userEntity.getUsername())) {
            return R.fail(EResultCode.SUCCESS, "用户账号不能为空");
        }
        if (StringUtils.isEmpty(userEntity.getPwd())) {
            return R.fail(EResultCode.SUCCESS, "用户密码不能为空");
        }
        userEntity = userService.save(userEntity);
        return R.success(userEntity);
    }

    /**
     * 创建用户
     * F2. 使用JSR303效验器
     * 1). 实体类上标注注解  例如@NotBlank(message="用户")
     * 2). 入参处使用@valid注解 标注需要验证
     * 3). 在入参处声明BindingResult 对象 获取验证中的错误信息
     *
     * @param userEntity
     * @return
     */
    @ApiOperation(value = "创建用户-JSR303-BindingResult 绑定验证")
    @PostMapping("/save2")
    public R<Object> user_auth2(@RequestBody @Valid UserEntity userEntity, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach((item) -> {
                //FieldError 获取到错误提示
                String message = item.getDefaultMessage();
                //获取错误的属性的名字
                String field = item.getField();
                errorMap.put(field, message);
                log.error(field + ":" + message);
            });
            return R.fail(EResultCode.ERROR).setData(errorMap);
        }
        if (StringUtils.isEmpty(userEntity.getUsername())) {
            return R.fail(EResultCode.SUCCESS, "用户账号不能为空");
        }
        if (StringUtils.isEmpty(userEntity.getPwd())) {
            return R.fail(EResultCode.SUCCESS, "用户密码不能为空");
        }
        userEntity = userService.save(userEntity);
        return R.success(userEntity);
    }

    /**
     * 创建用户
     * 自定义全局异常模式
     * F3.
     * 1). 实体类上标注注解  例如@NotBlank(message="用户")
     * 2). 入参处使用@valid注解 标注需要验证
     * 3). 自定义全局异常 捕捉MethodArgumentNotValidException 异常
     *
     * @param userEntity
     * @return
     */
    @ApiOperation(value = "创建用户-JSR303-优雅的全局异常验证")
    @PostMapping("/save3")
    public R user_auth3(@RequestBody @Valid UserEntity userEntity) {
        userEntity = userService.save(userEntity);
        return R.success(userEntity);
    }

    /**
     * 创建用户
     * 0). 创建分组 interface AddGroup ModifyGroup.class
     * 1). 实体类上标注注解  例如@NotBlank(message="用户") 并标注分组 例如 group={AddGroup.class}
     * 2). 入参处使用@Validated() 标注 验证的分组即可
     * 3). 定义全局异常处理器
     * 特别注意  入参和实体的分组必须一致 如果不一致或缺少则不验证
     *
     * @param userEntity
     * @return
     */
    @ApiOperation(value = "创建用户-JSR303-复杂分组+全局异常验证")
    @PostMapping("/group/save1")
    public R user_create(@RequestBody @Validated(value = {AddGroup.class}) UserEntity userEntity) {
        userEntity = userService.save(userEntity);
        return R.success(userEntity);
    }

    /**
     * 修改用户 -- 修改用户必须有用户的id 而添加则不需要验证
     * 自定义多语言绑定异常数据返回
     *
     * @param userEntity
     * @return
     */
    @ApiOperation(value = "修改用户信息-JSR303-复杂分组+全局异常验证")
    @PostMapping("/group/modify")
    public R user_modify(@RequestBody @Validated({ModifyGroup.class}) UserEntity userEntity) {
        userEntity = userService.save(userEntity);
        return R.success(userEntity);
    }

    /**
     * 修改用户 修改用户的状态
     * 自定义注解  验证数据
     * 0). 自定义注解分组注解  并指定解析器
     * 0.1). 自定义注解解析类 实现接口 ConstraintValidator<ListValue, Integer>
     * 0.2). 创建对应注解分组 interface ModifyStatusGroup.class(根据需求来)
     * 1). 实体类上标注注解  例如@NotBlank(message="用户") 并标注分组 例如 group={AddGroup.class}
     * 2). 入参处使用@Validated() 标注 验证的分组即可
     * 3).
     *
     * @param userEntity
     * @return
     */
    @ApiOperation(value = "更新用户状态-JSR303-自定义注解验证")
    @PostMapping("/group/modify/status")
    public R user_modify_status(@RequestBody @Validated({ModifyStatusGroup.class}) UserEntity userEntity) {
        userEntity = userService.update(userEntity);
        return R.success(userEntity);
    }

}
