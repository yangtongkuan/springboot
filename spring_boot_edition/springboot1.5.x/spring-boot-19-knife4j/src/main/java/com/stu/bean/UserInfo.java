package com.stu.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/28
 * @To change this template use File | Settings | File Templates.
 */
@Data
@ApiModel("用户信息db")
public class UserInfo implements Serializable {

    @ApiModelProperty(value = "id", hidden = true)
    private Long id;
    @ApiModelProperty(value = "名称", notes = "名称note", required = true)
    private String name;
    @ApiModelProperty(value = "年龄", notes = "年龄note")
    private Integer age;
    @ApiModelProperty(value = "邮箱", notes = "邮箱note", required = true)
    private String email;
}
