package com.matcha;

import com.matcha.entity.UserEntity;
import com.matcha.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;
import java.util.UUID;

@SpringBootTest(classes = SpringbootRedisApplication.class)
class SpringbootRedisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private UserService userService;

    @Test
    public void testObj() {
        // 序列化
        StringRedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);


        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setAge(23);
        entity.setName("matcha");
//        redisTemplate.opsForValue().set("user", entity);
//        System.out.println(redisTemplate.opsForValue().get("user").toString());
        redisTemplate.opsForHash().put("map", "user", entity);
    }


    // 测试查询
    @Test
    public void testSelect() {
        List<UserEntity> serviceAll = userService.findAll();
        serviceAll.forEach(item -> System.out.println(item));
        System.out.println("=====================================================");
        List<UserEntity> userEntities = userService.findAll();
        userEntities.forEach(item -> System.out.println(item));
    }


}
