package com.stu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 使用 mapperScan 或者 在maper上标注@Mapper
// @MapperScan(value = "com.stu.dao")
public class SpringBoot09MybatisXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot09MybatisXmlApplication.class, args);
    }

}
