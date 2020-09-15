package com.stu.controller;

import com.stu.config.Item2Config;
import com.stu.config.Item3Config;
import com.stu.config.ItemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 14:27
 * @Classname: ItemConfigController
 * @To change this template use File | Settings | File Templates.
 */

@RestController
public class ItemConfigController {
    @Autowired
    private ItemConfig itemConfig;
    @Autowired
    private Item2Config itemConfig2;
    @Autowired
    private Item3Config itemConfig3;

    // 1.使用@vaule 注解
    @RequestMapping("/item")
    public Object getItem() {
        return itemConfig.toString();
    }

    // 2.使用@ConfigurationProperties  直接注入整个类
    @RequestMapping("/item2")
    public Object getItem2() {
        return itemConfig2.toString();
    }

    // 3.使用外部的.properties文件注入
    @RequestMapping("/item3")
    public Object getItem3() {
        return itemConfig3.toString();
    }
}
