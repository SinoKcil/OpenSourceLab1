package com.example.redisdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 通用的redis cache写入函数
 */
@Service
public class CacheService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void writeCache(String key,Object value){
        redisTemplate.opsForValue().set(key,value,180, TimeUnit.SECONDS);//设置180秒过期时间
    }

    public Object readCache(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void updateCache(String key,Object value){
        //手动更新重新写入。设置180秒过期时间
        redisTemplate.opsForValue().set(key,value,180, TimeUnit.SECONDS);
    }

   public void deleteCache(String key,Object value){
        redisTemplate.opsForValue().set(key,value,0, TimeUnit.SECONDS);
    }


}
