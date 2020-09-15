package com.stu.config;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 15:02
 * @Classname: GirlFriend
 * @To change this template use File | Settings | File Templates.
 */
public class GirlFriend {
    private  String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public GirlFriend setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public GirlFriend setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
