package com.matcha.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/25 21:49
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@ExcelTarget("orders")
public class Order implements Serializable {
    @Excel(name="订单编号",orderNum = "8",width = 20.0)
    private String no;
    @Excel(name="订单名称",orderNum = "9",width = 15.0)
    private String name;

    public String getNo() {
        return no;
    }

    public Order setNo(String no) {
        this.no = no;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }
}
