package com.ybzbcq.conf;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.security.Key;
import java.util.UUID;

/**
 * 基于 redis 实现分布式锁  核心方法  获取锁 释放锁
 */
public class LockRedis {

    private JedisPool jedisPool;

    private String redisLockKey = "redis_lock";

    public LockRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 获取锁
     *
     * @param acquireTimeout 获取锁之前 超时时间
     * @param timeout        获取锁之后 超时时间
     */
    public String getRedisLock(Long acquireTimeout, Long timeout) {
        Jedis jedisClient = null;
        try {
            jedisClient = jedisPool.getResource();

            String identitierValue = UUID.randomUUID().toString();

            // 定义 获取锁之后的超时时间
            int expireLock = (int) (timeout / 1000);

            Long endTime = System.currentTimeMillis() + acquireTimeout;
            while(System.currentTimeMillis() < endTime){
                Long isSuccess = jedisClient.setnx(redisLockKey, identitierValue);
                if(isSuccess == 1){
                    jedisClient.expire(redisLockKey,expireLock);
                    return identitierValue;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedisClient != null) {
                jedisClient.close();
            }
        }

        return null;

    }


    public void unRedisLock(String identifierValue) {
        Jedis jedisClient = null;
        try {
            jedisClient = jedisPool.getResource();

            String value = jedisClient.get(redisLockKey);
            if(identifierValue.equals(value)){
                System.out.println("释放锁..." + Thread.currentThread().getName() + ",identifierValue:" + identifierValue);
                jedisClient.del(redisLockKey);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedisClient != null) {
                jedisClient.close();
            }
        }
    }
}
