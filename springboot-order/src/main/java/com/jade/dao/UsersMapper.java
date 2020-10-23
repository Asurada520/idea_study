package com.jade.dao;

import com.jade.entity.Users;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


@CacheConfig(cacheNames = { "userCache" })
public interface UsersMapper {

    public List<Users> selectAll();

    public int insert(Users users);

    @Cacheable
    public Users selectInfoById(Users users);

}
