package com.stu.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 16:13
 * @Classname: UserInfo
 * @To change this template use File | Settings | File Templates.
 */
public class UserInfo {
    private Long id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public UserInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserInfo setAge(Integer age) {
        this.age = age;
        return this;
    }
}
