package com.matcha.cache;

import com.matcha.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/10/14 22:51
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
public class RedisCache implements Cache {

    private final String id;

    //必须存在构造方法
    public RedisCache(String id) {
        System.out.println("cache:id:=====================> " + id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        getRedisTemplate().opsForHash().put(id.toString(), key.toString(), value);
    }

    @Override
    public Object getObject(Object key) {
        //根据key 从redis的hash类型中获取数据
        return getRedisTemplate().opsForHash().get(id.toString(), key.toString());
    }

    //注意:这个方法为mybatis保留方法 默认没有实现 后续版本可能会实现
    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {
        //清空namespace
        System.out.println("清空缓存~~~");
        getRedisTemplate().opsForHash().delete(id.toString());
    }

    @Override
    public int getSize() {
        return 0;
    }

    RedisTemplate getRedisTemplate() {
        RedisTemplate template = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        return template;
    }
}
