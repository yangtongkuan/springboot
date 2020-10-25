package com.matcha.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/25 21:29
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@ExcelTarget("cards")
public class Card implements Serializable {
    @Excel(name = "身份序号", width = 20, orderNum = "6")
    private String id;
    @Excel(name = "身份证姓名", orderNum = "7", width = 35)
    private String name;

    public Card() {
    }

    public Card(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Card setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Card setName(String name) {
        this.name = name;
        return this;
    }
}
