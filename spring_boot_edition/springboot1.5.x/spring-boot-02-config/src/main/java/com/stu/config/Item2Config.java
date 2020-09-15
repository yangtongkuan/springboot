package com.stu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 14:38
 * @Classname: Item2Config
 * @To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "item2")
@Component
public class Item2Config {
    private String name;
    private String age;
    private Set<String> girls;
    private Map<String, Object> map;
    private GirlFriend girl;

    public GirlFriend getGirl() {
        return girl;
    }

    public Item2Config setGirl(GirlFriend girl) {
        this.girl = girl;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item2Config setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Item2Config setAge(String age) {
        this.age = age;
        return this;
    }

    public Set<String> getGirls() {
        return girls;
    }

    public Item2Config setGirls(Set<String> girls) {
        this.girls = girls;
        return this;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Item2Config setMap(Map<String, Object> map) {
        this.map = map;
        return this;
    }

    @Override
    public String toString() {
        return "Item2Config{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", girls=" + girls +
                ", map=" + map +
                ", girl=" + girl +
                '}';
    }
}
