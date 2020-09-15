package com.stu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBoot03JdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot03JdbcApplication.class, args);
    }

}
