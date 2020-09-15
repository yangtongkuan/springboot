package com.stu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时执行任务
public class SpringBoot11ScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot11ScheduleApplication.class, args);
    }

}
