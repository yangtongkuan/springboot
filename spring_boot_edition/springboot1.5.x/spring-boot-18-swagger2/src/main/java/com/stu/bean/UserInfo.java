package com.stu.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/26 12:33
 * @To change this template use File | Settings | File Templates.
 */
@Data
@Accessors(chain = true)
@ApiModel("用户信息表")
public class UserInfo implements Serializable {

    @ApiModelProperty(value = "用户标识id", dataType = "long")
    private Long id;
    @ApiModelProperty("用户名称")
    private String name;
    @ApiModelProperty("用户年龄")
    private Integer age;


}
