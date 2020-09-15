package com.stu.controller.template;

import com.stu.entity.VerifyCodeInfo;
import com.stu.service.template.IVerifyMongoTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/1/5 16:09
 * @To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/template")
public class VerifyMongoTemplateController {

    @Autowired
    private IVerifyMongoTemplateService verifyService;

    @RequestMapping("/verify/save")
    public Object save(@RequestParam String username) {
        VerifyCodeInfo code = new VerifyCodeInfo();
        code.setId(1L);
        code.setCreateTime(new Date());
        code.setTelCode("123456");
        code.setUsername(username);
        code.setVerifyType("register");
        code.setExpireTime(new Date(System.currentTimeMillis() + 10 * 60 * 1000L));
        verifyService.save(code);
        return code;
    }

    @RequestMapping("/verify/del")
    public Object del(@RequestParam Long id) {
        return verifyService.del(id);
    }

    @RequestMapping("/verify/find")
    public Object find(@RequestParam String username, String verifyType) {
        return verifyService.findByUsernameAndVerifyType(username, verifyType);
    }

    @RequestMapping("/verify/username")
    public Object verify(String username, String verifyType) {
        try {
            verifyService.verify(username, verifyType);
        } catch (Exception e) {

        }
        return verifyService.findByUsernameAndVerifyType(username, verifyType);
    }
}
