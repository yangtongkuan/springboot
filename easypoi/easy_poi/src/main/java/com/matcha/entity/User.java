package com.matcha.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.google.common.collect.Ordering;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/25 21:12
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */

/**
 * 标注excel实体类
 */
@ExcelTarget(value = "users")
public class User implements Serializable {

    @Excel(name = "编号", orderNum = "0")
    private String id;
    @Excel(name = "姓名", orderNum = "1")
    private String name;
    @Excel(name = "年龄", orderNum = "2")
    private Integer age;
    @Excel(name = "生日", format = "yyyy-MM-dd", orderNum = "3", width = 30)
    private Date bir;
    @Excel(name = "状态", replace = {"正常_1", "锁定_0"}, orderNum = "4", isImportField = "true_st")
    private Integer status;
    @Excel(name = "头像", orderNum = "5", width = 25, type = 2)
    private String photo;
    @ExcelEntity()
    private Card card;

    @ExcelCollection(name = "订单列表", orderNum = "8") // 标识一对多的关系
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public User setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public User setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public User setCard(Card card) {
        this.card = card;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Date getBir() {
        return bir;
    }

    public User setBir(Date bir) {
        this.bir = bir;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public User setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
