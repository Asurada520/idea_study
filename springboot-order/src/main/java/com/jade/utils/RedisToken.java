package com.jade.utils;


import com.jade.config.RedisConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RedisToken {

    @Autowired
    private RedisConfig redisConfig;

    private static final long TOKENTIMEOUT = 3 * 60 * 60;


    public String getToken() {
        // 生成token 规则保证 临时且唯一 不支持分布式场景 分布式全局ID生成规则
        String token = "token-" + UUID.randomUUID();
        // 如何保证token临时 （缓存）使用redis 实现缓存
        redisConfig.setString(token, token, TOKENTIMEOUT);
        return token;
    }

    /**
     * 查询key 判断是否存在
     * @param token key
     * @return
     */
    public synchronized boolean findToken(String token){
        String value = (String)redisConfig.getValue(token);

        if(StringUtils.isEmpty(value)){
            return false;
        }

        redisConfig.delKey(token);
        return true;

    }


}
