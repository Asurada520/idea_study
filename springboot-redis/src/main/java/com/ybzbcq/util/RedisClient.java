package com.ybzbcq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, Object object, Long timeout) {
        if (object instanceof String) {
            String value = (String) object;
            stringRedisTemplate.opsForValue().set(key, value);

        }
        if (object instanceof Set) {
            Set<String> values = (Set<String>) object;
            for (String value : values) {
                stringRedisTemplate.opsForSet().add(key, value);
            }
        }

        if (object instanceof List) {
            List values = (List) object;
            stringRedisTemplate.opsForList().leftPushAll(key, values);
        }

        stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}
