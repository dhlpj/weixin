package com.pj.weixin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author Jack
 * @create 2018-11-09 16:34
 */
public class RedisDao {
    @Autowired
    private StringRedisTemplate redisTemplate;
    public String get(String key){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String value = ops.get(key);
        return  value;
    }

    public void set(String key,String value){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key,value);
    }

}
