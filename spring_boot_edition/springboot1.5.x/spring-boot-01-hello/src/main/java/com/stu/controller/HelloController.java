package com.stu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/12/31 14:16
 * @Classname: HelloController
 * @To change this template use File | Settings | File Templates.
 */
// 注入springioc
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public Object sayHello(String name) {
        return "hello " + name + "!!!";
    }

}
