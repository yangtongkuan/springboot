package com.matcha;

import com.matcha.entity.UserEntity;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.UUID;

@SpringBootTest(classes = SpringbootRedisApplication.class)
class SpringbootRedisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testObj() {
        // 序列化
        StringRedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);


        UserEntity entity = new UserEntity();
        entity.setUserId(UUID.randomUUID().toString());
        entity.setAge(23);
        entity.setName("matcha");
//        redisTemplate.opsForValue().set("user", entity);
//        System.out.println(redisTemplate.opsForValue().get("user").toString());
        redisTemplate.opsForHash().put("map", "user", entity);
    }

}
