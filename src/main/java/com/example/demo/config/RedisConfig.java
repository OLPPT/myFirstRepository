package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by OL-PC on 2018/04/11.
 */
public class RedisConfig {
    @Bean(name = "redisCF")
    @ConfigurationProperties("spring.redis")
    public RedisConnectionFactory redisCF(){
        return new JedisConnectionFactory();
    }

    @Bean(name = "stringRedisTemplate")
    @Autowired
    @Qualifier("redisCF")
    public RedisOperations<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }
}
