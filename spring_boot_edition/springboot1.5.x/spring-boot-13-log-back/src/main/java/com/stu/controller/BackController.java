package com.stu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/27 19:01
 * @To change this template use File | Settings | File Templates.
 */
@RestController
public class BackController {

    private Logger log = LoggerFactory.getLogger(BackController.class);

    @RequestMapping("/back/info")
    public Object backInfo() {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            log.trace("这是------>trance");
            log.debug("这是------>debug");
            log.info("这是------>info");
            log.warn("这是------>warn");
            log.error("这是------>error");
        }
        long endTime2 = System.currentTimeMillis();
        // 在没有使用异步日志数据的时候,第二段时间实际打打印时间为45963毫秒  可以看出 大量的io操作 会导致程序性能降低
        // 使用异步日志数据后,第二段时间实际打打印时间为3584毫秒  是原先的30倍左右
        log.info("第二时间段为----:{}毫秒", (endTime2 - startTime));
        return "ok";
    }
}
