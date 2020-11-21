package com.jade.service;

import com.jade.config.RedisConfig;
import com.jade.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private RedisConfig redisConfig;

    public Object put(String value){
        if(value == null){
            return null;
        }
        String token = getToken();
        redisConfig.setString(token,value,null);

        return token;
    }

    public String getToken(){
        return UUID.randomUUID().toString();
    }

    public Object get(String token){
        Object value = redisConfig.getValue(token);
        return value;
    }
}
