package com.stu;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot  自动配置
 * 1. RabbitAutoConfiguration
 * 2. 有自动配置了连接工厂 (ConnectionFactory)
 * 3. RabbitProperties中封装了 RabbitMQ的配置
 * 4. RabbitTemplate : 给rabbitmq发送和接受消息;
 * 5. AmqpAdmin:RabbitMQ系统管理功能组件
 *      AmqpAdmin：创建和删除queue , exchange , binding
 * 6. @EnableRabbit + @RabbitListener 监听消息队列中的消息内容
 */
@SpringBootApplication
@EnableRabbit // 开启基于注解的 rabbitmq
public class SpringBoot15RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot15RabbitmqApplication.class, args);
    }

}
