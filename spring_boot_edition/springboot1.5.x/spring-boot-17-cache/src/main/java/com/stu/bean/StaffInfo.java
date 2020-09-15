package com.stu.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/18 12:04
 * @To change this template use File | Settings | File Templates.
 */
public class StaffInfo implements Serializable {
    private Long id;
    private String lastName;
    private String email;
    private Integer gender; //性别 1男  0女
    private Long dId;

    public Long getdId() {
        return dId;
    }

    public StaffInfo setdId(Long dId) {
        this.dId = dId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public StaffInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public StaffInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StaffInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public StaffInfo setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

}
