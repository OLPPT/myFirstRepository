package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by OL-PC on 2018/04/12.
 */
@Repository
public class RedisDaoImpl {

    RedisOperations redisOperations;

    @Autowired
    public RedisDaoImpl(@Qualifier("stringRedisTemplate") RedisOperations redisOperations){
        this.redisOperations = redisOperations;
    }

    public String add(String key,String value){
        redisOperations.opsForValue().set(key,value);
        return value;
    }
}
