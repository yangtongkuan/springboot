package com.matcha.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/26 21:06
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@ExcelTarget("emps")
public class Emp implements Serializable {

    @Excel(name = "编号")
    private String id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "年龄")
    private Integer age;
    @Excel(name = "生日", format = "yyyy-MM-dd")
    private Date bir;
    @Excel(name = "状态", replace = {"激活_1", "锁定_0"})
    private Integer status;
//    @Excel(name = "头像", type = 2)
//    private String photo;


    public String getId() {
        return id;
    }

    public Emp setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Emp setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Emp setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Date getBir() {
        return bir;
    }

    public Emp setBir(Date bir) {
        this.bir = bir;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Emp setStatus(Integer status) {
        this.status = status;
        return this;
    }


    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                ", status=" + status +
                '}';
    }
}
