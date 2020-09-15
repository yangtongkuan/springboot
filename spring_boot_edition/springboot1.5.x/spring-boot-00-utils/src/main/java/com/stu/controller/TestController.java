package com.stu.controller;

import com.stu.util.response.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/26 11:58
 * @To change this template use File | Settings | File Templates.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public R test() {
        return R.success("ok");
    }
}
