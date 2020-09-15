package com.stu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 15:07
 * @Classname: Item3Config
 * @To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "item3")
@PropertySource("classpath:item3.properties")
@Component
public class Item3Config {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Item3Config{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public Item3Config setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Item3Config setAge(Integer age) {
        this.age = age;
        return this;
    }
}
