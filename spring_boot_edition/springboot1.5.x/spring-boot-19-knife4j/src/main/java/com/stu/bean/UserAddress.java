package com.stu.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javafx.scene.control.Tab;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/28
 * @To change this template use File | Settings | File Templates.
 */
@ApiModel(value = "用户地址db信息")
@Data
public class UserAddress {

    @ApiModelProperty(value = "地址唯一标识", name = "地址唯一标识名字", hidden = true)
    private Long id;
    @ApiModelProperty(value = "省", name = "省名字", required = true)
    private String prov;
    @ApiModelProperty(value = "市", name = "市名字", required = true)
    private String city;
    @ApiModelProperty(value = "区", name = "区名字")
    private String country;
    @ApiModelProperty(value = "详细地址", name = "详细地址名字")
    private String address;
}
