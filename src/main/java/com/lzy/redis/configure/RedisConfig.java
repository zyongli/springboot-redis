package com.lzy.redis.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class RedisConfig {
    @Autowired
    private  RedisTemplate<Object,  Object>  redisTemplate;

    @RequestMapping("/get")
    public String get(@RequestParam("name")String name){
        return (String)redisTemplate.opsForValue().get(name);
    }

    @RequestMapping("/set")
    public boolean set(@RequestParam("name") String name, @RequestParam("id")String id){
        redisTemplate.opsForValue().set(name,id);
        return true;
    }
}