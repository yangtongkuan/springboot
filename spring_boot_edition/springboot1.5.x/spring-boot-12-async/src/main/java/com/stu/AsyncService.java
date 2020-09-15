package com.stu;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class AsyncService {

    public void async() throws InterruptedException {
        System.out.println("ThreadName:" + Thread.currentThread().getName());
        Thread.sleep(1 * 1000L);
        // System.out.println(Thread.currentThread().getName() + "异步任务----->");
    }
}
