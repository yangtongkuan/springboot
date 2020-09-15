package com.stu.controller;

import com.stu.bean.Book;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/5 11:18
 * @To change this template use File | Settings | File Templates.
 */
@RestController
public class AmqpController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    // 使用AmqpAdmin 组件声明 queue,exchange,binding
    @RequestMapping("/amqp/assembly/declare")
    public Object amqp() {
        // 1. 声明一个exchange 交换器 a、direct(发布与订阅 完全匹配)。b、fanout(广播)。c、topic(主题，规则匹配)
        /** direct : 发布订阅模式 即点对点模式,路由完全匹配 DirectExchange
         *  fanout : 广播模式：发布到所有的队列,即无需路由 FanoutExchange
         *  topic：主题模式 (主题，规则匹配) 如 *.news amqp.# 匹配模式 TopicExchange
         */
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        amqpAdmin.declareExchange(new FanoutExchange("amqpadmin.fanout.exchange"));
        // 2. 声明一个队列 并声明持久化
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue2", true));
        // 3. 将交换器和队列绑定 将上述声明队列和交换器绑定按照一定的规则绑定  fanout 模式中 “*”用于匹配一个单词，“#”用于匹配多个单词（可以是零个）
//        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.news", null));

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.fanout.exchange", "*.news", null));
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue2", Binding.DestinationType.QUEUE, "amqpadmin.fanout.exchange", "amqpadmin.#", null));
        return "ok".toString();
    }

    // 使用AmqpAdmin 组件删除 queue,exchange,binding
    @RequestMapping("/amqp/assembly/del")
    public Object amqp_del() {
        // 1.删除交换器
        amqpAdmin.deleteExchange("amqpadmin.fanout.exchange");
        // 2.删除队列
//        amqpAdmin.deleteQueue("amqpadmin.queue");
        // 3. 删除队列
        amqpAdmin.removeBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.fanout.exchange", "*.news", null));
        amqpAdmin.removeBinding(new Binding("amqpadmin.queue2", Binding.DestinationType.QUEUE, "amqpadmin.fanout.exchange", "amqpadmin.#", null));
        return "ok".toString();
    }

    // - 消息发布 -点对点消息发布
    @RequestMapping("/amqp/message/send")
    public Object amqp_send(String name, String author) {
        Book book = new Book(name, author);
        rabbitTemplate.convertAndSend("amqpadmin.exchange", "amqp.news", book);
        return "ok".toString();
    }

    // - 消息发布 -发布订阅消息发布
    @RequestMapping("/amqp/fanout/message/send")
    public Object amqp_fanout_send(String name, String author) {
        Book book = new Book(name, author);
        rabbitTemplate.convertAndSend("amqpadmin.fanout.exchange", "amqp.news", book);
        return "ok".toString();
    }

    // 接收消息
    @RequestMapping("/amqp/message/receive")
    public Object message_receive(String queues) {
        if (queues == null || queues == "") {
            queues = "amqpadmin.queue";
        }
        Book book = (Book) rabbitTemplate.receiveAndConvert(queues);
        return book;
    }


}
