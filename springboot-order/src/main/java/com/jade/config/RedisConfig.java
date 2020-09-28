package com.jade.config;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RedisConfig {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set redis key[String]-value[object]
     *
     * @param key
     * @param data
     * @param timeout
     */
    public void setString(String key, Object data, Long timeout) {
        if (data instanceof String) {
            String value = (String) data;
            stringRedisTemplate.opsForValue().set(key, value);

            System.out.println("key: " + key + ", value:" + value);
        }
        if (timeout != null) {
            Boolean expire = stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            System.out.println("expire：" + expire);
        }
    }

    /**
     * delete key-value
     *
     * @param key 键
     * @return
     */
    public boolean delKey(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * get value by key
     *
     * @param key
     * @return value
     */
    public Object getValue(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

}
