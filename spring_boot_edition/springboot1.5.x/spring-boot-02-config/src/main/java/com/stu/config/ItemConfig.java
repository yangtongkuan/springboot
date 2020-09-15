package com.stu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 14:24
 * @Classname: ItemConfig
 * @To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties
@Component
public class ItemConfig {
    @Value("${item.name}")
    private String name;
    @Value("${item.age}")
    private Integer age;

    public String getName() {
        return name;
    }

    public ItemConfig setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public ItemConfig setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "ItemConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

