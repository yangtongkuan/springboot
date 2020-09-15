package com.stu.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/2 12:36
 * @To change this template use File | Settings | File Templates.
 * @desc:
 */
@Configuration
public class AMQPConfig {
    /**
     * @desc 数据转换控制器
     *      amqp 数据转换配置  替代默认的jdk 使用json将数据转化
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
