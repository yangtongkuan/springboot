package com.stu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步任务线程池
 */
@EnableAsync
@Configuration // 表示为配置类
public class AsyncConfig {
    /**
     *   默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，
     *	当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
     *  当队列满了，就继续创建线程，当线程数量大于等于maxPoolSize后，开始使用拒绝策略拒绝
     *  注意事项：
     * 如下方式会使@Async失效
     * 一、异步方法使用static修饰
     * 二、异步类没有使用@Component注解（或其他注解）导致spring无法扫描到异步类
     * 三、异步方法不能与被调用的异步方法在同一个类中
     * 四、类中需要使用@Autowired或@Resource等注解自动注入，不能自己手动new对象
     * 五、如果使用SpringBoot框架必须在启动类中增加@EnableAsync注解
     */

    /**
     * @return
     * @desc: 配置异步任务线程池
     * @de : 默认使用 --> springboot 默认是实现了 SimpleAsyncTaskExecutor 的线程池
     */
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);      // 线程池创建时初始化的线程数
        executor.setMaxPoolSize(50);       // 线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setQueueCapacity(100);    // 用来缓冲执行任务的队列
        executor.setKeepAliveSeconds(60);  // 超过了核心线程数之外的线程，在空闲时间到达之后会被销毁 单位秒
        executor.setWaitForTasksToCompleteOnShutdown(true); // 设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setAwaitTerminationSeconds(60); // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 当线程池没有处理能力的时候，该策略会直接在execute方法的调用线程中运行被拒绝的任务；如果执行程序已被关闭，则会丢弃该任务
        executor.setThreadNamePrefix("asyncExecutor-");  // 设置线程前缀名
        executor.initialize(); // 初始化
        return executor;
    }

}
