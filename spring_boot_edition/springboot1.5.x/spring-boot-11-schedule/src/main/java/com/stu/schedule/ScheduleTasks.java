package com.stu.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleTasks {

    /**
     * fixedRate 和 fixedDelay 的区别
     * fixedRate: 上一次执行开始时间到本次执行的开始时间-时间差
     * fixedDelay: 上一次执行结束时间到本次执行的开始时间-时间差
     */
    // fixedRate
    // @Scheduled(fixedRate = 5 * 1000L)
    public void fixedRate() {
        try {
            System.out.println("北京时间---fixedRate--->" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            Thread.sleep(1 * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @Scheduled(fixedDelay = 5 * 1000L)
    public void fixedDelay() {
        try {
            System.out.println("北京时间---fixedDelay--->" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            Thread.sleep(1 * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @Scheduled(initialDelay = 1 * 1000L, fixedDelay = 5 * 1000L)
    public void initialDelay() {
        try {
            System.out.println("北京时间---initialDelay---fixedDelay--->" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            Thread.sleep(1 * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 秒-分-时-日-月-年 每隔5秒执行一次
    @Scheduled(cron = "*/5 * * * * *")
    public void cron() {
        System.out.println("北京时间---Scheduled---cron--->" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
