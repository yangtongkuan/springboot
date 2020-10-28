package com.matcha.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/26 22:12
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@ExcelTarget("users")
@Data
public class User implements Serializable {
    @Excel(name = "编号")
    private String id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "生日", format = "yyyy年MM月dd日", width = 15.0)
    private Date bir;
    @Excel(name = "爱好", width = 30.0)
    private String habbys;
    @Excel(name = "头像信息", width = 15, type = 2, savePath = "F:\\study\\springboot\\easypoi\\easypoi_springboot\\src\\main\\resources\\static\\imges")
    private String photo;
    @Excel(name = "身份证号", width = 30.0)
    private String no;
    @Excel(name = "家庭住址", width = 30.0)
    private String address;
}
