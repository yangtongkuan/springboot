package com.stu;

import com.rabbitmq.client.AMQP;
import com.stu.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot15RabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.haha", null));
        System.out.println("创建完成");
    }

    /**
     * 单播:点对点
     */
    @Test
    public void contextLoads() {
        // 1.message 可以定制消息内容和消息头
        // rabbitTemplate.send(exchange,routeKey,message);
        // 2.object 默认当成消息体,只需要传入发送对对象,自动序列化发给rabbitmq;
//        rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是一个消息");
        map.put("data", Arrays.asList("helloword", 123, true));
        // 对象被默认序列化以后发送出去
//        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", map);
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("西游记", "吴承恩"));
    }

    // 接受数据,如何将数据自动转化为json发送出去

    @Test
    public void receive() {
        Book book = (Book) rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(book.toString());
    }

    /**
     * 广播模式
     */
    @Test
    public void send() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("水浒传", "罗贯中"));
    }
}
