package com.stu.controller.mongo;

import com.stu.entity.UserTokenInfo;
import com.stu.service.mongo.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @Autowired
    private UserTokenService userTokenService;

    // 添加
    @RequestMapping("/token/create")
    public Object userToken(@RequestParam(name = "user_id") Long userId) {
        UserTokenInfo userTokenInfo = userTokenService.createToken(userId);
        return userTokenInfo;

    }

    // get
    @RequestMapping("/token/get")
    public Object getToken(String token) {
        UserTokenInfo info = userTokenService.getByToken(token);
        // 获取用户信息等
        return info;
    }

    // 强制某个用户token失效
    @RequestMapping("/token/del")
    public Object delToken(@RequestParam("token_id") Long tokenId) {
        userTokenService.del(tokenId);
        return "强制下线成功";
    }

    @RequestMapping("/token/user-id")
    public Object listOfUserId(@RequestParam(name = "user_id") Long userId) {
        return userTokenService.listOfUserId(userId);
    }


}
