package com.stu.controller;

import com.stu.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    /**
     * @param count
     * @return
     * @desc 并发模拟-线程池
     */
    @RequestMapping("async")
    public Object async(Integer count) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        asyncService.async();
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        // asyncService.async();
        countDownLatch.countDown();
        return "ok";
    }

}
