package com.example.redisdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    //在redis中以键值对方式缓存，一个键值对应的可能是字符串、数组等，所以value为object类型
    @Bean
    public RedisTemplate<String,Object> RedisConfig(RedisConnectionFactory factory){
        RedisTemplate<String,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());//设置键值和键名的序列化器
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }
}
