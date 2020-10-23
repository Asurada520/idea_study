package com.jade.service;


import com.alibaba.fastjson.JSONObject;
import com.jade.config.RedisConfig;
import com.jade.dao.UsersMapper;
import com.jade.entity.Users;
import com.jade.utils.EhCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private EhCacheUtils ehCacheUtils;

    private String cacheName = "userCache";

    public List<Users> selectAll() {
        List<Users> users = usersMapper.selectAll();
        return users;
    }

    public int insert(Users users) {
        int insert = usersMapper.insert(users);
        return insert;
    }

    public Users selectInfoById(Users users) {
        String id = users.getId();
        String key = this.getClass().getName() + "-" + Thread.currentThread().getStackTrace()[0].getMethodName() + "-" + id;
        Users usersEh = (Users)ehCacheUtils.get(cacheName, key);
        if(usersEh != null){
            log.info("一级缓存中获取数据：key="+key+", users="+usersEh.toString());
            return usersEh;
        }

        String userJson = (String)redisConfig.getValue(key);
        if(StringUtils.isNotEmpty(userJson)){
            JSONObject jsonObject = new JSONObject();
            Users userRedis = jsonObject.parseObject(userJson, Users.class);
            log.info("二级缓存中获取数据：key="+key+", users="+userRedis.toString());
            ehCacheUtils.put(cacheName,key,userRedis);
            return userRedis;
        }

        Users usersResult = usersMapper.selectInfoById(users);

        if(usersResult == null){
            return null;
        }
        redisConfig.setString(key,new JSONObject().toJSONString(usersResult));
        ehCacheUtils.put(cacheName,key,usersResult);

        return usersResult;
    }

}
