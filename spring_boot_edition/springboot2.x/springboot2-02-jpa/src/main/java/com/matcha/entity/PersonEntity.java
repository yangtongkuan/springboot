package com.matcha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String sex;

    public Long getId() {
        return id;
    }

    public PersonEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public PersonEntity setSex(String sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
