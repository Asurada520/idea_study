package com.ybzbcq.controller;


import com.ybzbcq.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.logging.Logger;

@RestController
@RequestMapping("/business/")
public class IndexController {

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("test")
    public Object getInfo(){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        return "success";
    }

    @RequestMapping("set")
    public String put(String key, String value){
        System.out.println("key "+ key + " value "+ value);
        redisClient.set(key,value,60l);
        return "success";
    }
    @RequestMapping("get")
    public String get(String key){
        return redisClient.get(key);
    }
}
