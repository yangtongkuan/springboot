package com.stu.bean.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/28
 * @To change this template use File | Settings | File Templates.
 */
//@ApiModel(value = "用户返回信息")
@Data
public class UserInfoVo {
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * @ApiModelProperty :
     * value 说明
     * required 是否必填
     * hidden 是否显示
     * example 示例
     * dataType 数据类型
     * notes 备注信息
     */
    @ApiModelProperty(value = "名称", notes = "名称note", required = true)
    private String name;
    @ApiModelProperty(value = "年龄", notes = "年龄note")
    private Integer age;
    @ApiModelProperty(value = "邮箱", notes = "邮箱note", required = true)
    private String email;
    @ApiModelProperty(value = "用户地址信息", notes = "用户地址信息note")
    private List<UserAddressVO> userAddressS; // 用户地址
}
